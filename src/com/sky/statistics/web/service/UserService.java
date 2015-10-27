package com.sky.statistics.web.service;

import com.sky.statistics.core.feature.orm.mybatis.Page;
import com.sky.statistics.web.model.User;
import com.sky.statistics.core.generic.GenericService;
import com.sky.statistics.web.model.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by User on 2015/10/22.
 */
public interface UserService extends GenericService<User, Long>{

    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * 用户验证
     *
     * @param user
     * @return
     */
    User authentication(User user);

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 分页条件查询
     *
     * @param page
     * @param example
     * @return
     */
    List<User> selectByExampleAndPage(Page<User> page, UserExample example);
}
