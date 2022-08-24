package com.example.play_station_system.users;

import com.example.play_station_system.Role.Role;
import com.example.play_station_system.Role.roleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class userConfig   {

    @Autowired
    roleRepo roleRepo;
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(usersRepository repository){
        return args->{
            users abdo = new users(
                    1,
                    "admin@gmail.com",
                    "$2a$10$0iGFreRcDbWAkC6Mf0osjOTGhuEV96QeTFOk68asnYPGuZoR4Sv6q"//123 encripted

            );
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepo.findByName("ROLE_ADMIN"));
            roles.add(roleRepo.findByName("ROLE_USER"));

            abdo.setRoles(roles);
            repository.saveAll(List.of(abdo));
        };
    }
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/api/**");
//            }
//        };
//    }
}
