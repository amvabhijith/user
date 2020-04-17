package com.altran.user.service;

import com.altran.user.model.User;
import com.altran.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 4013707 on 4/16/2020.
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registration(User user){
        return userRepository.save(user);
    }

    public User getUserDetails(String userName){
        return userRepository.findByUserName(userName);
    }
}
