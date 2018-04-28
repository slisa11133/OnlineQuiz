package com.b3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Table(name = "userability")
public class UserAbility implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;
	
	@Id
	private int ua_id;
	
	
	@Column
	private String u_id;
	
	@Column
	private int a_id;

	@Column
	private float result;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="a_id", insertable = false, updatable = false)
	private Ability ability;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="u_id", insertable = false, updatable = false)
	private User userD;
	
	public String getUId() {
		return this.u_id;
	}
	
	
	public void setUId(String pUId) {
		this.u_id = pUId;
	}
	
	
	public int getAId() {
		return this.a_id;
	}
	
	public void setAId(int pAId) {
		this.a_id = pAId;
	}
	
	
	public float getResult() {
		return this.result;
	}
	
	public void setResult(float pResult) {
		this.result = pResult;
	}
	
	
	public int getUa_id() {
		return ua_id;
	}


	public void setUa_id(int ua_id) {
		this.ua_id = ua_id;
	}


	public Ability getAbility() {
		return this.ability;
	}
	
	public void setAbility(Ability pAbility) {
		this.ability = pAbility;
	}
	
	
	public User getUserD() {
		return this.userD;
	}
	
	public void setUserD(User pUserD) {
		this.userD = pUserD;
	}

}