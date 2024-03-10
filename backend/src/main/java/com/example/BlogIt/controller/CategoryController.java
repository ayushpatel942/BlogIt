package com.example.BlogIt.controller;

import com.example.BlogIt.dto.CategoryDto;
import com.example.BlogIt.entities.Category;
import com.example.BlogIt.exceptions.ApiResponse;
import com.example.BlogIt.services.CategoryService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CategoryController
{
    @Autowired
    CategoryService categoryService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/categories")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody Category category) {
        Category createdcategory = categoryService.createCategory(category);
        return new ResponseEntity<>(modelMapper.map(createdcategory,CategoryDto.class), HttpStatus.CREATED);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> allCategories = categoryService.getAllCategories().stream().map(category->modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @GetMapping("/categories/{cid}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("cid") Integer cid) {
        Category category = categoryService.getCategoryById(cid);
        return new ResponseEntity<>(modelMapper.map(category,CategoryDto.class), HttpStatus.OK);
    }

    @PutMapping("/categories/{cid}")
    public ResponseEntity<CategoryDto> updateCategoryById(@PathVariable("cid") Integer cid,
                                                          @Valid @RequestBody Category category) {
        Category updatedcategory = categoryService.updateCategory(category, cid);
        return new ResponseEntity<>(modelMapper.map(updatedcategory,CategoryDto.class), HttpStatus.OK);
    }

    @DeleteMapping("/categories/{cid}")
    public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable("cid") Integer cid) {
        categoryService.deleteCategory(cid);
        return new ResponseEntity<>(new ApiResponse("Category Successfully Deleted with id :" + cid,
                LocalDateTime.now(), HttpStatus.OK, HttpStatus.OK.value()), HttpStatus.OK);
    }

}
