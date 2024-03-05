package com.example.BlogIt.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @NotEmpty(message = "Category name must not be empty or null")
    private String name;

    @NotEmpty(message = "Category description must not be empty or null")
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    List<Post> posts=new ArrayList<>();
}
