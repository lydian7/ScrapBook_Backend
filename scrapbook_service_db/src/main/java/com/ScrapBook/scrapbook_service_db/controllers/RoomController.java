package com.ScrapBook.scrapbook_service_db.controllers;

import com.ScrapBook.scrapbook_service_db.models.Room;
import com.ScrapBook.scrapbook_service_db.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @GetMapping(value = "/rooms")
    public ResponseEntity<List<Room>> getAllRooms(){
        return new ResponseEntity<>(roomRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/rooms/users")
    public ResponseEntity findByUserId(@RequestParam(name="user_id", required = false) Long user_id){
        List<Room> findRoom = roomRepository.findByUsersId(user_id);
        return new ResponseEntity<>(findRoom, HttpStatus.OK);
    }

    @GetMapping(value = "rooms/{id}")
    public ResponseEntity getByRoomId(@PathVariable Long id) {
        return new ResponseEntity(roomRepository.findById(id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/rooms/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable Long id) {
        Room found = roomRepository.getById(id);
        roomRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
