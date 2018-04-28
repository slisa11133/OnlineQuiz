package com.b3.dao;

import java.util.List;

import com.b3.model.Report;
import com.b3.model.UserAbility;

public interface UserAbilityDAO {
	
	public List<UserAbility> getUserAbilities(String userId);
	
	public List<Report> getUserReport(String userId);
	
	public List<Report> getTeacherReport();
	
	public void setUserAbilities(UserAbility userability);
}
