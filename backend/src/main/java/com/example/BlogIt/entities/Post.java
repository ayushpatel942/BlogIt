package com.example.BlogIt.entities;

import com.example.BlogIt.constants.GlobalConstants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String title;
    @Lob
    private String content;
    private String image= GlobalConstants.DEFAULT_POST_IMAGE_NAME;
    private Date date;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    @OneToMany(mappedBy ="post",cascade = CascadeType.ALL)
    private List<Comment> comments;
}