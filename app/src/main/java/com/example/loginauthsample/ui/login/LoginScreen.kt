package com.example.loginauthsample.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.loginauthsample.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()

) {
    val username by remember { mutableStateOf(viewModel.username) }
    val password by remember { mutableStateOf(viewModel.password) }
    val isLogin by remember {
        mutableStateOf(viewModel.isLogin)
    }
    val isLoading by remember {
        mutableStateOf(viewModel.isLoading)
    }


    if (isLogin.value) {
         LaunchedEffect(key1 = true ){
             navController.navigate(Screen.MainScreen.route){
                 popUpTo(Screen.LoginScreen.route){
                     inclusive = true
                 }
             }
         }
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = username.value,
            onValueChange = {
                username.value = it
            }, singleLine = true
        )

        TextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            singleLine = true
        )

        if (isLoading.value) CircularProgressIndicator() else
            Button(onClick = {
                viewModel.login()
            }) {
                Text("Login")
            }


    }
}