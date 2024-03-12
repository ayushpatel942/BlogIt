package com.example.BlogIt.controller;

import com.example.BlogIt.dto.UserDto;
import com.example.BlogIt.entities.User;
import com.example.BlogIt.exceptions.CustomException;
import com.example.BlogIt.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modeMapper;

    @PostMapping("/api/login")
    public ResponseEntity<UserDto> performLogin(@RequestBody User user){
        User founduser = userRepository.findUserByUsernameAndPassword(user.getUsername(),user.getPassword()).orElseThrow(() -> new CustomException("Invalid Credentials !!",
                HttpStatus.UNAUTHORIZED));
        return new ResponseEntity<UserDto>( modeMapper.map(founduser,UserDto.class),HttpStatus.OK);
    }
}