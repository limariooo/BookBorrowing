package com.appllication.teluslibrary.user;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appllication.teluslibrary.TeluslibraryApplication;
import com.appllication.teluslibrary.entities.User;
import com.appllication.teluslibrary.payload.CreateUserDto;
import com.appllication.teluslibrary.payload.UpdateUserDto;
import com.appllication.teluslibrary.payload.UserDto;
import com.appllication.teluslibrary.repositories.UserRepository;
import com.appllication.teluslibrary.services.LoanService;
import com.appllication.teluslibrary.services.UserService;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TeluslibraryApplication.class)
public class UserServiceTest {
	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	@Mock
	LoanService loanService;
	
	
	//Get User by Id
		@Test
		void getUser_ID_Service() {
			
			User user = new User();
			user.setFirstName("Mateo");
			user.setLastName("Calderon");
			user.setEmail("ca@mail.com");
			user.setId(12L);
			
			Mockito.when(userRepository.findById(12L)).thenReturn(Optional.of(user));
			
			UserDto tmp_user = userService.getUser(12L);
			
			MatcherAssert.assertThat(tmp_user.id, equalTo(12L));
		}
		
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
			/*
			UserDto tmp2 = new UserDto();
			tmp2.email = "matheo@mail.com";
			*/
			Mockito.when(userRepository.save(user)).thenReturn(user);
			
			UserDto tmp_user = userService.createUser(tmp);
			
			MatcherAssert.assertThat(tmp_user.email, equalTo("matheo@mail.com"));
		}	
		
		//Update User
		@Test
		void updateUser_Service() {
			
			User user = new User();
			user.setFirstName("Lorena");
			user.setLastName("Giron");
			user.setEmail("lo@mail.com");
			
			Mockito.when(userRepository.save(user)).thenReturn(user);
			
			UserDto tmp_user = userService.updateUser(user);
			
			MatcherAssert.assertThat(tmp_user.firstName, equalTo("Lorena"));
		}
			
		//Delete user
		@Test
		void deleteUser_Service() {
			
			User user = new User();
			user.setFirstName("Mario");
			user.setLastName("Gonzalez");
			user.setEmail("ma@mail.com");
			user.setId(25L);
			
			
			//this.userService.setUs(usMock);
			Mockito.when(userRepository.save(user)).thenReturn(user);
			
			ResponseEntity<String> tmp_user = userService.deleteUser(25L);
			
			MatcherAssert.assertThat(tmp_user, equalTo(new ResponseEntity<>("User deleted successfully", HttpStatus.OK)));
			
		}
		
		//GetUsersService
		//LastOne
		
		@Test
		void getUser_Service() {
			List<User> catalog = new ArrayList<User>();
			
			UserRepository usRepo = mock(UserRepository.class);
			//this.userService.setUs(usRepo);
			Mockito.when(usRepo.findAll()).thenReturn(catalog);
			
			List<UserDto> tmp_user = userService.getUsers();//Mapping ModelMapper
			
			MatcherAssert.assertThat(tmp_user.size(), equalTo(catalog.size()));
		}
		
}
