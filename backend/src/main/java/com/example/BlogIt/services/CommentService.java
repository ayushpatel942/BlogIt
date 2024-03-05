package com.example.BlogIt.services;

import com.example.BlogIt.entities.Comment;

public interface CommentService {

    Comment createComment(Comment comment, String username, Integer postid);
    void deleteComment(String username,Integer commentid);
}
