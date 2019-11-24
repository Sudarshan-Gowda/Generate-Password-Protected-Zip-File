package com.star.sud.zip.dto;

import java.io.Serializable;

public class UserDetail implements Serializable, Cloneable {

	// Static Attributes
	//////////////////////
	private static final long serialVersionUID = 6712208715006980137L;

	// Attributes
	////////////////
	private String userName;
	private String password;

	// Constructors
	////////////////
	public UserDetail() {

	}

	/**
	 * @param userName
	 * @param password
	 */
	public UserDetail(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	// Properties
	///////////////
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
