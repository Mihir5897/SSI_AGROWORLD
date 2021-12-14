package com.me.ssiagroworld.Api;

import com.me.ssiagroworld.Request.LoginRequest;
import com.me.ssiagroworld.Request.RegistrationRequest;
import com.me.ssiagroworld.Responce.LoginResponse;
import com.me.ssiagroworld.Responce.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegistraionApi {
    @POST("api/register")
    Call<RegistrationResponse> register(@Body RegistrationRequest registrationRequest);
    @POST("api/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);


}
