package com.b3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b3.dao.UserDAO;
import com.b3.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	@Transactional
	public void deleteUser(String userId) {
		userDAO.deleteUser(userId);
	}

	public User getUser(String empid) {
		return userDAO.getUser(empid);
	}

	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.updateUser(user);
	}

	public String registerUser(String username, String realname, String grade, String pwd, String email) {
		// TODO Auto-generated method stub
		User u = new User();
		u.setId(username);
		u.setName(realname);
		u.setGrade(grade);
		u.setEmail(email);
		u.setPwd(pwd);
		u.setIs_open("T");
		u.setRole("student");
		
		if (this.getUser(u.getId()) == null) {
			this.addUser(u);
			return "registration successful";
		}
		return "Account already exist!";
	}

	/**public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}**/

}
