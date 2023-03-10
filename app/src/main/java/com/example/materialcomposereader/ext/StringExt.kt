package com.example.materialcomposereader.ext

import android.util.Patterns

fun String.isValidEmail(): Boolean {
    return this.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}
