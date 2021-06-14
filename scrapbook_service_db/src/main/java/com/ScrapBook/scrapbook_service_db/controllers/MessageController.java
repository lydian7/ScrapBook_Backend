package com.ScrapBook.scrapbook_service_db.controllers;

import com.ScrapBook.scrapbook_service_db.models.Message;
import com.ScrapBook.scrapbook_service_db.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @GetMapping(value = "/messages")
    public ResponseEntity<List<Message>>  getAllMessages(){
        return new ResponseEntity<>(messageRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/messages")
    public ResponseEntity postMessage(@RequestBody Message message){
        messageRepository.save(message);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @MessageMapping("/sendMessage") //all messages sent from client to here will be re-directed to below route
    @SendTo("/topic/public") //sends a message to the /topic/public url that stomp is subscribed to
    public Message sendMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }

}
