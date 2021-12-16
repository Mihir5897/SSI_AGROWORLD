package com.me.ssiagroworld.Request;

import com.google.gson.annotations.SerializedName;

public class RegistrationRequest{

	@SerializedName("role")
	private int role;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("mobile_number")
	private String mobileNumber;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("email")
	private String email;

	public void setRole(int role){
		this.role = role;
	}

	public int getRole(){
		return role;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setMobileNumber(String mobileNumber){
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber(){
		return mobileNumber;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}