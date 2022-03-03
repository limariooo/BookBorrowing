package com.appllication.teluslibrary.user;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appllication.teluslibrary.TeluslibraryApplication;
import com.appllication.teluslibrary.entities.User;

import com.appllication.teluslibrary.repositories.UserRepository;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TeluslibraryApplication.class)
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
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
