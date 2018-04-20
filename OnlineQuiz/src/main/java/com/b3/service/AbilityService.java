package com.b3.service;

import java.util.List;

import com.b3.model.Ability;

public interface AbilityService {
	
	
	public void addAbility(Ability ability);

	public List<Ability> getAllAbility();

	public void deleteAbility(Integer abilityId);

	public Ability getAbility(int abilityid);

	public Ability updateAbility(Ability ability);
	
}
