package com.b3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -236483665876928635L;

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String u_id;

	@Column
	private String pwd;

	@Column
	private String name;

	@Column
	private String grade;

	@Column
	private String role;
	
	@Column
	private String is_open;
	
	@Column
	private String email;

	public String getId() {
		return u_id;
	}

	public void setId(String u_id) {
		this.u_id = u_id;
	}
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIs_open() {
		return is_open;
	}

	public void setIs_open(String is_open) {
		this.is_open = is_open;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}