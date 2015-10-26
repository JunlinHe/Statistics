package com.sky.statistics.web.service;

import com.sky.statistics.web.model.User;
import com.sky.statistics.core.generic.GenericService;

import java.util.List;

/**
 * Created by User on 2015/10/22.
 */
public interface UserService extends GenericService<User, Long>{

    /**
     * 用户验证
     *
     * @param user
     * @return
     */
    User authentication(User user);

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    User selectByUsername(String username);
}
