package com.example.loginauthsample.repository

import com.example.loginauthsample.data.models.UserLogin
import com.example.loginauthsample.data.remote.DummyApi
import com.example.loginauthsample.data.remote.responses.LoginResponse
import com.example.loginauthsample.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class DummyRepository @Inject constructor(
    private val api : DummyApi
){
    suspend fun login(userLogin: UserLogin): Resource<LoginResponse> {
        val response = try {
            api.login(userLogin)
        }catch (e : Exception){
            return Resource.Error("An error occoured")
        }
        return Resource.Success(response)
    }
}