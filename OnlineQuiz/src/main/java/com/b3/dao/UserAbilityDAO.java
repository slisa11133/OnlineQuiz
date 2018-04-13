package com.b3.dao;

import java.util.List;

import com.b3.model.UserAbility;

public interface UserAbilityDAO {
	
	public List<UserAbility> getUserAbilities(String userId);
	
}
