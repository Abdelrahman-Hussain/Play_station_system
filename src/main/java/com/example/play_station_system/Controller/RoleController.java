package com.example.play_station_system.Controller;

import com.example.play_station_system.Model.Role;
import com.example.play_station_system.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class RoleController {


    @Autowired
    RoleService roleService;
//    @PostMapping(value = "/addRole/{roleName}")
//    void addRole(@PathVariable String roleName){
//        roleService.addNewRole(roleName);
//    }

    @PostMapping(path="admin/addNewRole")
    public ResponseEntity<Role> addRole(@RequestBody Role role){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/addNewRole").toUriString());
        return ResponseEntity.created(uri).body(roleService.addNewRole(role));
    }
}
