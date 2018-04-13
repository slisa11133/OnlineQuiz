package com.b3.service;

import java.util.List;

import com.b3.model.UserAbility;

public interface UserAbilityService {
		
	public List<UserAbility> getUserAbilities(String userId);
}
