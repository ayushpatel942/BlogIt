package com.example.BlogIt.services;

import com.example.BlogIt.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUserByUsername(User user,String username);
    User getUserByUsername(String username);
    boolean deleteUserByUsername(String username);
    boolean deleteAllUsers();
    List<User> getAllUsers();
}
