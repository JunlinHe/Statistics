package com.sky.statistics.web.service.impl;

import com.sky.statistics.core.generic.GenericDao;
import com.sky.statistics.core.generic.GenericServiceImpl;
import com.sky.statistics.web.dao.IUserMapper;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by User on 2015/10/22.
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {
    @Resource
    private IUserMapper userMapper;

    @Override
    public int insert(User model) { return userMapper.insertSelective(model); }

    @Override
    public int update(User model) {
        return userMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public GenericDao<User, Long> getDao() {
        return userMapper;
    }


    @Override
    public  User authentication(User record){ return  userMapper.authentication(record);}

    @Override
    public List<User> selectUsers(String username) { return userMapper.selectUsers(username); }
}
