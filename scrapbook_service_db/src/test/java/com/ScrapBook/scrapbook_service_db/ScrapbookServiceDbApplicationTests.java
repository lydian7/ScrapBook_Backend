package com.ScrapBook.scrapbook_service_db;

import com.ScrapBook.scrapbook_service_db.models.User;
import com.ScrapBook.scrapbook_service_db.repositories.MessageRepository;
import com.ScrapBook.scrapbook_service_db.repositories.PostRepository;
import com.ScrapBook.scrapbook_service_db.repositories.RoomRepository;
import com.ScrapBook.scrapbook_service_db.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ScrapbookServiceDbApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	MessageRepository messageRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createUserThenSave() {

		User user = new User("Ahmet", "Old boy", "mehehehehe", "01/11/1974", "metallica");
		userRepository.save(user);
	}

	@Test
	public void canFindUserByNameAndPassword() {
		User found = userRepository.findByNameAndPassword("Ahmet", "metallica");

	}

	
}
