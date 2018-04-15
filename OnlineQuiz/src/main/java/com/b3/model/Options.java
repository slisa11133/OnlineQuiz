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
//@Table(name = "options")
public class Options implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int o_id;

	@Column
	private int q_id;
	
	@Column
	private int s_id;
	
	@Column
	private String options;
	
	@Column
	private String is_answer;
	
	

	public int getId() {
		return o_id;
	}

	public void setId(int o_id) {
		this.o_id = o_id;
	}
	
	public int getQId() {
		return q_id;
	}

	public void setQId(int q_id) {
		this.q_id = q_id;
	}
		
	public int getSubId() {
		return s_id;
	}

	public void setSubId(int s_id) {
		this.s_id = s_id;
	}

	public String getOption() {
		return options;
	}

	public void setOption(String options) {
		this.options = options;
	}
	
	public String getIs_answer() {
		return is_answer;
	}

	public void setIs_answer(String is_answer) {
		this.is_answer = is_answer;
	}
	

}