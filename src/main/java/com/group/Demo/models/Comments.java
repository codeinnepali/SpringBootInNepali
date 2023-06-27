package com.group.Demo.models;

import jakarta.persistence.*;

@Entity
public class Comments {
    @Id
    private  Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional =true)
    @JoinColumn(name = "post_id", nullable = true)
    private  Post post;
}
