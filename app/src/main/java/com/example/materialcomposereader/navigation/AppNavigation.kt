package com.example.materialcomposereader.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.materialcomposereader.AppState
import com.example.materialcomposereader.screens.home.HomeScreen
import com.example.materialcomposereader.screens.login.LoginScreen
import com.example.materialcomposereader.screens.splash.SplashScreen
import com.example.materialcomposereader.screens.stats.StatsScreen

fun NavGraphBuilder.appNavigation(appState: AppState) {
    composable(AppScreen.SplashScreen.name) {
        SplashScreen(openAndPop = { route, pop ->
            appState.navigateAndPopUp(route, pop)
        })
    }
    composable(AppScreen.LoginScreen.name) {
        LoginScreen(openAndPop = { route, pop ->
            appState.navigateAndPopUp(route, pop)
        })
    }
    composable(AppScreen.HomeScreen.name) {
        HomeScreen(openAndPop = { route, pop ->
            when (route) {
                AppScreen.StatsScreen.name -> appState.navigate(route)
                else -> appState.navigateAndPopUp(route, pop)
            }
        })
    }
    composable(AppScreen.StatsScreen.name) {
        StatsScreen(openAndPop = { route, pop ->
            appState.navigate(route)
        })
    }
}
