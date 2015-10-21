package com.sky.statistics.dao;

import java.util.List;

import com.sky.statistics.model.Article;
import com.sky.statistics.model.User;
import org.springframework.stereotype.Component;

@Component
public interface IUserMapper {

	public User selectUserByID(int id);
	
	public List<User> selectUsers(String userName);    
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
	public List<Article> getUserArticles(int id);
}
