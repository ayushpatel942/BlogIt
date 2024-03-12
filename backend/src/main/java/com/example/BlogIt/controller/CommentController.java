package com.example.BlogIt.controller;

import java.time.LocalDateTime;

import com.example.BlogIt.dto.CommentDto;
import com.example.BlogIt.entities.Comment;
import com.example.BlogIt.exceptions.ApiResponse;
import com.example.BlogIt.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/users/{username}/posts/{postid}/comments")
    public ResponseEntity<CommentDto> addNewComment(@RequestBody Comment comment,
                                                    @PathVariable("username") String username, @PathVariable("postid") Integer postid) {
        Comment createdComment = commentService.createComment(comment, username, postid);
        return new ResponseEntity<>(modelMapper.map(createdComment, CommentDto.class), HttpStatus.CREATED);
    }

    // delete single comment of a post
    @DeleteMapping("/users/{username}/posts/{postid}/comments/{commentid}")
    public ResponseEntity<ApiResponse> deleteCommentByCommentId(@PathVariable("username") String username,
                                                                @PathVariable("postid") Integer postid, @PathVariable("commentid") Integer commentid) {

        commentService.deleteComment(username, commentid);
        ApiResponse apiResponse = new ApiResponse("Comment Successfully Deleted with id :" + commentid,
                LocalDateTime.now(), HttpStatus.OK, HttpStatus.OK.value());
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}