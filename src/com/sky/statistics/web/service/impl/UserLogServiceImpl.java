package com.sky.statistics.web.service.impl;

import com.sky.statistics.core.annotation.SystemServiceLog;
import com.sky.statistics.core.feature.orm.mybatis.Page;
import com.sky.statistics.core.generic.GenericDao;
import com.sky.statistics.core.generic.GenericServiceImpl;
import com.sky.statistics.web.dao.IUserLogMapper;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.model.UserLog;
import com.sky.statistics.web.model.UserLogExample;
import com.sky.statistics.web.model.vo.ClientVO;
import com.sky.statistics.web.service.UserLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by User on 2015/10/22.
 */
@Service
public class UserLogServiceImpl extends GenericServiceImpl<UserLog, Long> implements UserLogService {
    @Resource
    private IUserLogMapper userLogMapper;

    @Override
    public int insert(UserLog model) { return userLogMapper.insertSelective(model); }

    @Override
    public int update(UserLog model) {
        return userLogMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    @SystemServiceLog(description = "删除日志")
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
    public List<UserLog> selectUserLog(User userID){ return userLogMapper.selectUserLog(userID);}

    @Override
    @SystemServiceLog(description = "根据用户ID删除日志")
    public int deleteByUserID(User userID){ return userLogMapper.deleteByUserID(userID);}

    @Override
    @SystemServiceLog(description = "根据条件删除日志")
    public int deleteByExample(UserLogExample example) {
        return userLogMapper.deleteByExample(example);
    }

    /**
     * 分页条件查询
     *
     * @param page
     * @param example
     * @return
     */
    @Override
    public List<UserLog> selectByExampleAndPage(Page<UserLog> page, UserLogExample example){ return userLogMapper.selectByExampleAndPage(page, example);}

    /**
     * 统计终端注册情况
     * @return
     */
    @Override
    public List<ClientVO> selectClient(){
        return userLogMapper.selectClient();
    }
}
