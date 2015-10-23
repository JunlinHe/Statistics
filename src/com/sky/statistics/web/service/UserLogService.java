package com.sky.statistics.web.service;

import com.sky.statistics.core.generic.GenericService;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.model.UserLog;

import java.util.List;

/**
 * Created by User on 2015/10/22.
 */
public interface UserLogService extends GenericService<UserLog, Long>{

    List<UserLog> selectUserLog(Long userID);

    int deleteByUserID(Long userID);
}
