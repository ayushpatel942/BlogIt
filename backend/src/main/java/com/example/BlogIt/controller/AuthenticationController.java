package com.example.BlogIt.controller;

import com.example.BlogIt.dto.UserDto;
import com.example.BlogIt.entities.User;
import com.example.BlogIt.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController
{
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/api/login")
    public ResponseEntity<UserDto> performLogin(@RequestBody User user){
        User founduser = userRepository.findUserByUsernameAndPassword(user.getUsername(),user.getPassword()).orElseThrow();
        return new ResponseEntity<UserDto>( modelMapper.map(founduser,UserDto.class),HttpStatus.OK);
    }
}
