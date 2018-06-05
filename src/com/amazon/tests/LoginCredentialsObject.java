package com.amazon.tests;

public class LoginCredentialsObject {
	public String email;
	public String password;

	public LoginCredentialsObject() {
		this.email = "qa.vincent+testing@numberfour.eu";
		this.password = "qualityassurance123";
	}
	
	public LoginCredentialsObject(String email, String password) {
		this.email = email;
		this.password = password;
	}
}