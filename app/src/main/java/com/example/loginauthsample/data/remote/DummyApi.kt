package com.example.loginauthsample.data.remote

import com.example.loginauthsample.data.models.UserLogin
import com.example.loginauthsample.data.remote.responses.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface DummyApi {

    @POST("login")
    suspend fun login(@Body userLogin: UserLogin) : LoginResponse

}