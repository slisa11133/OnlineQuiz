package com.b3.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.b3.dao.EssayDAO;
import com.b3.model.Ability;
import com.b3.model.Essay;
import com.b3.dao.AbilityDAO;
import com.b3.dao.OptionDAO;
import com.b3.dao.QuestionAbilityDAO;

@Service
@Transactional
public class EssayServiceImpl implements EssayService {

	@Autowired
	private EssayDAO essayDAO;
	@Autowired
	private AbilityDAO abilityDAO;
	@Autowired
	private QuestionAbilityDAO questionabilityDAO;
	@Autowired
	private OptionDAO optionDAO;

	@Override
	@Transactional
	// public void addEssay(Essay essay, List<Integer> abilityList) {
	public void addEssay(Essay essay) {
		//essayDAO.addEssay(essay, abilityList);
		essayDAO.addEssay(essay);
	}

	@Override
	@Transactional
	public List<Essay> getAllEssayNotMark() {
		return essayDAO.getAllEssayNotMark();
	}
	
	@Override
	@Transactional
	public List<Essay> getAllEssayByUid(String userId) {
		return essayDAO.getAllEssayByUid(userId);
	}

	@Override
	@Transactional
	public void deleteEssayById(Integer essayId) {
		essayDAO.deleteEssayById(essayId);
	}

	@Override
	public Essay getEssayById(int essayid) {
		return essayDAO.getEssayById(essayid);
	}

	public Essay updateEssay(Essay essay) {
		// TODO Auto-generated method stub
		return essayDAO.updateEssay(essay);
	}

}
