package com.example.play_station_system.Service;
import com.example.play_station_system.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private com.example.play_station_system.Repo.roleRepo roleRepo;

//    public void addNewRole(String role){
//        Role role1 = new  Role();
//        role1.setName(role);
//        roleRepo.save(role1);
//    }
    public Role addNewRole(Role role){
        return roleRepo.save(role);
    }
}
