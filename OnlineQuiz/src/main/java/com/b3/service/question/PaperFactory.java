package com.b3.service.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b3.dao.UserAbilityDAO;
import com.b3.model.Report;
import com.b3.model.ReportStudent;
import com.b3.model.UserAbility;
import com.b3.model.question.Paper;
import com.b3.model.question.QuestionComposite;
import com.b3.model.question.QuestionMCQ;
import com.b3.model.question.QuestionObject;

@Service
public class PaperFactory extends BaseQuestionFactory {
	private Paper paper;
	@Autowired
	protected QuestionComposite questionComposite;

	@Override
	public boolean addQuestion(QuestionObject question) {
		// if question doesn't exist in question set then add
		if (question != null && !questionComposite.checkExist(question)) {
			questionComposite.add(question);
			return true;
		}
		else
			return false;
	};

	@Override
	public void removeQuestion(QuestionObject question) {
		questionComposite.remove(question);
	};

	@Override
	public List<QuestionObject> getQuestionSet() {
		return questionComposite.getQuestionSet();
	};
		

	@Override
	public Paper getPaper() {
		if (this.paper == null) {
			this.paper = new Paper();
			this.paper.setQuestionSet(questionComposite.getQuestionSet());
		}
		return paper;
	};

	@Override
	public void clearPaper() {
		questionComposite.clearQuestionSet();
		this.paper = null;
	};
}
