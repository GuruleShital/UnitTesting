package com.example.controller;

import com.example.model.User;
import com.example.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User saveUser = userServiceI.createUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);//status code:200

    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId) throws Exception {

        User singleUser = userServiceI.getSingleUser(userId);
        return new ResponseEntity<>(singleUser, HttpStatus.OK);
    }

    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUser() {

        List<User> allUser = userServiceI.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);

    }
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long userId){

        User user1 = userServiceI.updateUser(user, userId);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    public  ResponseEntity<String> deleteUSer(@PathVariable Long userId){

        userServiceI.deleteUser(userId);
        return new ResponseEntity<>("User Deleted Successfully..",HttpStatus.OK);

    }
}
