package com.sky.statistics.web.service;

import com.sky.statistics.core.feature.orm.mybatis.Page;
import com.sky.statistics.core.generic.GenericService;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.model.UserLog;
import com.sky.statistics.web.model.UserLogExample;

import java.util.List;

/**
 * Created by User on 2015/10/22.
 */
public interface UserLogService extends GenericService<UserLog, Long>{

    List<UserLog> selectUserLog(User userID);

    int deleteByUserID(User userID);

    /**
     * 分页条件查询
     *
     * @param page
     * @param example
     * @return
     */
    List<UserLog> selectByExampleAndPage(Page<UserLog> page, UserLogExample example);
}
