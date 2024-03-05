package com.example.BlogIt.repositories;

import com.example.BlogIt.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
