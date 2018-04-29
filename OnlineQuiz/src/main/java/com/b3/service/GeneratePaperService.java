package com.b3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.b3.memento.EssayCareTaker;
import com.b3.model.User;
import com.b3.model.UserAbility;
import com.b3.model.question.QuestionObject;
import com.b3.service.question.BFQFactory;
import com.b3.service.question.BaseQuestionFactory;
import com.b3.service.question.EssayFactory;
import com.b3.service.question.MCQFactory;
import com.b3.service.question.PaperFactory;
import com.b3.service.question.TFQFactory;

public abstract class GeneratePaperService {
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
	AnalysisAbility analysisability;
	
	public BaseQuestionFactory generatePaper(User u, int id, String grade, String level) {
		this.user=u;
		this.id=id;
		this.grade=grade;
		this.level=level;
		this.userAbility=userAbilityService.getUserAbilities(this.user.getId());
		this.ability_analysis();
		return this.generateTest();
	}
	
	public abstract void ability_analysis();
	public abstract BaseQuestionFactory generateTest(); 
}
