package com.pojoclass;

public class Request {

	private Integer id;

	private String name;

	private String email;

	private String message;

	private String isActive;

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String status) {
		this.isActive = status;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
