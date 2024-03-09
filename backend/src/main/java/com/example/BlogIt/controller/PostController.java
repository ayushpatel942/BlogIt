package com.example.BlogIt.controller;

import com.example.BlogIt.constants.GlobalConstants;
import com.example.BlogIt.dto.PostDto;
import com.example.BlogIt.entities.Post;
import com.example.BlogIt.exceptions.ApiResponse;
import org.apache.tika.Tika;
import com.example.BlogIt.exceptions.CustomException;
import com.example.BlogIt.services.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PostController
{
    @Autowired
    private PostService postService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/users/{username}/posts/{categoryname}")
    public ResponseEntity<PostDto> createNewPostWithFormData(@RequestParam("post") String post,
                                                             @RequestParam(name = "image", required = false) MultipartFile file,
                                                             @PathVariable("username") String username, @PathVariable("categoryname") String categoryname) {

        Post createdpost = null;
        try {
            Post postdata = objectMapper.readValue(post, Post.class);
            createdpost = postService.createPostAndSaveImageInDB(postdata, username, categoryname, file);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<PostDto>(modelMapper.map(createdpost, PostDto.class), HttpStatus.CREATED);
    }

    @PostMapping("/users/{username}/posts/{postid}/image")
    public ResponseEntity<ApiResponse> addImageToPost(@RequestParam("image") MultipartFile image,
                                                      @PathVariable("username") String username, @PathVariable("postid") Integer postid) {

        postService.addImageToPost(image, username, postid);
        ApiResponse apiResponse = new ApiResponse("Image Successfully Added To The Post With Id :" + postid,
                LocalDateTime.now(), HttpStatus.OK, HttpStatus.OK.value());
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/images/servepostimage/{postid}")
    public ResponseEntity<byte[]> servePostImage(@PathVariable("postid") Integer postid) {
        Post foundPost = postService.getPostById(postid);
        if (foundPost.getImage().equals(GlobalConstants.DEFAULT_POST_IMAGE_NAME)) {
            throw new CustomException("Default Post Image is Set , Will Be Taken from frontend : "
                    + GlobalConstants.DEFAULT_POST_IMAGE_NAME, HttpStatus.OK);
        }
        // Detect MIME type of image data
        String contentType = new Tika().detect(foundPost.getImageData());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(contentType));
        return new ResponseEntity<>(foundPost.getImageData(), headers, HttpStatus.OK);
    }

    @GetMapping("/users/{username}/posts")
    public ResponseEntity<List<PostDto>> getPostByUsername(@PathVariable("username") String username,
                                                           @RequestParam(name = "mostrecentfirst", defaultValue = "true", required = false) Boolean mostrecentfirst) {
        List<PostDto> allPostsByUser = postService.getAllPostsByUser(username, mostrecentfirst).stream()
                .map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return new ResponseEntity<List<PostDto>>(allPostsByUser, HttpStatus.OK);
    }

    @GetMapping("/users/{username}/posts/{postid}")
    public ResponseEntity<PostDto> getPostOfUserByPostId(@PathVariable("username") String username,
                                                         @PathVariable("postid") Integer postid) {
        Post post = postService.getPostById(postid);
        return new ResponseEntity<PostDto>(modelMapper.map(post, PostDto.class), HttpStatus.OK);
    }

}












