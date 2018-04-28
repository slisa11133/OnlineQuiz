package com.b3.service;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.b3.memento.EssayCareTaker;
import com.b3.memento.EssayMemento;
import com.b3.memento.EssayOriginator;
import com.b3.model.User;
import com.b3.model.UserAbility;
import com.b3.model.question.Paper;
import com.b3.model.question.QuestionObject;
import com.b3.service.question.BFQFactory;
import com.b3.service.question.BaseQuestionFactory;
import com.b3.service.question.EssayFactory;
import com.b3.service.question.MCQFactory;
import com.b3.service.question.PaperFactory;
import com.b3.service.question.TFQFactory;

@Service
@Transactional
public class GeneratePaperServiceImpl extends GeneratePaperService {
	private int id;
	private String grade;
	private String level;
	private User user;
	
	@Autowired
	private MCQFactory MCQFactory;
	@Autowired
	private TFQFactory TFQFactory;
	@Autowired
	private BFQFactory BFQFactory;
	@Autowired
	private PaperFactory PaperFactory;
	@Autowired
	private EssayFactory EssayFactory;
	@Autowired
	private EssayCareTaker essayCareTaker;
	BaseQuestionFactory paperFactory;
	BaseQuestionFactory essayFactory;
	
	@Autowired
	private UserAbilityService user_ability;
	
	public BaseQuestionFactory generatePaper(User u, int id, String grade, String level) {
		this.id=id;
		this.user=u;
		this.grade=grade;
		this.level=level;
		this.ability_analysis();
		this.getQuestion();
		return this.generateTest();
	}
	
	@Override
	@Transactional
	public void ability_analysis() {
		//this.list=user_ability.getUserAbilities(this.user.getId());
		//this.a_thi=
	};
	@Override
	@Transactional
	public void getQuestion() {
		
	};
	@Override
	@Transactional
	public BaseQuestionFactory generateTest() {
		System.out.println("paper=============================================");
		paperFactory = PaperFactory;
		while (paperFactory.getQuestionSet().size() < 4) {
			BaseQuestionFactory questionFactory = MCQFactory;
			QuestionObject question = questionFactory.createQuestion(this.id, this.grade, this.level);
			if (!paperFactory.addQuestion(question))
				questionFactory.clearQuestion();
		}
		
		while (paperFactory.getQuestionSet().size() < 7) {
			BaseQuestionFactory questionFactory = TFQFactory;
			QuestionObject question = questionFactory.createQuestion(this.id, this.grade, this.level);
			/** if add failed, then clean questonObject **/
			if (!paperFactory.addQuestion(question))
				questionFactory.clearQuestion();
		}
		/** 3 BFQs **/
		while (paperFactory.getQuestionSet().size() < 10) {
			BaseQuestionFactory questionFactory = BFQFactory;
			QuestionObject question = questionFactory.createQuestion(this.id, this.grade, this.level);
			/** if add failed, then clean questonObject **/
			if (!paperFactory.addQuestion(question))
				questionFactory.clearQuestion();
		}
		//Paper paper = paperFactory.getPaper();
		return paperFactory;
	}; 
}
