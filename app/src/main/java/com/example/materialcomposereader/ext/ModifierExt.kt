package com.example.materialcomposereader.ext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.fieldModifier(): Modifier {
    return this.fillMaxWidth().padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
}
