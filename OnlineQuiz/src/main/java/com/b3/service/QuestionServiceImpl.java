package com.b3.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.b3.dao.QuestionDAO;
import com.b3.model.Ability;
import com.b3.model.Question;
import com.b3.dao.QuestionAbilityDAO;
import com.b3.dao.AbilityDAO;
import com.b3.dao.OptionDAO;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDAO questionDAO;
	@Autowired
	private AbilityDAO abilityDAO;
	@Autowired
	private QuestionAbilityDAO questionabilityDAO;
	@Autowired
	private OptionDAO optionDAO;

	@Override
	@Transactional
	// public void addQuestion(Question question, List<Integer> abilityList) {
	public void addQuestion(Question question) {
		//questionDAO.addQuestion(question, abilityList);
		questionDAO.addQuestion(question);
	}

	@Override
	@Transactional
	public List<Question> getAllQuestionsBySub(Integer subjectId) {
		return questionDAO.getAllQuestionsBySub(subjectId);
	}

	@Override
	@Transactional
	public void deleteQuestionById(Integer questionId) {
		questionDAO.deleteQuestionById(questionId);
		optionDAO.deleteOptionByQ(questionId);
		questionabilityDAO.deleteQuestionAbilityByQ(questionId);
	}

	public Question getQuestion(int questionid) {
		return questionDAO.getQuestionById(questionid);
	}

	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionDAO.updateQuestion(question);
	}

	public Map<String, String> getQtypes(){
		Map<String, String> Qtypes = new LinkedHashMap<String, String>();
		Qtypes.put("BFQ", "blank filling question(BFQ)");
		Qtypes.put("TFQ", "true-false question(TFQ)");
		Qtypes.put("MCQ", "multiple-choice question(MCQ)");
		Qtypes.put("Essay", "Essay");
		return Qtypes;
	}
	
	public Map<String, String> getQgrades(){
		Map<String, String> Qgrades = new LinkedHashMap<String, String>();
		Qgrades.put("1", "1");
		Qgrades.put("2", "2");
		Qgrades.put("3", "3");
		Qgrades.put("4", "4");
		return Qgrades;
	}
	
	public Map<String, String> getQlevels(){
		Map<String, String> Qlevels = new LinkedHashMap<String, String>();
		Qlevels.put("1", "easy");
		Qlevels.put("2", "medium");
		Qlevels.put("3", "hard");
		return Qlevels;
	}
	
	public Map<String, String> getQability(){
		List<Ability> listAbilityOptions = abilityDAO.getAllAbility();
		Map<String, String> Qability = new LinkedHashMap<String, String>();
		for (int i = 0; i < listAbilityOptions.size(); i++) {
			String a_id = String.valueOf(listAbilityOptions.get(i).getId());
			String fullName = listAbilityOptions.get(i).getFullName();
			Qability.put(a_id, fullName);
		}
		return Qability;
	}
	
	public String isDuplicatedQuestion(String question) {
		return questionDAO.isDuplicatedQuestion(question);
	}

}
