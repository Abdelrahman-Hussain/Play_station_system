package com.example.play_station_system.Controller;

import com.example.play_station_system.Model.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
@RequiredArgsConstructor
public class userController {
    private final com.example.play_station_system.Service.userService userService;

    @GetMapping(path="admin/getUsers")
    public ResponseEntity<List<SiteUser>> getUsers(){

        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(path="admin/getUsersCount")
    public ResponseEntity<Integer> getUsersCount(){

        return ResponseEntity.ok().body(userService.getUsersCount());
    }

    @PostMapping(path="visitor/registerNewUser")
    public ResponseEntity<?> registerNewUser(@RequestBody SiteUser user){
        userService.addNewUser(user);
        return ResponseEntity.ok().build();
    }


}
