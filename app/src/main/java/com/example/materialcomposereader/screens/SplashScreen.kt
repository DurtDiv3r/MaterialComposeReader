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
import com.example.materialcomposereader.util.Constants.ANIMATION_DURATION
import com.example.materialcomposereader.util.Constants.ANIMATION_SCALE
import com.example.materialcomposereader.util.Constants.ANIMATION_TENSION
import com.example.materialcomposereader.util.Constants.ANIMATION_URL
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

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

        if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()) {
            navController.navigate(AppScreen.LoginScreen.name)
        } else {
            // Navigate to HomeScreen when login complete
        }
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
