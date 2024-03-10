package com.example.BlogIt.services.impl;

import com.example.BlogIt.entities.User;
import com.example.BlogIt.exceptions.CustomException;
import com.example.BlogIt.repositories.UserRepository;
import com.example.BlogIt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUserByUsername(User user, String username) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        User foundUser = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new CustomException("User Not Found with username : " + username.toLowerCase(),
                        HttpStatus.NOT_FOUND));
        return foundUser;
    }

    @Override
    public boolean deleteUserByUsername(String username) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
