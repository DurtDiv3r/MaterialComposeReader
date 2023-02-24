package com.example.materialcomposereader.navigation

enum class AppScreens {
    SplashScreen,
    ;

    companion object {
        fun fromRoute(route: String): AppScreens = when (route.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            else -> throw IllegalArgumentException("Route $route does not exist")
        }
    }
}
