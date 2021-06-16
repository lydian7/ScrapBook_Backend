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

import java.time.LocalDateTime;
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

        //ROOMS

        Room codeClanRoom = new Room("CodeClan Tears", "where tears come true...", "123456", "mary@gmail.com");
        roomRepository.save(codeClanRoom);

        Room liamRoom = new Room("Time Machine", "Liam's ScrapBook", "123456", "liam@gmail.com");
        roomRepository.save(liamRoom);

        Room poojaRoom = new Room("Happy Times", "Pooja's ScrapBook", "123456", "pooja@gmail.com");
        roomRepository.save(poojaRoom);

        Room maryRoom = new Room("Baby Yoda", "So Cute", "123456", "mary@gmail.com");
        roomRepository.save(maryRoom);


        //USERS

        User mary = new User("mary@gmail.com", "Mary", "01/01/1978", "1234");
        mary.setProfilePicture("https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fm5fgn.jpg?alt=media&token=dc6e853a-44d6-4162-8bcf-185db1656593");
        userRepository.save(mary);

        User liam = new User("liam@gmail.com", "Liam", "01/01/1990", "1234");
        liam.setProfilePicture("https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fahmet-age-30.jpeg?alt=media&token=b04bc8b8-597c-4b95-a033-03527672e89d");
        userRepository.save(liam);

        User pooja = new User("pooja@gmail.com", "Pooja", "01/01/1990", "1234");
        pooja.setProfilePicture("https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fpooja.jpeg?alt=media&token=8418f4ee-3ae3-4bf3-b131-ff4dad89eda9");
        userRepository.save(pooja);


        // ============= POSTS

        //LIAM

        Post liamPost1 = new Post(LocalTime.now().toString(), "I love gaming", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/posts%2Fhorizon.jpeg?alt=media&token=109455a5-d14a-4553-8705-cbe66860a136", liamRoom, liam);
        postRepository.save(liamPost1);

        Post liamPost2 = new Post(LocalTime.now().toString(), "coding is bae", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/posts%2Fcoding.png?alt=media&token=5cf161e4-6f28-4efc-a65b-e24e2f7ff7c7", liamRoom, liam);
        postRepository.save(liamPost2);

        //MARY

        Post maryPost1 = new Post(LocalTime.now().toString(), "Coffee Break", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fdinner.jpg?alt=media&token=86999a92-9bf6-444f-8e20-9a26da27b3e8", maryRoom, mary);
        postRepository.save(maryPost1);

        Post maryPost2 = new Post(LocalTime.now().toString(), "Lovely Flowers", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fflowers.jpg?alt=media&token=081433e4-b37d-4d54-a63a-c2401805807e", maryRoom, mary);
        postRepository.save(maryPost2);

        Post maryPost3 = new Post(LocalTime.now().toString(), "Camping", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fcamping.jpg?alt=media&token=098b4ca3-f93a-4397-956f-2111ce4597e6", maryRoom, mary);
        postRepository.save(maryPost3);

        Post maryPost4 = new Post(LocalTime.now().toString(), "Selfie", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/profile-pics%2Fselfie.jpg?alt=media&token=fe58b6cd-f5b0-4c24-abfa-b1a514f549cb", maryRoom, mary);
        postRepository.save(maryPost4);

        //POOJA

        Post poojaPost1 = new Post(LocalTime.now().toString(), "Happy Times", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/posts%2FWhatsApp%20Image%202021-06-16%20at%205.33.08%20PM.jpeg?alt=media&token=5dd0b50c-baba-4121-92df-d4157c2d99e3", poojaRoom, pooja);
        postRepository.save(poojaPost1);

        Post poojaPost2 = new Post(LocalTime.now().toString(), "Indian Cooking", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/posts%2FWhatsApp%20Image%202021-06-16%20at%205.32.10%20PM.jpeg?alt=media&token=05d357b9-34e2-4c19-b279-ca5b96d36649", poojaRoom, pooja);
        postRepository.save(poojaPost2);

        // MIXED POSTS FOR CODECLANROOM

        Post liamPost3 = new Post(LocalTime.now().toString(), "Route(r) 666", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/posts%2FRoute66.png?alt=media&token=4b871d5b-fbf3-4df4-bb9e-a14dedb5284f", codeClanRoom, liam);
        postRepository.save(liamPost3);

        Post liamPost4 = new Post(LocalTime.now().toString(), "CodeClan graduation be like...", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/posts%2FCodeClanGraduation.png?alt=media&token=c265fbd3-6241-4737-bef3-c8ab7949c725", codeClanRoom, liam);
        postRepository.save(liamPost4);

        Post maryPost5 = new Post(LocalTime.now().toString(), "CSS be like...", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/posts%2Fcssmeme.gif?alt=media&token=dbff997d-452f-48e7-bdce-5d5fbf3547ba", codeClanRoom, mary);
        postRepository.save(maryPost5);

        Post maryPost6 = new Post(LocalTime.now().toString(), "Jinja", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/posts%2FJinja.png?alt=media&token=92e3623f-7a9a-453f-a389-f4b79aeff71d", codeClanRoom, mary);
        postRepository.save(maryPost6);

        Post poojaPost3 = new Post(LocalTime.now().toString(), "Test Driven Delirium", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/posts%2FTestDrivenDelirium.png?alt=media&token=60d373c6-d782-4db1-b2f5-1980c895fe9e", codeClanRoom, pooja);
        postRepository.save(poojaPost3);

        Post poojaPost4 = new Post(LocalTime.now().toString(), "Sunny Aberdeen", "https://firebasestorage.googleapis.com/v0/b/scrapbook-245c8.appspot.com/o/posts%2Faberdeenbeach.jpeg?alt=media&token=d0b3efae-4f7e-4195-a712-431340e18328", codeClanRoom, pooja);
        postRepository.save(poojaPost4);

        // ================================

        //ADD USERS TO ROOMS

        codeClanRoom.addUser(mary);
        codeClanRoom.addUser(liam);
        codeClanRoom.addUser(pooja);
        roomRepository.save(codeClanRoom);


        liamRoom.addUser(liam);
        roomRepository.save(liamRoom);


        maryRoom.addUser(mary);
        roomRepository.save(maryRoom);

        poojaRoom.addUser(pooja);
        roomRepository.save(poojaRoom);

        //===================================

        //ADD CHAT TO ROOMS


        LocalDateTime now = LocalDateTime.now();

        // CODECLAN TEARS CHAT

        Message liamMessage1 = new Message("Liam", now.toString(), "Hey troops!!!", codeClanRoom );
        messageRepository.save(liamMessage1);

        Message PoojaMessage1 = new Message("Pooja", now.toString(), "Hi Liam!", codeClanRoom );
        messageRepository.save(PoojaMessage1);

        Message liamMessage2 = new Message("Liam", now.toString(), "Anyone know when we're supposed to finish the PDA by?", codeClanRoom );
        messageRepository.save(liamMessage2);

        Message maryMessage1 = new Message("Mary", now.toString(), "What's a PDA?", codeClanRoom );
        messageRepository.save(maryMessage1);

        Message liamMessage3 = new Message("Liam", now.toString(), "Actually I'm not too sure, I think it means 'Peter Demands Authority'?", codeClanRoom );
        messageRepository.save(liamMessage3);

        Message poojaMessage2 = new Message("Pooja", now.toString(), "Waaait a minute!! Is that the thing Peter constantly reminds us about?", codeClanRoom );
        messageRepository.save(poojaMessage2);

        Message liamMessage4 = new Message("Liam", now.toString(), "Yeah but tbh I heard they just pass the ones you haven't done as a graduation gift, it's from a legit source btw...", codeClanRoom );
        messageRepository.save(liamMessage4);

        Message maryMessage2 = new Message("Mary", now.toString(), "Soooooo, spit it out Liam, let's hear who it is then :)", codeClanRoom );
        messageRepository.save(maryMessage2);

        Message liamMessage5 = new Message("Liam", now.toString(), "It was Al..", codeClanRoom );
        messageRepository.save(liamMessage5);

        //









    }
}
