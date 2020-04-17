package com.altran.user.service;

import com.altran.user.model.User;
import com.altran.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    final void testGetUser() {
        User user = new User(1,"amvabhijith","12345","12345","abhijith","am");
        when(userRepository.findByUserName(anyString())).thenReturn(user);

        User user1 = userService.getUserDetails("amvabhijith");

        assertNotNull(user1);
        assertEquals("amvabhijith",user.getUserName());
    }

}