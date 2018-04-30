package com.b3.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.b3.model.User;

public interface UserService {
	
	public void addUser(User user);

	public List<User> getAllUsers();

	public void deleteUser(String userId);

	public User getUser(String userid);

	public User updateUser(User user);
	
	public String registerUser(String username, String realname, String grade, String pwd, String email);
	
	public Map<String, String> getUgrades();
	
	public Map<String, String> getUrole();
}
