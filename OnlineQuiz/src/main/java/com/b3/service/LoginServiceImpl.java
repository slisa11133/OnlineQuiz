package com.b3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b3.dao.LoginDAO;

@Service
@Transactional

public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	@Transactional
	public String loginCheck(String username, String pwd) {
		return loginDAO.loginCheck(username, pwd);
	}
}
