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
public class GeneratePaperServiceImpl2 extends GeneratePaperService {
	private String paper_type;
	private int id;
	private String grade;
	private String level;
	private User user;
	private List<UserAbility> userAbility;
	private int weak_ability_id=1;
	private float weak_ability=0;
	private float ability1;
	private float ability2;
	private float ability3;
	private float ability4;
	private float ability5;
	
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
	AnalysisAbility analysisability= new AnalysisAbility();
	
	public BaseQuestionFactory generatePaper(User u, int id, String grade, String level) {
		//this.paper_type=type;
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
	};
	@Override
	@Transactional
	public BaseQuestionFactory generateTest() {
		System.out.println("essay=====================================");
		essayFactory = EssayFactory;
		//QuestionObject question = essayFactory.createQuestion(this.id, this.grade, this.level);
		//List<QuestionObject> list = null;
		//list.add(question);
		return essayFactory;		
	}; 
}
