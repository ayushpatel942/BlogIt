package com.example.BlogIt.controller;

import com.example.BlogIt.entities.Post;
import com.example.BlogIt.entities.User;
import com.example.BlogIt.repositories.PostRepository;
import com.example.BlogIt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController
{
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/search/{query}")
    public ResponseEntity<List<Post>> search(@PathVariable("query") String query)
    {
        System.out.println(query);
        List<Post> postList = this.postRepository.findByTitleContaining(query);

        return new ResponseEntity<List<Post>>(postList, HttpStatus.OK);
    }
}
