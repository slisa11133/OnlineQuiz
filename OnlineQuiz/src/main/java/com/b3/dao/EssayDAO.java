package com.b3.dao;

import java.util.List;

import com.b3.model.Essay;

public interface EssayDAO {

	//public void addEssay(Essay essay, List<Integer> abilityList);
	public void addEssay(Essay essay);

	public List<Essay> getAllEssayNotMark();
	
	public List<Essay> getAllEssayByUid(String userId);

	public void deleteEssayById(Integer essayId);
	
	public Essay updateEssay(Essay essay);

	public Essay getEssayById(int essayid);
		

}
