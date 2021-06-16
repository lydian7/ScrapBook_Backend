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

        Room room = new Room("Memory Lane", "Giritli's ScrapBook", "123456", "ahmet@gmail.com");
        roomRepository.save(room);


        Room room2 = new Room("CodeClan Tears", "where tears come true...", "123456", "mary@gmail.com");

        roomRepository.save(room2);

        Room room3 = new Room("Time Machine", "Liam's ScrapBook", "123456", "liam@gmail.com");
        roomRepository.save(room3);

        Room room4 = new Room("Happy Times", "Pooja's ScrapBook", "123456", "pooja@gmail.com");
        roomRepository.save(room4);

        Room room5 = new Room("40th Birthday", "Ahmet's Birthday Party", "123456", "ahmet@gmail.com");
        roomRepository.save(room5);

        Room room6 = new Room("Cats", "Scrapbook of reasons why we live with these little terrors.", "123456", "mary@gmail.com");
        roomRepository.save(room6);

        Room room7 = new Room("CodeClan Tears", "Remembering React.", "123456", "mary@gmail.com");
        roomRepository.save(room7);



        User user = new User("ahmet@gmail.com","Ahmet","01/11/1974", "metallica");
        userRepository.save(user);

        User user2 = new User("mary@gmail.com", "Mary", "01/06/1978", "123456");
        userRepository.save(user2);

        User liam = new User("liam@gmail.com", "Liam", "01/01/1990", "123456");
        liam.setProfilePicture("https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fahmet-age-30.jpeg?alt=media&token=b04bc8b8-597c-4b95-a033-03527672e89d");
        userRepository.save(liam);

        User user4 = new User("pooja@gmail.com", "Pooja", "01/01/1990", "123456");
        userRepository.save(user4);

        Message message = new Message(user.getName(), LocalTime.now().toString(), "This is my first message!", room);
        messageRepository.save(message);



        Post post2 = new Post(LocalTime.now().toString(), "I love gaming", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/posts%2Fhorizon.jpeg?alt=media&token=109455a5-d14a-4553-8705-cbe66860a136", room3, liam);
        postRepository.save(post2);

        Post post8 = new Post(LocalTime.now().toString(), "coding is bae", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/posts%2Fcoding.png?alt=media&token=5cf161e4-6f28-4efc-a65b-e24e2f7ff7c7", room3, liam);
        postRepository.save(post8);


        Post post3 = new Post(LocalTime.now().toString(), "NOT AN IMAGE", "img/pic", room4, user2);
        postRepository.save(post3);

        Post post7 = new Post(LocalTime.now().toString(), "Glasgow Road Trip", "img/pic", room2, user2);
        postRepository.save(post7);


        Post post6 = new Post(LocalTime.now().toString(), "Party at Ally's", "img/pic", room2, user4);
        postRepository.save(post6);

        Post post9 = new Post(LocalTime.now().toString(), "Family Meal", "img/pic", room4, user4);
        postRepository.save(post9);



//        user.addRoom(room);
//        userRepository.save(user);

        room.addUser(user4);
        roomRepository.save(room);


        room2.addUser(user2);
        room2.addUser(liam);
        room2.addUser(user4);
        roomRepository.save(room2);


        room3.addUser(liam);
        roomRepository.save(room3);

        room4.addUser(user2);
        roomRepository.save(room4);


    }
}
