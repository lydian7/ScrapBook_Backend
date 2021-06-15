package com.ScrapBook.scrapbook_service_db.controllers;

import com.ScrapBook.scrapbook_service_db.models.Room;
import com.ScrapBook.scrapbook_service_db.models.User;
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

    @GetMapping(value = "/rooms/room")
    public ResponseEntity<Room> getRoomByNameAndEmail(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "email", required = false) String email){
        Room foundRoom = roomRepository.findByRoomNameAndAdmin(name, email);
        return new ResponseEntity<>(foundRoom, HttpStatus.OK);
    }

    @GetMapping(value = "/rooms/{id}")
    public ResponseEntity getByRoomId(@PathVariable Long id) {
        return new ResponseEntity(roomRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/rooms")
    public ResponseEntity postRoom(@RequestBody Room room){
        roomRepository.save(room);
        return new ResponseEntity(room, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/rooms/{id}")
    public ResponseEntity deleteRoom(@PathVariable Long id) {
        System.out.println(id);
        Room found = roomRepository.getById(id);
        roomRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @PutMapping(value = "/rooms/{id}")
    public ResponseEntity<Room> patchAddUserToRoom(@PathVariable Long id, @RequestBody User user){
        Room room = roomRepository.getById(id);
        room.addUser(user);
        roomRepository.save(room);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
