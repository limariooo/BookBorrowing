package com.appllication.teluslibrary;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	//Controllers
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
	
	
	//Get All Users Error linea 50
	/*
	@Test
	void getAllUser() {
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
		user.setFirstName("Mariana");
		user.setLastName("Gonzalez");
		user.setEmail("mariana2@mail.com");
		
		CreateUserDto tmp = new CreateUserDto();
		tmp.firstName = "Mariana";
		tmp.lastName = "Gonzalez";
		tmp.email = "maria@mail.com";
		
		UserService userServiceMock = mock(UserService.class);
		Mockito.when(userServiceMock.createUser(tmp)).thenReturn(userService.mapUserToDto(user));
		
		UserDto tmp_user = userController.createUser(tmp).getBody();
		
		MatcherAssert.assertThat(tmp_user.firstName, equalTo("Mariana"));
	}
	*/
	
	//GetUsersService
	/* Error Mapping ModelMapper 
	@Test
	void getUser_Service() {
		List<User> catalog = userRepository.findAll();
		
		UserRepository usRepo = mock(UserRepository.class);
		Mockito.when(usRepo.findAll()).thenReturn(catalog);
		
		List<UserDto> tmp_user = userService.getUsers();//Mapping ModelMapper
		
		MatcherAssert.assertThat(tmp_user.size(), equalTo(catalog.size()));
	}
	*/
	
	//Update user
	/*
	@Test
	void updateUser() {
		
	}
	*/
	
	//Delete user
	
	
	//Create User with Service	
	@Test
	void createUser_Service() {
		
		User user = new User();
		user.setFirstName("Matheo");
		user.setLastName("Nuñez");
		user.setEmail("matheo@mail.com");
		
		CreateUserDto tmp = new CreateUserDto();
		tmp.firstName = "Matheo";
		tmp.lastName = "Nuñez";
		tmp.email = "matheo@mail.com";
		
		UserRepository usRepo = mock(UserRepository.class);
		//this.userController.setUs(userServiceMock);
		Mockito.when(usRepo.save(user)).thenReturn(user);
		
		UserDto tmp_user = userService.createUser(tmp);
		
		MatcherAssert.assertThat(tmp_user.email, equalTo("matheo@mail.com"));
	}
	
	//Get User by Id
	@Test
	void getUser_ID_Service() {
		User user = new User();
		user.setFirstName("Mateo");
		user.setLastName("Calderon");
		user.setEmail("ca@mail.com");
		user.setId(12L);
		
		UserRepository usRepo = mock(UserRepository.class);
		Mockito.when(usRepo.findById(12L)).thenReturn(Optional.of(user));
		
		UserDto tmp_user = userService.getUser(12L);
		
		MatcherAssert.assertThat(tmp_user.id, equalTo(12L));
	}
	
	@Test
	void findById() {
		User user = userRepository.findById(15L).get();
		MatcherAssert.assertThat(user.getId(), equalTo(15L));
	}
	
	@Test
	void save() {
		User user = new User();
		user.setFirstName("Saul");
		user.setLastName("Gimenez");
		user.setEmail("saul@mail.com");
		
		User tmp = userRepository.save(user);
		MatcherAssert.assertThat(tmp.getEmail(), equalTo("saul@mail.com"));
	}
	
	
	
	
}
