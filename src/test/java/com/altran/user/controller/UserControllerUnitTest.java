package com.altran.user.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.altran.user.model.User;
import com.altran.user.repository.UserRepository;
import com.altran.user.service.UserService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class UserControllerUnitTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	@Mock
	UserRepository userRepository;


	@Test 
	void testRegistration() { 
		MockHttpServletRequest request = new MockHttpServletRequest(); 
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

//		when(userService.registration(any(User.class))).thenReturn(true);
		
		User user1 = new User();
		when(userService.registration(any(User.class))).thenReturn(user1);

		User user = new User(1, "amvabhijith", "pass123","pass123","abhijith","am");
		ResponseEntity<User> responseEntity = userController.registration(user);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}


	@Test 
	void testGetUserDetails() {
		User user = new User(1, "amvabhijith","pass123","pass123","abhijith","am");
		
		/*when(userRepository.findByUserName("amvabhijith")).thenReturn(user);

		
		 * //when 
		 * User result = userService.getUserDetails("amvabhijith");
		 * 
		 * // then 
		 * 
		 * assertEquals(result.getUserName(),user.getUserName());
		 * 
		 * assertEquals(result.getPassword(), user.getPassword());
		 * 
		 * assertEquals(result.getFirstName(),user.getFirstName());
		 * 
		 * assertEquals(result.getLastName(),user.getLastName());
		 */

		// 
		when(userService.getUserDetails("amvabhijith")).thenReturn(user); 
		
		// when
		ResponseEntity<User> result = userController.getUserDetails("amvabhijith");

		// then 
		assertEquals(result.getBody().getUserName(),user.getUserName());

		assertEquals(result.getBody().getPassword(), user.getPassword());

		assertEquals(result.getBody().getFirstName(),user.getFirstName());

		assertEquals(result.getBody().getLastName(),user.getLastName());



	}


}
