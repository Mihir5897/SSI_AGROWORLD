package com.me.ssiagroworld.Request;

import com.google.gson.annotations.SerializedName;

public class LoginRequest{

	@SerializedName("mobile_number")
	private String mobileNumber;

	public void setMobileNumber(String mobileNumber){
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber(){
		return mobileNumber;
	}
}