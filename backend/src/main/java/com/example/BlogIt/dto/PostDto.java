package com.example.BlogIt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class PostDto {
    private int pid;
    private String title;
    private String content;
    private String image;
    private Date date;
    private CategoryDto category;
    private UserDto user;
    private List<CommentDto> comments;
}
