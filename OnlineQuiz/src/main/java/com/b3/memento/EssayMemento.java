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

@Entity
// @Table(name = "memento")
public class EssayMemento implements Serializable {
	private static final long serialVersionUID = -3465813074586302847L;
	
	@Id
	private String u_id;

	@Column
	private int q_id;

	@Column
	private String question;

	@Column
	private String answer;

	public EssayMemento(String u_id, int q_id, String question, String answer) {
		this.u_id = u_id;
		this.q_id = q_id;
		this.question = question;
		this.answer = answer;
	}

	public String getU_id() {
		return u_id;
	}

	public int getQ_id() {
		return q_id;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

}