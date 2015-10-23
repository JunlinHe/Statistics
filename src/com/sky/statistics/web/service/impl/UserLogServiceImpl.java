package com.sky.statistics.web.service.impl;

import com.sky.statistics.core.encoder.Md5PwdEncoder;
import com.sky.statistics.core.generic.GenericDao;
import com.sky.statistics.core.generic.GenericServiceImpl;
import com.sky.statistics.core.util.StringUtil;
import com.sky.statistics.web.dao.IUserLogMapper;
import com.sky.statistics.web.dao.IUserMapper;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.model.UserLog;
import com.sky.statistics.web.service.UserLogService;
import com.sky.statistics.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 2015/10/22.
 */
@Service
public class UserLogServiceImpl extends GenericServiceImpl<UserLog, Long> implements UserLogService {
    @Resource
    private IUserLogMapper userLogMapper;

    @Override
    public int insert(UserLog model) {return userLogMapper.insertSelective(model);}

    @Override
    public int update(UserLog model) {
        return userLogMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(Long id) {
        return userLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UserLog selectById(Long id) {
        return userLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public GenericDao<UserLog, Long> getDao() {
        return userLogMapper;
    }


    @Override
    public List<UserLog> selectUserLog(Long userID){ return userLogMapper.selectUserLog(userID);}

    @Override
    public int deleteByUserID(Long userID){ return userLogMapper.deleteByUserID(userID);}
}
