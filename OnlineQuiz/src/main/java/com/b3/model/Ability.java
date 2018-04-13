package com.b3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "ability")
public class Ability implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int a_id;
	
	@Column
	private String short_name;

	@Column
	private String full_name;
	
	
	public int getId() {
		return this.a_id;
	}
	
	public void setId(int pId) {
		this.a_id = pId;
	}
	
	
	public String getShortName() {
		return this.short_name;
	}
	
	public void setShortName(String pShortName) {
		this.short_name  = pShortName;
	}
	
	
	
	public String getFullName() {
		return this.full_name;
	}
	
	public void setFullName(String pFullName) {
		this.full_name = pFullName;
	}


}