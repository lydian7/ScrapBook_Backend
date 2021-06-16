package com.ScrapBook.scrapbook_service_db;

import com.ScrapBook.scrapbook_service_db.models.Post;
import com.ScrapBook.scrapbook_service_db.models.Room;
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

import java.util.List;

import static org.junit.Assert.assertEquals;

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
		User user = new User("ahmet@gmail.com", "Ahmet", "01/11/1974", "metallica");
		userRepository.save(user);
	}

	@Test
	public void canFindAllUsers() {
		List<User> found = userRepository.findAll();
		assertEquals(4, found.size());
	}

	@Test
	public void canGetUserById() {
		User found = userRepository.getById(1L);

	}

	@Test
	public void canFindUserByNameAndPassword() {
	User found = userRepository.findByEmailAndPassword("Pooja", "123456");

	}

	@Test
	public void createRoomThenSave() {
		Room room = new Room("Memory Lane", "Giritli's ScrapBook", "123456", "ahmet@gmail.com");
		roomRepository.save(room);
	}


	@Test
	public void canFindRoomByUsersId() {
	List<Room> foundRooms = roomRepository.findByUsersId(2L);
		assertEquals("CodeClan Tears", foundRooms.get(0).getRoomName());
		assertEquals(2,foundRooms.size() );

	}

	@Test
	public void canFindPostByRoomId() {
		List<Post> foundPost = postRepository.findByRoomId(1L);
		assertEquals(6, foundPost.size());
		assertEquals("Route(r) 666", foundPost.get(0).getCaption());
	}

//	@Test
//	public void canGetAllMessages() {
//		List<Message> foundMessage = messageRepository.findAll();
//		assertEquals(1, foundMessage.size());
//		assertEquals("This is my first message!", foundMessage.get(0).getMessage());
//	}

	@Test
	void cantAddDuplicateUser() {
		User user = new User("ahmet@gmail.com","Ahmet","01/11/1974", "metallica");
		Room room = new Room("Memory Lane", "Giritli's ScrapBook", "123456", "ahmet@gmail.com");
		room.addUser(user);
		room.addUser(user);
		assertEquals(1, room.getUsers().size());
	}

	@Test
	void canFindUserByEmail() {
		userRepository.findByEmail("ahmet@gmail.com");

	}

	@Test
	void canGetRoomByNameAndEmail() {
		roomRepository.findByRoomNameAndAdmin("Memory Lane", "ahmet@gmail.com");
	}

	@Test
	void canFindMessagesByRoomId() {
		messageRepository.findByRoomId(1L);

	}
}
