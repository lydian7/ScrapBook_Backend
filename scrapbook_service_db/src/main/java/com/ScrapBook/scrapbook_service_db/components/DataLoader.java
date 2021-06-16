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

        Room room7 = new Room("Baby Yoda", "So Cute", "123456", "mary@gmail.com");
        roomRepository.save(room7);



        User user = new User("ahmet@gmail.com","Ahmet","01/11/1974", "metallica");
        userRepository.save(user);

        User mary = new User("mary@gmail.com", "Mary", "01/01/1978", "123456");
        mary.setProfilePicture("https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fm5fgn.jpg?alt=media&token=dc6e853a-44d6-4162-8bcf-185db1656593");

        userRepository.save(mary);

        User liam = new User("liam@gmail.com", "Liam", "01/01/1990", "123456");
        liam.setProfilePicture("https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fahmet-age-30.jpeg?alt=media&token=b04bc8b8-597c-4b95-a033-03527672e89d");
        userRepository.save(liam);

        User user4 = new User("pooja@gmail.com", "Pooja", "01/01/1990", "123456");
        userRepository.save(user4);

        Message message = new Message(user.getName(), LocalTime.now().toString(), "This is my first message!", room);
        messageRepository.save(message);



        Post post2 = new Post(LocalTime.now().toString(), "I love REACT", "img/pic", room3, liam);
        postRepository.save(post2);

        Post post8 = new Post(LocalTime.now().toString(), "Climbing Holiday", "img/pic", room3, liam);
        postRepository.save(post8);


        Post post3 = new Post(LocalTime.now().toString(), "Coffee Break", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fdinner.jpg?alt=media&token=86999a92-9bf6-444f-8e20-9a26da27b3e8", room7, mary);
        postRepository.save(post3);

        Post post7 = new Post(LocalTime.now().toString(), "Lovely Flowers", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fflowers.jpg?alt=media&token=081433e4-b37d-4d54-a63a-c2401805807e", room7, mary);
        postRepository.save(post7);

        Post post10 = new Post(LocalTime.now().toString(), "Camping", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fcamping.jpg?alt=media&token=098b4ca3-f93a-4397-956f-2111ce4597e6", room7, mary);
        postRepository.save(post10);

        Post post11 = new Post(LocalTime.now().toString(), "Selfie", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fselfie.jpg?alt=media&token=fe58b6cd-f5b0-4c24-abfa-b1a514f549cb", room7, mary);
        postRepository.save(post11);


        Post post6 = new Post(LocalTime.now().toString(), "Party at Ally's", "img/pic", room2, user4);
        postRepository.save(post6);

        Post post9 = new Post(LocalTime.now().toString(), "Family Meal", "img/pic", room4, user4);
        postRepository.save(post9);



//        user.addRoom(room);
//        userRepository.save(user);

        room.addUser(user4);
        roomRepository.save(room);


        room2.addUser(mary);
        room2.addUser(liam);
        room2.addUser(user4);
        roomRepository.save(room2);


        room3.addUser(liam);
        roomRepository.save(room3);

        room7.addUser(mary);
        roomRepository.save(room7);


    }
}
