package com.example.BlogIt.services;

import com.example.BlogIt.dto.PostResponseDto;
import com.example.BlogIt.entities.Post;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {

    Post createPostAndSaveImageInDB(Post post, String username, String categoryname, MultipartFile file);

    Post getPostById(Integer id);

    Post addImageToPost(MultipartFile image, String username, Integer postid);

    Post updatePostById(Post newpostdata, Integer postid, String username);

    void deletePostById(Integer id);

    PostResponseDto getAllPosts(Integer pagenumber, Integer pagesize, boolean mostrecentfirst);

    PostResponseDto getAllPostsByCategory(String category, Integer pagenumber, Integer pagesize,
                                          boolean mostrecentfirst);

    List<Post> getAllPostsByUser(String username, boolean mostrecentfirst);
}
