package com.me.ssiagroworld.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {
    private static String BASE_URL="http://15.206.216.242/";
    private static RetrofitApiClient retrofitApiClient;
    private static Retrofit retrofit;

    private  RetrofitApiClient(){
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public static synchronized RetrofitApiClient getInstanse(){
        if (retrofitApiClient==null){
            retrofitApiClient=new RetrofitApiClient();
        }
        return retrofitApiClient;
    }
    public RegistraionApi getregistraionApi(){
        return retrofit.create(RegistraionApi.class);
    }
}
