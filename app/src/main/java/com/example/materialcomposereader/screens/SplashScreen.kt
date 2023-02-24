package com.example.materialcomposereader.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun SplashScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(),
    ) {
        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.Url(
                "https://assets2.lottiefiles.com/private_files/lf30_FJSIAJ.json",
            ),
        )
        LottieAnimation(composition = composition, iterations = 2)
    }
}
