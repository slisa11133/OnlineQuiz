package com.b3.model.question;

import java.util.List;

import com.b3.model.Options;
import com.b3.model.QuestionAbility;

public class Paper {
	
	protected List<QuestionObject> questionSet;
	
	protected List<String> studentAnswers;

	public List<QuestionObject> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(List<QuestionObject> questionSet) {
		this.questionSet = questionSet;
	}

	public List<String> getStudentAnswers() {
		return studentAnswers;
	}

	public void setStudentAnswers(List<String> studentAnswers) {
		this.studentAnswers = studentAnswers;
	}
	
    

}