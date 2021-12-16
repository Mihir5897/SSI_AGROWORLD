package com.me.ssiagroworld.Responce;

import com.google.gson.annotations.SerializedName;
import com.me.ssiagroworld.Model.Users;

public class RegistrationResponse {

	@SerializedName("is_already_registered")
	private int isAlreadyRegistered;

	@SerializedName("message")
	private String message;

	@SerializedName("otp")
	private int otp;

	@SerializedName("status")
	private int status;

	public void setIsAlreadyRegistered(int isAlreadyRegistered){
		this.isAlreadyRegistered = isAlreadyRegistered;
	}

	public int getIsAlreadyRegistered(){
		return isAlreadyRegistered;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}
