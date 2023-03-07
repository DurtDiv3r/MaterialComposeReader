package com.example.materialcomposereader.ext

import android.util.Patterns

fun String.isValid(): Boolean {
    return this.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}
