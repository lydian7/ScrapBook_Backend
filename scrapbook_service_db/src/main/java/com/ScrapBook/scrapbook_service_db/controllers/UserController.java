package com.ScrapBook.scrapbook_service_db.controllers;

import com.ScrapBook.scrapbook_service_db.models.User;
import com.ScrapBook.scrapbook_service_db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;


    @GetMapping(value ="/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity addUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/user/{id}")
    public ResponseEntity <User> deleteUser(@PathVariable Long id){
        User found = userRepository.getById(id);
        userRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(value ="/users/login")
    public ResponseEntity getByUserNameAndPassword
            (@RequestParam(name ="name" , required = false) String name, @RequestParam(name ="password", required = false) String password){
        User found = userRepository.findByNameAndPassword(name, password);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping(value ="users/signup")
    public ResponseEntity<User> getByEmail(@RequestParam(name="email", required=false) String email){
        User found = userRepository.findByEmail(email);
        return new ResponseEntity<User>(found, HttpStatus.OK);
    }

}
