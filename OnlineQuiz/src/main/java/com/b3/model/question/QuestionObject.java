package com.b3.model.question;

import java.util.List;

import com.b3.model.Options;
import com.b3.model.QuestionAbility;

public abstract class QuestionObject {

	
	protected int q_id;
	
	protected int s_id;
	
	protected String question;
	
	protected String subject;
	
	protected String grade;
	
	protected String level;
	
	protected String answer;
	
	protected List<Options> options;
	
	protected List<QuestionAbility> abilities;
	
	protected List<String> abilitieslist;
	
	public int getQ_id() {
		return q_id;
	}
	public List<String> getAbilitieslist() {
		return abilitieslist;
	}
	public void setAbilitieslist(List<String> abilitieslist) {
		this.abilitieslist = abilitieslist;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public List<Options> getOptions() {
		return options;
	}
	public void setOptions(List<Options> options) {
		this.options = options;
	}
	public List<QuestionAbility> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<QuestionAbility> abilities) {
		this.abilities = abilities;
	}
	
    //public abstract QuestionObject choose();
	public QuestionObject choose(){
        throw new UnsupportedOperationException("Cannot return QuestionObject.");
    };
    
    public void add(QuestionObject question){
        throw new UnsupportedOperationException("Cannot add item to catalog.");
    }
 
    public void remove(QuestionObject question){
        throw new UnsupportedOperationException("Cannot remove item from catalog.");
    }
    
    public boolean checkExist(QuestionObject question) {
    	throw new UnsupportedOperationException("Cannot return bool.");
	}  
        
    public List<QuestionObject> getQuestionSet() {
    	throw new UnsupportedOperationException("Cannot return Question Set.");
	} 
    
    public void clearQuestionSet(){
        throw new UnsupportedOperationException("Cannot clear QuestionSet.");
    };
    

}