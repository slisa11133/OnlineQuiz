package com.b3.dao;

import java.util.List;

import com.b3.model.Question;

public interface QuestionDAO {

	//public void addQuestion(Question question, List<Integer> abilityList);
	public void addQuestion(Question question);

	public List<Question> getAllQuestionsBySub(Integer subjectId);

	public void deleteQuestionById(Integer questionId);
	
	public void deleteQuestionBySub(Integer subjectId);

	public Question updateQuestion(Question question);

	public Question getQuestionById(int questionid);

}
