package com.example.loginauthsample.data.remote.responses

data class LoginResponse(
    val email: String = "",
    val firstName: String = "",
    val gender: String =" ",
    val id: Int? = 0,
    val image: String ="",
    val lastName: String ="",
    val token: String ="",
    val username: String = ""
)