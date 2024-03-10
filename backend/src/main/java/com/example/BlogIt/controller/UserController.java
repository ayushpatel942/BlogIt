package com.example.BlogIt.controller;

import com.example.BlogIt.dto.UserDto;
import com.example.BlogIt.entities.User;
import com.example.BlogIt.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    // GET SINGLE USER
    @GetMapping("/users/{username}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return new ResponseEntity<UserDto>(modelMapper.map(user, UserDto.class), HttpStatus.OK);
    }
}
