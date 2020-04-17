package com.altran.user.repository;

import com.altran.user.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 4013707 on 4/16/2020.
 */
public interface UserRepository  extends CrudRepository<User,Long>{
    public User findByUserName(String userName);
}
