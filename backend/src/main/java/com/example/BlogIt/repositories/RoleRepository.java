package com.example.BlogIt.repositories;

import com.example.BlogIt.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRoleName(String name);
}
