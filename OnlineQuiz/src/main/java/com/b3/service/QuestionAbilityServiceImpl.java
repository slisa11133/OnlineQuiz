package com.b3.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.b3.dao.QuestionAbilityDAO;
import com.b3.model.QuestionAbility;

@Service
@Transactional
public class QuestionAbilityServiceImpl implements QuestionAbilityService {

	@Autowired
	private QuestionAbilityDAO questionabilityDAO;

	@Override
	@Transactional
	// public void addQuestionAbility(QuestionAbility questionability, List<Integer> abilityList) {
	public void addQuestionAbility(QuestionAbility questionability) {
		questionabilityDAO.deleteQuestionAbilityByQ(questionability.getQId());
		questionabilityDAO.addQuestionAbility(questionability);
	}

	@Override
	@Transactional
	public List<QuestionAbility> getAllQuestionAbilitiesByQ(Integer questionId) {
		return questionabilityDAO.getAllQuestionAbilitiesByQ(questionId);
	}
	
	@Override
	@Transactional
	public List<String> getAllQuestionAbilities(Integer questionId) {
		return questionabilityDAO.getAllQuestionAbilities(questionId);
	}
	
	@Override
	@Transactional
	public Map<String, String> getAllEssayAbilities(Integer questionId) {
		return questionabilityDAO.getAllEssayAbilities(questionId);
	}

	@Override
	@Transactional
	public void deleteQuestionAbilityByQ(Integer questionId) {
		questionabilityDAO.deleteQuestionAbilityByQ(questionId);
	}
	
	@Override
	@Transactional
	public void deleteQuestionAbilityByA(Integer abilityId) {
		questionabilityDAO.deleteQuestionAbilityByA(abilityId);
	}

	public QuestionAbility getQuestionAbility(int questionabilityid) {
		return questionabilityDAO.getQuestionAbilityById(questionabilityid);
	}

	/**public void setQuestionAbilityDAO(QuestionAbilityDAO questionabilityDAO) {
		this.questionabilityDAO = questionabilityDAO;
	}**/

}
