package com.example.play_station_system.users;

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
    private final userService userService;

    @GetMapping(path="admin/getUsers")
    public ResponseEntity<List<users>> getUsers(){

        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(path="admin/getUsersCount")
    public ResponseEntity<Integer> getUsersCount(){

        return ResponseEntity.ok().body(userService.getUsersCount());
    }

    @PostMapping(path="visitor/registerNewUser")
    public ResponseEntity<?> registerNewUser(@RequestBody users user){
        userService.addNewUser(user);
        return ResponseEntity.ok().build();
    }


}
