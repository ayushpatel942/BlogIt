package com.example.BlogIt.repositories;

import java.util.Optional;

import com.example.BlogIt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByUsernameAndPassword(String username,String password);

}
