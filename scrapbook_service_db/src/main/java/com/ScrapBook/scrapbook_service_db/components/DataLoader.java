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




        Room room2 = new Room("Memories", "Mary's ScrapBook", "123456", "mary@gmail.com");

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

        User user3 = new User("liam@gmail.com", "Liam", "01/01/1990", "123456");
        userRepository.save(user3);

        User user4 = new User("pooja@gmail.com", "Pooja", "01/01/1990", "123456");
        userRepository.save(user4);

        Message message = new Message(user.getName(), LocalTime.now().toString(), "This is my first message!", room);
        messageRepository.save(message);

        Post post = new Post(LocalTime.now().toString(),"My first time skydiving", "img/pic", room2, user);
        postRepository.save(post);

        Post post1 = new Post(LocalTime.now().toString(), "Hello World", "img/pic", room2, user);
        postRepository.save(post1);

        Post post2 = new Post(LocalTime.now().toString(), "I love REACT", "img/pic", room3, user3);
        postRepository.save(post2);


        Post post3 = new Post(LocalTime.now().toString(), "NOT AN IMAGE", "img/pic", room4, user2);

        postRepository.save(post3);

        Post post4 = new Post(LocalTime.now().toString(), "Visiting Edinburgh Castle", "img/pic", room2, user);
        postRepository.save(post4);

        Post post5 = new Post(LocalTime.now().toString(), "Day at the Beach", "img/pic", room2, user3);
        postRepository.save(post5);

        Post post6 = new Post(LocalTime.now().toString(), "Party at Ally's", "img/pic", room3, user4);
        postRepository.save(post6);

        Post post7 = new Post(LocalTime.now().toString(), "Glasgow Road Trip", "img/pic", room3, user2);
        postRepository.save(post7);

        Post post8 = new Post(LocalTime.now().toString(), "Climbing Holiday", "img/pic", room3, user3);
        postRepository.save(post1);

        Post post9 = new Post(LocalTime.now().toString(), "Family Meal", "img/pic", room4, user4);
        postRepository.save(post2);

        Post post10 = new Post(LocalTime.now().toString(), "Cutting the Cake", "img/pic", room5, user3);
        postRepository.save(post3);

        Post post11 = new Post(LocalTime.now().toString(), "Night Out", "img/pic", room6, user);
        postRepository.save(post4);

        Post post12 = new Post(LocalTime.now().toString(), "Getting up to Mischief", "img/pic", room6, user3);
        postRepository.save(post5);

        Post post13 = new Post(LocalTime.now().toString(), "Cohort Social", "img/pic", room7, user2);
        postRepository.save(post6);

        Post post14 = new Post(LocalTime.now().toString(), "Graduation", "img/pic", room7, user);
        postRepository.save(post7);






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
