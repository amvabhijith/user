package com.altran.user.service;

import com.altran.user.model.User;
import com.altran.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

/**
 * Created by 4013707 on 4/17/2020.
 */
public class UserServiceTest {


    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void testGetUserDetails() {
    	User user = new User(1, "amvabhijith", "pass123","pass123","abhijith","am");
    	when(userRepository.findByUserName("amvabhijith")).thenReturn(user);
    	
    	User result = userService.getUserDetails("amvabhijith");
		assertEquals(1, result.getUserId());
		assertEquals("amvabhijith", result.getUserName());
		assertEquals("pass123", result.getPassword());
		assertEquals("pass123", result.getPasswordConfirm());
		assertEquals("abhijith", result.getFirstName());
		assertEquals("am", result.getLastName());
    }

    @Test
    void testRegistration() {
    	User user = new User(1, "amvabhijith", "pass123","pass123","abhijith","am");
    	when(userRepository.save(user)).thenReturn(user);
    	
    	User result = userService.registration(user);
		assertEquals(1, result.getUserId());
		assertEquals("amvabhijith", result.getUserName());
		assertEquals("pass123", result.getPassword());
		assertEquals("pass123", result.getPasswordConfirm());
		assertEquals("abhijith", result.getFirstName());
		assertEquals("am", result.getLastName());
    }
}