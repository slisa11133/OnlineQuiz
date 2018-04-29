package com.b3.service.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b3.dao.UserAbilityDAO;
import com.b3.model.Report;
import com.b3.model.ReportStudent;
import com.b3.model.UserAbility;
import com.b3.model.question.QuestionMCQ;
import com.b3.model.question.QuestionObject;


@Service
public class MCQFactory extends BaseQuestionFactory {
	private QuestionObject question;
	@Autowired
	protected QuestionMCQ MCQ;
	
	@Override
	public QuestionObject createQuestion(int s_id, String grade, String level) {
		if(this.question == null) {
			this.question = MCQ;
			question.setS_id(s_id);
			question.setGrade(grade);
			question.setLevel(level);
			question = question.choose();
		}
		
		return question;
	}
	
	@Override
	public QuestionObject createQuestionByAbility(int s_id, String grade, String level, int a_id) {
		if(this.question == null) {
			this.question = MCQ;
			question.setS_id(s_id);
			question.setGrade(grade);
			question.setLevel(level);
			question = question.choose();
		}
		
		return question;
	}
	
	@Override
	public void clearQuestion() {
			this.question = null;
		
	}
}
