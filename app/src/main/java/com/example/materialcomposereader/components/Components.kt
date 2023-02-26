package com.example.materialcomposereader.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    label: String,
    inputValue: MutableState<String>,
    enabled: Boolean,
    keyboardType: KeyboardType,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = inputValue.value,
        onValueChange = { value ->
            inputValue.value = value
        },
        label = {
            Text(text = label)
        },
        singleLine = true,
        textStyle = TextStyle(fontSize = 16.sp, color = Color.White),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
    )
}

@Composable
fun SubmitButton(
    label: String,
    isLoading: Boolean,
    valid: Boolean,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(50.dp)
            .fillMaxWidth(),
        enabled = !isLoading && valid,
        shape = CircleShape,
    ) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.size(25.dp))
        } else {
            Text(
                text = label,
            )
        }
    }
}
