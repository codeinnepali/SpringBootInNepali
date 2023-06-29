package com.group.Demo.controllers;

import com.group.Demo.models.Comments;
import com.group.Demo.models.Post;
import com.group.Demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;


    @PostMapping("/add-post")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        for(Comments comments: post.getComments()){
            comments.setPost(post);
        }
        Post _post=postRepository.save(post);
        return new ResponseEntity<>(_post, HttpStatus.CREATED);
    }
}
