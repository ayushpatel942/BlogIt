package com.example.BlogIt.entities;

import com.example.BlogIt.constants.GlobalConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @NotEmpty(message = "Name cannot be Empty or Null")
    private String name;

    @NotEmpty(message = "Username cannot be Empty or Null")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "Password cannot be Empty or Null")
    @Size(min = 5,max = 20,message = "Password must be of length in between 5-20")
    private String password;

    private String about;

    private String profilepic= GlobalConstants.DEFAULT_POST_IMAGE_NAME;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Post> allposts=new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns =@JoinColumn(name="uid",referencedColumnName = "uid"),inverseJoinColumns = @JoinColumn(name="rid",referencedColumnName = "rid"))
    private List<Role> roles;
}
