package com.b3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//
//@Entity
//@Table(name = "question_ability")
public class QuestionAbility implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;
	 
	@Id
	private int qa_id;
	
	
	@Column
	private int q_id;
	
	@Column
	private int s_id;
	
	@Column
	private int a_id;
	
	List<String> ability;

	public List<String> getAbility() {
		return ability;
	}
	public void setAbility(List<String> ability) {
		this.ability = ability;
	}

	
	public int getQId() {
		return this.q_id;
	}
	
	
	public void setQId(int pQId) {
		this.q_id = pQId;
	}
	
	public int getSId() {
		return this.s_id;
	}
	
	
	public void setSId(int pSId) {
		this.s_id = pSId;
	}
	
	
	public int getAId() {
		return this.a_id;
	}
	
	public void setAId(int pAId) {
		this.a_id = pAId;
	}
	
	
}