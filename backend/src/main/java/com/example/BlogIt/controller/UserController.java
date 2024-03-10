package com.example.BlogIt.controller;

import com.example.BlogIt.constants.GlobalConstants;
import com.example.BlogIt.dto.UserDto;
import com.example.BlogIt.entities.User;
import com.example.BlogIt.exceptions.ApiResponse;
import com.example.BlogIt.exceptions.CustomException;
import com.example.BlogIt.services.UserService;
import org.apache.tika.Tika;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    @GetMapping(value = "/images/serveuserimage/{username}")
    public ResponseEntity<byte[]> serveUserProfileImage(@PathVariable("username") String username) {
        User foundUser = userService.getUserByUsername(username);
        if (foundUser.getProfilepic().equals(GlobalConstants.DEFAULT_PROFILE_IMAGE_NAME)) {
            throw new CustomException("Default Image is Set , Will Be Taken from frontend : "
                    + GlobalConstants.DEFAULT_PROFILE_IMAGE_NAME, HttpStatus.OK);
        }
        // Detect MIME type of image data
        String contentType = new Tika().detect(foundUser.getImageData());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(contentType));
        return new ResponseEntity<>(foundUser.getImageData(), headers, HttpStatus.OK);
    }

    @PutMapping("/users/{username}")
    public ResponseEntity<UserDto> updateSingleUser(@RequestBody User user, @PathVariable String username) {
        User updateduser = userService.updateUserByUsername(user, username);
        return new ResponseEntity<UserDto>(modelMapper.map(updateduser, UserDto.class), HttpStatus.OK);
    }

    @DeleteMapping("/users")
    public ResponseEntity<ApiResponse> deleteAllUsers() {
        userService.deleteAllUsers();
        ApiResponse apiResponse = new ApiResponse("All Users Deleted Successfully !!", LocalDateTime.now(),
                HttpStatus.OK, HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    
}
