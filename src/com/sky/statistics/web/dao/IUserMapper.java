package com.sky.statistics.web.dao;

import java.util.List;

import com.sky.statistics.core.feature.orm.mybatis.Page;
import com.sky.statistics.core.generic.GenericDao;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.model.UserExample;
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


	int countByExample(UserExample example);

	int deleteByExample(UserExample example);

	List<User> selectByExample(UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * 用户登录验证查询
	 *
	 * @param record
	 * @return
	 */
	User authentication(@Param("record") User record);


	/**
	 * 分页条件查询
	 *
	 * @param page
	 * @param example
	 * @return
	 */
	List<User> selectByExampleAndPage(Page<User> page, UserExample example);
}
