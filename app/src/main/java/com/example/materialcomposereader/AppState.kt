package com.example.materialcomposereader

import android.content.res.Resources
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController
import com.example.materialcomposereader.snackbar.SnackbarManager
import com.example.materialcomposereader.snackbar.SnackbarMessage.Companion.resolve
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

@Stable
class AppState(
    val snackbarHostState: SnackbarHostState,
    private val snackbarManager: SnackbarManager,
    val navController: NavHostController,
    private val resources: Resources,
    scope: CoroutineScope,
) {

    init {
        scope.launch {
            snackbarManager.snackbarMessages.filterNotNull().collect { snackbarMessage ->
                val text = snackbarMessage.resolve(resources)
                snackbarHostState.showSnackbar(text)
            }
        }
    }

    fun navigateAndPopUp(route: String, popUp: String) {
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(popUp) { inclusive = true }
        }
    }

    fun navigate(route: String) {
        navController.navigate(route) { launchSingleTop = true }
    }
}
