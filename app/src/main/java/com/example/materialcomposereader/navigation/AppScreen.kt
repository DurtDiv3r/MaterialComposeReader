package com.example.materialcomposereader.navigation

enum class AppScreen {
    SplashScreen,
    ;

    companion object {
        fun fromRoute(route: String): AppScreen = when (route.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            else -> throw IllegalArgumentException("Route $route does not exist")
        }
    }
}
