package com.appllication.teluslibrary;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appllication.teluslibrary.controllers.UserController;
import com.appllication.teluslibrary.entities.User;
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
		
		User user = new User();
		user.setFirstName("Pancho");
		user.setLastName("Ramirez");
		user.setEmail("pancho@mail.com");
		user.setId(20L);
		
		UserService userServiceMock = mock(UserService.class);
		Mockito.when(userServiceMock.getUser(20L)).thenReturn(userService.mapUserToDto(user));
		
		UserDto tmp_user = userController.getUser(20L).getBody();
		
		MatcherAssert.assertThat(tmp_user.id, equalTo(20L));
	}
}
