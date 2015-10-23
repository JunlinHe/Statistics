package com.sky.statistics.web.dao;

import com.sky.statistics.core.generic.GenericDao;
import com.sky.statistics.web.model.UserLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserLogMapper extends GenericDao<UserLog, Long> {
    @Override
	UserLog selectByPrimaryKey(Long id);
	@Override
	int insertSelective(UserLog UserLog);
	@Override
	int updateByPrimaryKeySelective(UserLog UserLog);
	@Override
	int deleteByPrimaryKey(Long id);


	List<UserLog> selectUserLog(Long userID);

	int deleteByUserID(Long userID);

}
