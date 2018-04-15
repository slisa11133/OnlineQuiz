package com.b3.dao;

import java.util.List;

import com.b3.model.Ability;

public interface AbilityDAO {

	public void addAbility(Ability ability);

	public List<Ability> getAllAbility();

	public void deleteAbility(Integer abilityId);

	public Ability updateAbility(Ability ability);

	public Ability getAbilityById(int abilityid);
	
}
