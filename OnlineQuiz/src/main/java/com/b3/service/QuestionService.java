package com.b3.service;

import java.util.List;

import com.b3.model.Question;

public interface QuestionService {
	
	//public void addQuestion(Question question, List<Integer> abilityList);
	public void addQuestion(Question question);

	public List<Question> getAllQuestionsBySub(Integer subjectId);

	public void deleteQuestionById(Integer questionId);

	public Question getQuestion(int questionid);

	public Question updateQuestion(Question question);
}
