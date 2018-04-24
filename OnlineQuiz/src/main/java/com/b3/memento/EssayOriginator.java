package com.b3.memento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class EssayOriginator {

	private String u_id;
	
	private int q_id;
	
	private String question;
	
	private String answer;
	
	
	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public EssayMemento saveToMemento() {
		 
		EssayMemento essayMemento=new EssayMemento(this.u_id, this.q_id, this.question, this.answer );
        return essayMemento;
    }
    public  void undoFromMemento(EssayMemento memento)
    {
        this.u_id = memento.getU_id();
        this.q_id = memento.getQ_id();
        this.question = memento.getQuestion();
        this.answer = memento.getAnswer();
    }
 
    public EssayMemento getMemento()
    {
    	EssayMemento essayMemento=new EssayMemento(this.u_id, this.q_id, this.question, this.answer );
        return essayMemento;
    }

}