package com.example.BlogIt.services.impl;

import com.example.BlogIt.constants.GlobalConstants;
import com.example.BlogIt.dto.PostResponseDto;
import com.example.BlogIt.entities.Post;
import com.example.BlogIt.entities.User;
import com.example.BlogIt.exceptions.ApiResponse;
import com.example.BlogIt.exceptions.CustomException;
import com.example.BlogIt.repositories.CategoryRepository;
import com.example.BlogIt.repositories.PostRepository;
import com.example.BlogIt.repositories.UserRepository;
import com.example.BlogIt.services.FileService;
import com.example.BlogIt.services.PostService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService
{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FileService fileService;

    @Override
    public Post createPostAndSaveImageInDB(Post post, String username, String categoryname, MultipartFile file) {
        return null;
    }

    @Override
    public Post getPostById(Integer id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new CustomException("Post not found with id :" + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Post addImageToPost(MultipartFile file, String username, Integer postid) {
        userRepository.findUserByUsername(username.toLowerCase())
                .orElseThrow(() -> new CustomException("User Not Found with username : " + username.toLowerCase(),
                        HttpStatus.NOT_FOUND));

        Post foundPost = postRepository.findById(postid)
                .orElseThrow(() -> new CustomException("Post not found with id :" + postid, HttpStatus.NOT_FOUND));

        if (file != null && fileService.isImageWithValidExtension(file)) {
            try {
                byte[] imageData = file.getBytes();
                foundPost.setImageData(imageData);
                foundPost.setImage(GlobalConstants.POST_IMAGE_UPLOADED);
            } catch (Exception e) {
                log.error("Error In Adding Image To A Post!!");
                throw new CustomException("Error In Adding Image To A Post!!", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return postRepository.save(foundPost);
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
        Sort sort = Sort.by(mostrecentfirst ? Sort.Direction.DESC : Sort.Direction.ASC, "date");
        User founduser = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new CustomException("Username not found in DB :" + username, HttpStatus.NOT_FOUND));
        return postRepository.findPostByUser(founduser, sort);
    }
}
