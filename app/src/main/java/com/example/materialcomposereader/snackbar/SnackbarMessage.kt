package com.example.materialcomposereader.snackbar

import android.content.res.Resources
import androidx.annotation.StringRes
import com.example.materialcomposereader.R

sealed class SnackbarMessage {
    class StringSnackbar(val message: String) : SnackbarMessage()
    class StringResSnackbar(@StringRes val message: Int) : SnackbarMessage()

    companion object {
        fun SnackbarMessage.toMessage(resources: Resources): String {
            return when (this) {
                is StringSnackbar -> this.message
                is StringResSnackbar -> resources.getString(this.message)
            }
        }

        fun Throwable.toSnackbarMessage(): SnackbarMessage {
            val message = this.message.orEmpty()
            return if (message.isNotBlank()) {
                StringSnackbar(message)
            } else {
                StringResSnackbar(R.string.error_general)
            }
        }
    }
}
