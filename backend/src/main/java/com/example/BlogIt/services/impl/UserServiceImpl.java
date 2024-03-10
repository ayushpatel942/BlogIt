package com.example.BlogIt.services.impl;

import com.example.BlogIt.constants.GlobalConstants;
import com.example.BlogIt.entities.Role;
import com.example.BlogIt.entities.User;
import com.example.BlogIt.exceptions.CustomException;
import com.example.BlogIt.repositories.RoleRepository;
import com.example.BlogIt.repositories.UserRepository;
import com.example.BlogIt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user) {
        if (userRepository.findUserByUsername(user.getUsername().toLowerCase()).isPresent())
            throw new CustomException("Username already taken : " + (user.getUsername().toLowerCase()),
                    HttpStatus.CONFLICT);
        user.setUsername(user.getUsername().toLowerCase());
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByRoleName(GlobalConstants.ROLE_NORMAL));
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public User updateUserByUsername(User user, String username) {
        User founduser = userRepository.findUserByUsername(username.toLowerCase())
                .orElseThrow(() -> new CustomException("User Not Found with username : " + username.toLowerCase(),
                        HttpStatus.NOT_FOUND));
        if (user.getUsername() != null) {
            if (userRepository.findUserByUsername(user.getUsername().toLowerCase()).isPresent())
                throw new CustomException("Username already taken : " + (user.getUsername().toLowerCase()),
                        HttpStatus.CONFLICT);
        }

        founduser.setName(user.getName() == null ? founduser.getName() : user.getName());
        founduser.setUsername(user.getUsername() == null ? founduser.getUsername().toLowerCase() : user.getUsername().toLowerCase());
        founduser.setPassword(user.getPassword() == null ? founduser.getPassword() : user.getPassword());
        founduser.setAbout(user.getAbout() == null ? founduser.getAbout() : user.getAbout());
        User updateduser = userRepository.save(founduser);
        return updateduser;
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
        User foundUser = userRepository.findUserByUsername(username).orElseThrow(
                () -> new CustomException("User Not Found with username : " + username, HttpStatus.NOT_FOUND));
        userRepository.deleteById(foundUser.getUid());
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allusers = userRepository.findAll();
        if (allusers.size() == 0)
            throw new CustomException("No users found in DB !!", HttpStatus.NOT_FOUND);

        return allusers;
    }

    @Override
    public boolean deleteAllUsers() {
        userRepository.deleteAll();
        return true;
    }
}
