package com.sky.statistics.web.dao;

import com.sky.statistics.core.generic.GenericDao;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.model.UserLog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserLogMapper extends GenericDao<UserLog, Long> {
    @Override
	UserLog selectByPrimaryKey(Long id);
	@Override
	int insertSelective(UserLog userLog);
	@Override
	int updateByPrimaryKeySelective(UserLog userLog);
	@Override
	int deleteByPrimaryKey(Long id);

	//因为与User通过id关联，此参数名必须为User与UserLog的关联字段
	List<UserLog> selectUserLog(User id);

	int deleteByUserID(User id);

}

