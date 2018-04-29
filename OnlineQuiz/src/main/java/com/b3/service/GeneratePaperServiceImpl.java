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
	private List<UserAbility> userAbility;
	private int weak_ability_id = 1;
	private float weak_ability = 0;
	private float ability1=0;
	private float ability2=0;
	private float ability3=0;
	private float ability4=0;
	private float ability5=0;
	
	@Autowired
	private UserAbilityService userAbilityService;
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
	AnalysisAbility analysisability = new AnalysisAbility();
	
	public BaseQuestionFactory generatePaper(User u, int id, String grade, String level) {
		this.id=id;
		this.user=u;
		this.grade=grade;
		this.level=level;
		this.userAbility=userAbilityService.getUserAbilities(this.user.getId());
		this.ability_analysis();
		return this.generateTest();
	}
	
	@Override
	@Transactional
	public void ability_analysis() {
		for(int i=0; i<this.userAbility.size(); i++) {
			switch (this.userAbility.get(i).getAId()) {
				case 1:
					this.ability1=this.userAbility.get(i).getResult();
					break;
				case 2:
					this.ability2=this.userAbility.get(i).getResult();
					break;
				case 3:
					this.ability3=this.userAbility.get(i).getResult();
					break;
				case 4:
					this.ability4=this.userAbility.get(i).getResult();
					break;
				case 5:
					this.ability5=this.userAbility.get(i).getResult();
					break;
			}
		}
		this.weak_ability=this.analysisability.analysisAbility(ability1, ability2, ability3, ability4, ability5);
		if(this.weak_ability==this.ability1) {this.weak_ability_id=1;}
		if(this.weak_ability==this.ability2) {this.weak_ability_id=2;}
		if(this.weak_ability==this.ability3) {this.weak_ability_id=3;}
		if(this.weak_ability==this.ability4) {this.weak_ability_id=4;}
		if(this.weak_ability==this.ability5) {this.weak_ability_id=5;}
	};

	@Override
	@Transactional
	public BaseQuestionFactory generateTest() {
		System.out.println("paper=============================================");
		paperFactory = PaperFactory;
		
		
		while (paperFactory.getQuestionSet().size() < 1) {
			BaseQuestionFactory questionFactory = MCQFactory;
			QuestionObject question = questionFactory.createQuestionByAbility(this.id, this.grade, this.level,this.weak_ability_id);
			if (!paperFactory.addQuestion(question))
				questionFactory.clearQuestion();
		}
		
		
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
