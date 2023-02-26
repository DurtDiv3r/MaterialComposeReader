package com.example.materialcomposereader.navigation

enum class AppScreen {
    SplashScreen,
    LoginScreen,
    ;

    companion object {
        fun fromRoute(route: String): AppScreen = when (route.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            else -> throw IllegalArgumentException("Route $route does not exist")
        }
    }
}
