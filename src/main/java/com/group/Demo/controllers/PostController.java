package com.group.Demo.controllers;

import com.group.Demo.models.Comments;
import com.group.Demo.models.Post;
import com.group.Demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    @GetMapping("/get-all-posts")
    public ResponseEntity<List<Post>> getAllPosts(){
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/post-by-id/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        return  new ResponseEntity<>(postRepository.findById(id).orElse(null), HttpStatus.OK);
    }

    @PutMapping("/update-post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post updatePost){
        Optional<Post> existingPostOptional=postRepository.findById(id);
        if(existingPostOptional.isPresent()){
            Post existingPost=existingPostOptional.get();
            existingPost.setText(updatePost.getText());

            for(Comments updateComment: updatePost.getComments()){
                boolean commentExist=false;
                for(Comments existingComment: existingPost.getComments()){
                    if(existingComment.getId().equals(updateComment.getId())){
                        existingComment.setText(updateComment.getText());
                        commentExist=true;
                        break;
                    }
                }

            }
            return new ResponseEntity<>(postRepository.save(existingPost), HttpStatus.OK);
        }return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete-post/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long id){
        Optional<Post> existingPostOptional=postRepository.findById(id);
        if(existingPostOptional.isPresent()){
            postRepository.deleteById(id);
            return new ResponseEntity<>( HttpStatus.OK);
        }else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }
}
