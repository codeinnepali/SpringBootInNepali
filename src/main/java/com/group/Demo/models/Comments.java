package com.group.Demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String text;
    @ManyToOne(fetch = FetchType.EAGER, optional =true)
    @JoinColumn(name = "post_id", nullable = true)
    @JsonIgnore
    private  Post post;
}
