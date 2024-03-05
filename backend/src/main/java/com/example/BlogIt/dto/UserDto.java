package com.example.BlogIt.dto;

import com.example.BlogIt.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {
    private int uid;
    private String name;
    private String username;
    private String password;
    private String about;
    private String profilepic;
    private List<Role> roles;
}
