package com.example.honeyloginapi.api;

import com.example.honeyloginapi.LoginActivity;
import com.example.honeyloginapi.pojos.Login;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestPlaceholder {

    @POST("login")
    Call<Login> Login(@Body Login login);
}