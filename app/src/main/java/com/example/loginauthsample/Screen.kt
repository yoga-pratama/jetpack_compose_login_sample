package com.example.loginauthsample

sealed class Screen(val route : String){
    object LoginScreen : Screen("login")
    object MainScreen : Screen("main_screen")

}
