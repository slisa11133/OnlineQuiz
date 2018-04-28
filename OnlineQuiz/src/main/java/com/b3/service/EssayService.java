package com.b3.service;

import java.util.List;
import java.util.Map;

import com.b3.model.Essay;
import com.b3.model.UserAbility;

public interface EssayService {
	
	public void addEssay(Essay essay);

	public List<Essay> getAllEssayNotMark();
	
	public List<Essay> getAllEssayByUid(String userId);

	public void deleteEssayById(Integer essayId);
	
	public Essay updateEssay(Essay essay);
	
	public void updateUserAbility(List<UserAbility> userAbility);

	public Essay getEssayById(int essayid);
}
