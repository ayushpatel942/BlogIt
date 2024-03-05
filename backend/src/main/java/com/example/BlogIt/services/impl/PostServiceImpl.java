package com.example.BlogIt.services.impl;

import com.example.BlogIt.dto.PostResponseDto;
import com.example.BlogIt.entities.Post;
import com.example.BlogIt.repositories.PostRepository;
import com.example.BlogIt.services.PostService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class PostServiceImpl implements PostService {
    @Override
    public Post createPost(Post post, String username, String categoryname, MultipartFile file, String folderpath) {
        return null;
    }

    @Override
    public Post getPostById(Integer id) {
        return null;
    }

    @Override
    public Post updatePostById(Post newpostdata, Integer postid, String username) {
        return null;
    }

    @Override
    public void deletePostById(Integer id) {

    }

    @Override
    public PostResponseDto getAllPosts(Integer pagenumber, Integer pagesize, boolean mostrecentfirst) {
        return null;
    }

    @Override
    public PostResponseDto getAllPostsByCategory(String category, Integer pagenumber, Integer pagesize, boolean mostrecentfirst) {
        return null;
    }

    @Override
    public List<Post> getAllPostsByUser(String username, boolean mostrecentfirst) {
        return null;
    }
}
