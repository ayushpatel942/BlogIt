package com.example.BlogIt.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class PostResponseDto
{
    private List<PostDto> posts;
    private Integer currentpage;
    private Integer totalpage;
    private long totalposts;
    private boolean islastpage;
}
