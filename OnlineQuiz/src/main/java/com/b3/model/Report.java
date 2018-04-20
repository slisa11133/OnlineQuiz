package com.b3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//@Entity
// @Table(name = "user_ability")
public abstract class Report {

	
	//@Id
	private String u_id;

	//@Column
	private String userName;

	//@Column
	private String userGrade;

	//@Column
	private String userState;

	//@Id
	private int a_id;

	//@Column
	private String abilityName;

	//@Column
	private float result;


	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getAbilityName() {
		return abilityName;
	}

	public void setAbilityName(String abilityName) {
		this.abilityName = abilityName;
	}

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}
	
	public abstract List<Report> getData();
    public abstract List<Report> getData(String userId);

}