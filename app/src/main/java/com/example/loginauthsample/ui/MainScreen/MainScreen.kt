package com.example.loginauthsample.ui.MainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.loginauthsample.Screen

@Composable
fun MainScreen(
    navController: NavController,
) {
    val context = LocalContext.current

    Column() {
        Button(
            onClick = {
                navController.popBackStack()
                navController.navigate(Screen.LoginScreen.route)
            }
        ){
            Text("Logout")
        }
    }
}