package com.example.BlogIt.services.impl;

import java.util.Date;

import com.example.BlogIt.entities.Comment;
import com.example.BlogIt.entities.Post;
import com.example.BlogIt.entities.User;
import com.example.BlogIt.exceptions.CustomException;
import com.example.BlogIt.repositories.CommentRepository;
import com.example.BlogIt.repositories.PostRepository;
import com.example.BlogIt.repositories.UserRepository;
import com.example.BlogIt.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment, String username, Integer postid) {
        User founduser = userRepository.findUserByUsername(username).orElseThrow(
                () -> new CustomException("Username not found with name : " + username, HttpStatus.NOT_FOUND));
        Post foundpost = postRepository.findById(postid)
                .orElseThrow(() -> new CustomException("Post not found with id : " + postid, HttpStatus.NOT_FOUND));
        comment.setCommentdate(new Date());
        comment.setUser(founduser);
        comment.setPost(foundpost);
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(String username, Integer commentid) {
        userRepository.findUserByUsername(username).orElseThrow(
                () -> new CustomException("Username not found with name : " + username, HttpStatus.NOT_FOUND));
        commentRepository.findById(commentid).orElseThrow(
                () -> new CustomException("Comment not found with id : " + commentid, HttpStatus.NOT_FOUND));
        commentRepository.deleteById(commentid);
    }

}