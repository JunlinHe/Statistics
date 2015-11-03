package com.sky.statistics.web.dao;

import com.sky.statistics.core.feature.orm.mybatis.Page;
import com.sky.statistics.core.generic.GenericDao;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.model.UserLogExample;
import com.sky.statistics.web.model.UserLog;
import com.sky.statistics.web.model.vo.ClientVO;
import org.apache.ibatis.annotations.Param;
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
	List<UserLog> selectUserLog(Page<UserLog> page, User id);

	int deleteByUserID(User id);

	int countByExample(UserLogExample example);

	int deleteByExample(UserLogExample example);

	List<UserLog> selectByExample(UserLogExample example);

	int updateByExample(@Param("record") UserLog record, @Param("example") UserLogExample example);
	

	/**
	 * 分页条件查询
	 *
	 * @param page
	 * @param example
	 * @return
	 */
	List<UserLog> selectByExampleAndPage(Page<UserLog> page, UserLogExample example);

	/**
	 * 统计终端注册情况
	 * @return
	 */
	List<ClientVO> selectClient();
}

