package com.sample.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sample.domain.User;

public interface UserDao {
	public List<User> listUser(Map<String, String> param);

	public void deleteUserById(Integer id);

	public void updateUserById(User user);

	public void insertUser(@Param(value = "name") String name, @Param(value = "sex") Integer sex);

	public User findUserById(@Param(value = "userId") Integer userId);
}
