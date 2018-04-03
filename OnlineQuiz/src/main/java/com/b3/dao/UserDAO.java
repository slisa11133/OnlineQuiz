package com.b3.dao;

import java.util.List;

import com.b3.model.User;

public interface UserDAO {

	public void addUser(User user);

	public List<User> getAllUsers();

	public void deleteUser(String userId);

	public User updateUser(User user);

	public User getUser(String userid);
}
