package com.sky.statistics.web.service;

import com.sky.statistics.web.model.User;
import com.sky.statistics.core.generic.GenericService;

import java.util.List;

/**
 * Created by User on 2015/10/22.
 */
public interface UserService extends GenericService<User, Long>{

    User authentication(User record);

    List<User> selectUsers(String username);
}
