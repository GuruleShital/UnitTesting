package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserServiceI {


    //Create
    User createUser(User user);

    //Update

    User updateUser(User user, Long userId);

    //get:single recod
    User getSingleUser(Long userId);

    //get:Allrecord
    List<User> getAllUser();

    //delete:not return
    void deleteUser(Long userId);

}
