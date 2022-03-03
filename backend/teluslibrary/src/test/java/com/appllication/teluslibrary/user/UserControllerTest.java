package com.appllication.teluslibrary.user;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appllication.teluslibrary.TeluslibraryApplication;
import com.appllication.teluslibrary.controllers.UserController;
import com.appllication.teluslibrary.entities.User;
import com.appllication.teluslibrary.payload.CreateUserDto;
import com.appllication.teluslibrary.payload.UpdateUserDto;
import com.appllication.teluslibrary.payload.UserDto;
import com.appllication.teluslibrary.services.UserService;
import com.appllication.teluslibrary.repositories.UserRepository;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TeluslibraryApplication.class)
public class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;

	//Get All User
	
		@Test
		void getAllUser() {
			List<User> Catalog = new ArrayList<>();
			
			//UserService userServiceMock = mock(UserService.class);
			//this.userController.setUs(userServiceMock);
			Mockito.when(userService.getUsers()).thenReturn(new ArrayList<UserDto>());
			
			List<UserDto> tmp_user = userController.getUsers();
			
			MatcherAssert.assertThat(tmp_user.size(), equalTo(Catalog.size()));
		}
		
		
		@Test
		void getUser() {
			
			UserDto user = new UserDto();
			user.setFirstName("Pancho");
			user.setLastName("Ramirez");
			user.setEmail("pancho@mail.com");
			user.setId(20L);
			
			//UserService userServiceMock = mock(UserService.class);
			//this.userController.setUs(userServiceMock);
			Mockito.when(userService.getUser(20L)).thenReturn(user);
			
			UserDto resultUser = userController.getUser(20L).getBody();
			
			MatcherAssert.assertThat(resultUser.getId(), equalTo(20L));
		}
		
		//Create User
		@Test
		void createUser() {
			
			CreateUserDto tmp = new CreateUserDto();
			tmp.firstName = "Mariana";
			tmp.lastName = "Gonzalez";
			tmp.email = "maria@mail.com";
			
			UserDto dt = new UserDto();
			dt.firstName = "Mariana";
			
			//UserService userServiceMock = mock(UserService.class);
			//this.userController.setUs(userServiceMock);
			Mockito.when(userService.createUser(tmp)).thenReturn(dt);
			
			UserDto tmp_user = userController.createUser(tmp).getBody();
			
			MatcherAssert.assertThat(tmp_user.firstName, equalTo("Mariana"));
		}
		
		
		//Update User
		@Test
		void updateUser() {
			
			User user = new User();
			user.setFirstName("Lucia");
			user.setLastName("Gonzalez");
			user.setEmail("lu@mail.com");
			user.setId(1L);
			
			UserDto tmp = new UserDto();
			tmp.setFirstName("Lucia");
			tmp.setLastName("Gonzalez");
			tmp.setEmail("lu@mail.com");
			tmp.setId(1L);
			//UserService usMock = mock(UserService.class);
			//this.userController.setUs(usMock);
			Mockito.when(userService.updateUser(user)).thenReturn(tmp);
			
			UserDto tmp_user = userController.updateUser(user);
			
			MatcherAssert.assertThat(tmp_user.firstName, equalTo("Lucia"));
			
		}
		
		//Delete User
		@Test
		void deleteUser() {
			User user = new User();
			user.setFirstName("Lucia");
			user.setLastName("Gonzalez");
			user.setEmail("lu@mail.com");
			user.setId(15L);
			
			//UserService usMock = mock(UserService.class);
			//this.userController.setUs(usMock);
			Mockito.when(userService.deleteUser(15L)).thenReturn(new ResponseEntity<>("User deleted successfully", HttpStatus.OK));
			
			ResponseEntity<String> tmp_user = userController.deleteUser(15L);
			
			//Assert.assertNull(tmp_user);
			MatcherAssert.assertThat(tmp_user, equalTo(new ResponseEntity<>("User deleted successfully", HttpStatus.OK)));
		}
		
		
}
