package com.group.Demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Post {

    @Id
    private  Long id;


    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comments> comments;
}
