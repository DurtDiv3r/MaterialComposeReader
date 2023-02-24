package com.example.materialcomposereader.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.materialcomposereader.screens.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.SplashScreen.name) {
        composable(AppScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
    }
}
