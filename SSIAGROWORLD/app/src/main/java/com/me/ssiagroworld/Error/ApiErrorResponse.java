package com.me.ssiagroworld.Error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiErrorResponse {

    @SerializedName("status")
    @Expose
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")
    @Expose
    private String message;

    public String getUser_account_status() {
        return user_account_status;
    }

    public void setUser_account_status(String user_account_status) {
        this.user_account_status = user_account_status;
    }

    @SerializedName("user_account_status")
    @Expose
    private String user_account_status;
}
