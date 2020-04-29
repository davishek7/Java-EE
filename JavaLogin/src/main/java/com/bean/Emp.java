package com.bean;

import java.io.Serializable;

public class Emp implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uname;
	private String name;
	private String email;
	private String address;
	private String gender;
	private String pass;

	public Emp() {
		this.uname = "";
		this.name = "";
		this.email = "";
		this.address = "";
		this.gender = "";
		this.pass = "";
	}

	public Emp(String uname, String name, String email, String address, String gender, String pass) {

		this.uname = uname;
		this.name = name;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.pass = pass;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
