package com.b3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.b3.dao.QuestionDAO;
import com.b3.model.Question;
import com.b3.dao.OptionDAO;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDAO questionDAO;
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
	}

	public Question getQuestion(int questionid) {
		return questionDAO.getQuestionById(questionid);
	}

	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionDAO.updateQuestion(question);
	}

	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

}
