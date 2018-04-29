package com.b3.service.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.b3.dao.UserAbilityDAO;
import com.b3.model.Report;
import com.b3.model.UserAbility;
import com.b3.model.question.Paper;
import com.b3.model.question.QuestionObject;

public abstract class BaseQuestionFactory {

	// public abstract QuestionObject createQuestion(int s_id, String grade, String
	// level);
	// public abstract void clear();
	/** create atom question **/
	public QuestionObject createQuestion(int s_id, String grade, String level) {
		throw new UnsupportedOperationException("Cannot return QuestionObject.");
	};
	
	public QuestionObject createQuestionByAbility(int s_id, String grade, String level, int a_id) {
		throw new UnsupportedOperationException("Cannot return QuestionObject.");
	};

	public void clearQuestion() {
		throw new UnsupportedOperationException("Cannot clear QuestionObject.");
	};

	/** composite atom question **/
	public boolean addQuestion(QuestionObject question) {
		throw new UnsupportedOperationException("Cannot add QuestionObject.");
	};

	public void removeQuestion(QuestionObject question) {
		throw new UnsupportedOperationException("Cannot remove QuestionObject.");
	};

	public List<QuestionObject> getQuestionSet() {
		throw new UnsupportedOperationException("Cannot get QuestionSet.");
	};

	public Paper getPaper() {
		throw new UnsupportedOperationException("Cannot create Paper.");
	};

	public void clearPaper() {
		throw new UnsupportedOperationException("Cannot clear Paper.");
	};

}
