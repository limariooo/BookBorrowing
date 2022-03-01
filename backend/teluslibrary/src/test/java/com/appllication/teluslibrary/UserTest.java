package com.appllication.teluslibrary;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appllication.teluslibrary.controllers.UserController;
import com.appllication.teluslibrary.entities.Book;
import com.appllication.teluslibrary.entities.User;
import com.appllication.teluslibrary.payload.CreateUserDto;
import com.appllication.teluslibrary.payload.UserDto;
import com.appllication.teluslibrary.repositories.UserRepository;
import com.appllication.teluslibrary.services.UserService;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TeluslibraryApplication.class)
public class UserTest {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserController userController;
	
	//Get Users
	@Test
	void getUser() {
		
		UserDto user = new UserDto();
		user.setFirstName("Pancho");
		user.setLastName("Ramirez");
		user.setEmail("pancho@mail.com");
		user.setId(20L);
		
		UserService userServiceMock = mock(UserService.class);
		this.userController.setUs(userServiceMock);
		Mockito.when(userServiceMock.getUser(20L)).thenReturn(user);
		
		UserDto resultUser = userController.getUser(20L).getBody();
		
		MatcherAssert.assertThat(resultUser.getId(), equalTo(20L));
	}
	
	//Get All users
	/*
	@Test
	void getAllUsers(){
		
		List<User> Catalog = userRepository.findAll();
		
		UserService userServiceMock = mock(UserService.class);
		Mockito.when(userServiceMock.getUsers()).thenReturn(new ArrayList<UserDto>());
		
		List<UserDto> tmp_user = userController.getUsers();
		
		MatcherAssert.assertThat(tmp_user.size(), equalTo(Catalog.size()));
	}
	*/
	
	//Create User
	/*
	@Test
	void createUser() {
		
		User user = new User();
		user.setFirstName("Matheo");
		user.setLastName("Nuñez");
		user.setEmail("matheo@mail.com");
		
		CreateUserDto tmp = new CreateUserDto();
		tmp.firstName = "Matheo";
		tmp.lastName = "Nuñez";
		tmp.email = "matheo@mail.com";
		
		UserService userServiceMock = mock(UserService.class);
		Mockito.when(userServiceMock.createUser(tmp)).thenReturn(userService.mapUserToDto(user));
		
		UserDto tmp_user = userController.createUser(tmp).getBody();
		
		MatcherAssert.assertThat(tmp_user.email, equalTo("matheo@mail.com"));
		
		
	}
	*/
	
}
