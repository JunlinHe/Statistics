package com.sky.statistics.web.dao;

import java.util.List;
import com.sky.statistics.core.generic.GenericDao;
import com.sky.statistics.web.model.User;
import org.springframework.stereotype.Component;

@Component
public interface IUserMapper  extends GenericDao<User, Long> {
    @Override
	User selectByPrimaryKey(Long id);
	@Override
	int insertSelective(User user);
	@Override
	int updateByPrimaryKeySelective(User user);
	@Override
	int deleteByPrimaryKey(Long id);


	List<User> selectUsers(String userName);
}
