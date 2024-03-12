package com.example.BlogIt.repositories;

import java.util.Optional;

import com.example.BlogIt.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Optional<Category> findCategoryByName(String categoryname);
}
