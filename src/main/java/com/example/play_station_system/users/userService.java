package com.example.play_station_system.users;

import com.example.play_station_system.Role.Role;
import com.example.play_station_system.Role.roleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class userService  implements UserDetailsService {

    private final usersRepository usersRepository;
    private final roleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        users user = usersRepository.findusersByEmail(email);
        if(user==null){
            log.error("User not found");
            throw new UsernameNotFoundException("User not found");
        }else {
            log.info("user found:{}",email);
        }
        Collection<SimpleGrantedAuthority>authorities=new ArrayList<>();
        user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getName()));});
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    public List<users> getUsers(){
        return  usersRepository.findAll();
    }
    public int getUsersCount(){
        return  usersRepository.findAll().size();
    }

    public users addNewUser(users user) {

            user.setPassword(passwordEncoder.encode(user.getPassword()));
             List<Role> roles = new ArrayList<>();
             roles.add(roleRepo.findByName("ROLE_USER"));
            user.setRoles(roles);
            return usersRepository.save(user);
    }



}
