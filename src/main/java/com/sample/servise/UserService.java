package com.sample.servise;

import java.util.List;
import java.util.Map;

import com.sample.domain.User;
/**
 * 
 * @author HuangHang
 *
 * service 实现crud
 *
 */
public interface UserService {
	public List<User> listUser(Map<String, String> param);

	public void addUser(String name, Integer sex);
	
	public void deleteUserById(Integer id);
	
	public void updateUserById(User user);

	public User findUserById(Integer userId);
}
