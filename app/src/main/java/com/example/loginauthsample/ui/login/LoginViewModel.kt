package com.example.loginauthsample.ui.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginauthsample.data.models.UserLogin
import com.example.loginauthsample.data.remote.responses.LoginResponse
import com.example.loginauthsample.repository.DummyRepository
import com.example.loginauthsample.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private  val repository: DummyRepository
) : ViewModel() {

    var username = mutableStateOf("kminchelle")
    var password = mutableStateOf("0lelplR")
    var isLoading = mutableStateOf(false)
    var isLogin = mutableStateOf(false)
    val LoginResponse = mutableStateOf(LoginResponse())

    fun login(){
        val userLogin = UserLogin(username.value,password.value)
        isLogin.value = true

        viewModelScope.launch(Dispatchers.IO) {
            isLoading.value = true

            when(val result = repository.login(userLogin)){
                is Resource.Error -> {
                    isLoading.value = false
                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    isLogin.value = true
                    LoginResponse.value = result.data!!
                    isLoading.value = false

                }
            }
        }


    }

}