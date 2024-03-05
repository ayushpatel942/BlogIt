package com.example.BlogIt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentDto
{
    private Integer cid;
    private String comment;
    private Date commentdate;
    private UserDto user;
}