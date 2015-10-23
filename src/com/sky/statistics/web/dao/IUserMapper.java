package com.sky.statistics.web.dao;

import java.util.List;
import com.sky.statistics.core.generic.GenericDao;
import com.sky.statistics.web.model.User;
import org.apache.ibatis.annotations.Param;
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


	/**
	 * 用户登录验证查询
	 *
	 * @param record
	 * @return
	 */
	User authentication(@Param("record") User record);


	/**
	 * 模糊查询
	 * */
	List<User> selectUsers(String userName);
}
