package com.b3.service;

import java.util.List;
import java.util.Map;

import com.b3.model.Essay;

public interface EssayService {
	
	public void addEssay(Essay essay);

	public List<Essay> getAllEssayNotMark();
	
	public List<Essay> getAllEssayByUid(String userId);

	public void deleteEssayById(Integer essayId);
	
	public Essay updateEssay(Essay essay);

	public Essay getEssayById(int essayid);
}
