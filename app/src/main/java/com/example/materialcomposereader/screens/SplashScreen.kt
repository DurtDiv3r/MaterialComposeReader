package com.example.materialcomposereader.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.materialcomposereader.navigation.AppScreen
import kotlinx.coroutines.delay

private const val ANIMATION_SCALE = 0.9f
private const val ANIMATION_TENSION = 8f
private const val ANIMATION_DURATION = 1500
private const val ANIMATION_URL = "https://assets2.lottiefiles.com/private_files/lf30_FJSIAJ.json"

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = ANIMATION_SCALE,
            animationSpec = tween(durationMillis = ANIMATION_DURATION, easing = {
                OvershootInterpolator(ANIMATION_TENSION).getInterpolation(it)
            }),
        )
        delay(3000)

        navController.navigate(AppScreen.LoginScreen.name)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .scale(scale = scale.value),
    ) {
        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.Url(ANIMATION_URL),
        )
        LottieAnimation(composition = composition, iterations = 2)
    }
}
