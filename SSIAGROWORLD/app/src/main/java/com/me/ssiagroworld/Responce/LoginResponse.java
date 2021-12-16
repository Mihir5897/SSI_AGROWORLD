package com.me.ssiagroworld.Responce;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("user_account_status")
	private String userAccountStatus;

	@SerializedName("otp")
	private String otp;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setUserAccountStatus(String userAccountStatus){
		this.userAccountStatus = userAccountStatus;
	}

	public String getUserAccountStatus(){
		return userAccountStatus;
	}

	public void setOtp(String otp){
		this.otp = otp;
	}

	public String getOtp(){
		return otp;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}