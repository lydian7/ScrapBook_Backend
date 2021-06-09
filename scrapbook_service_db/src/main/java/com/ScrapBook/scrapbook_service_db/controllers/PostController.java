package com.ScrapBook.scrapbook_service_db.controllers;

import com.ScrapBook.scrapbook_service_db.models.Post;
import com.ScrapBook.scrapbook_service_db.models.User;
import com.ScrapBook.scrapbook_service_db.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping(value = "/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);

    }

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return new ResponseEntity<>(postRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/posts/users")
    public ResponseEntity findByUserId(@RequestParam(name="user_id", required = false) Long user_id){
         List<Post> findPost = postRepository.findByUserId(user_id);
        return new ResponseEntity<>(findPost, HttpStatus.OK);
    }



    @PostMapping(value = "/posts")
    public ResponseEntity addPost(@RequestBody Post post) {
        postRepository.save(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/post/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long id) {
        Post found = postRepository.getById(id);
        postRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}







