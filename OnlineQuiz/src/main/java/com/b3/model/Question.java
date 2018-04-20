package com.b3.model;

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

@Entity
//@Table(name = "question")
public class Question implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int q_id;

	@Column
	private int s_id;
	
	@Column
	private String question;
	
	@Column
	private String type;
	
	@Column
	private String grade;
	
	@Column
	private String level;
	


	public int getId() {
		return q_id;
	}

	public void setId(int q_id) {
		this.q_id = q_id;
	}
	
	public int getSubId() {
		return s_id;
	}

	public void setSubId(int s_id) {
		this.s_id = s_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

}