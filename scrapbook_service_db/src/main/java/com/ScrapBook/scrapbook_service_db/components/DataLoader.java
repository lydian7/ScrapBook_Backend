package com.ScrapBook.scrapbook_service_db.components;

import com.ScrapBook.scrapbook_service_db.models.Message;
import com.ScrapBook.scrapbook_service_db.models.Post;
import com.ScrapBook.scrapbook_service_db.models.Room;
import com.ScrapBook.scrapbook_service_db.models.User;
import com.ScrapBook.scrapbook_service_db.repositories.MessageRepository;
import com.ScrapBook.scrapbook_service_db.repositories.PostRepository;
import com.ScrapBook.scrapbook_service_db.repositories.RoomRepository;
import com.ScrapBook.scrapbook_service_db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PostRepository postRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;


    public DataLoader(){
    }

    public void run(ApplicationArguments args){

        Room room = new Room("Memory Lane", "Giritli's ScrapBook", "123456");
        roomRepository.save(room);

        Room room2 = new Room("Memories", "Mary's ScrapBook", "123456");
        roomRepository.save(room2);

        Room room3 = new Room("Time Machine", "Liam's ScrapBook", "123456");
        roomRepository.save(room3);

        Room room4 = new Room("Happy Times", "Pooja's ScrapBook", "123456");
        roomRepository.save(room4);

        Room room5 = new Room("40th Birthday", "Ahmet's Birthday Party", "123456");
        roomRepository.save(room5);

        Room room6 = new Room("Cats", "Scrapbook of reasons why we live with these little terrors.", "123456");
        roomRepository.save(room6);

        Room room7 = new Room("CodeClan Tears", "Remembering React.", "123456");
        roomRepository.save(room7);



        User user = new User("Ahmet", "Old boy", "mehehehehe", "01/11/1974", "metallica");
        userRepository.save(user);

        User user2 = new User("Mary", "Young at heart", "mehehehehe", "01/06/1978", "123456");
        userRepository.save(user2);

        User user3 = new User("Liam", "Coding Nomad", "mehehehehe", "01/01/1990", "123456");
        userRepository.save(user3);

        User user4 = new User("Pooja", "Testing Genius", "mehehehehe", "01/01/1990", "123456");
        userRepository.save(user4);

        Message message = new Message(user.getName(), LocalTime.now().toString(), "This is my first message!", room);
        messageRepository.save(message);

        Post post = new Post(LocalTime.now().toString(), user, "My first time skydiving", "img/pic");
        postRepository.save(post);


//        user.addRoom(room);
//        userRepository.save(user);

        room.addUser(user);
        roomRepository.save(room);

        room2.addUser(user);
        room2.addUser(user2);
        room2.addUser(user3);
        room2.addUser(user4);
        roomRepository.save(room2);

        room3.addUser(user2);
        room3.addUser(user3);
        roomRepository.save(room3);

        room4.addUser(user);
        room4.addUser(user2);
        room4.addUser(user3);
        room4.addUser(user4);
        roomRepository.save(room4);

        room5.addUser(user);
        room5.addUser(user4);
        roomRepository.save(room5);

        room6.addUser(user);
        room6.addUser(user2);
        room6.addUser(user3);
        room6.addUser(user4);
        roomRepository.save(room6);

        room7.addUser(user2);
        room7.addUser(user3);
        room7.addUser(user4);
        roomRepository.save(room7);

    }
}
