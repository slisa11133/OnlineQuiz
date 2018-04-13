package com.b3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b3.dao.UserAbilityDAO;
import com.b3.model.UserAbility;



@Service
@Transactional
public class UserAbilityServiceImpl implements UserAbilityService {
	

	@Autowired
	private UserAbilityDAO userAbilityDAO;
	
	@Override
	@Transactional
	public List<UserAbility> getUserAbilities(String userId) {
		
		return userAbilityDAO.getUserAbilities(userId);
	}

}
