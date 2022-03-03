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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appllication.teluslibrary.TeluslibraryApplication;
import com.appllication.teluslibrary.entities.User;
import com.appllication.teluslibrary.payload.UserDto;
import com.appllication.teluslibrary.repositories.UserRepository;
import com.appllication.teluslibrary.services.LoanService;
import com.appllication.teluslibrary.services.UserService;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TeluslibraryApplication.class)
public class UserServiceTestGetUser {

	@InjectMocks
	UserService userService;
	@Mock
	UserRepository userRepository;
	@Mock
	LoanService loanService;
	
	@Test
	void getUser_Service() {
		List<User> catalog = new ArrayList<User>();
		
		UserRepository usRepo = mock(UserRepository.class);
		Mockito.when(usRepo.findAll()).thenReturn(catalog);
		
		List<UserDto> tmp_user = userService.getUsers();
		
		MatcherAssert.assertThat(tmp_user.size(), equalTo(catalog.size()));
	}
	
}
