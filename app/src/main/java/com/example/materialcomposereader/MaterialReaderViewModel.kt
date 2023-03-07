package com.example.materialcomposereader

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.materialcomposereader.snackbar.SnackbarManager
import com.example.materialcomposereader.snackbar.SnackbarMessage.Companion.toSnackbarMessage
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class MaterialReaderViewModel : ViewModel() {
    fun launchCatching(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                SnackbarManager.showMessage(throwable.toSnackbarMessage())
            },
            block = block,
        )
}
