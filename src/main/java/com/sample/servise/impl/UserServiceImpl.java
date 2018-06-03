package com.sample.servise.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.domain.User;
import com.sample.mapper.UserDao;
import com.sample.servise.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
@Autowired
private UserDao entityDao;
	@Override
	public List<User> listUser(Map<String, String> param) {
		return entityDao.listUser(param);
	}

	@Override
	public void addUser(String name, Integer sex) {
		entityDao.insertUser(name,sex);

	}

	@Override
	public void deleteUserById(Integer id) {
     
	}

	@Override
	public void updateUserById(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findUserById(Integer userId) {

		return entityDao.findUserById(userId);
	}
	
	

}
