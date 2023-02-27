package com.example.materialcomposereader.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.materialcomposereader.R

@Composable
fun UsernameInputField(
    modifier: Modifier = Modifier,
    value: String,
    onNewValue: (String) -> Unit,
    enabled: Boolean = true,
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            onNewValue(it)
        },
        label = {
            Text(text = stringResource(id = R.string.login_username))
        },
        singleLine = true,
        textStyle = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ),
    )
}

@Composable
fun EmailInputField(
    modifier: Modifier = Modifier,
    value: String,
    onNewValue: (String) -> Unit,
    enabled: Boolean = true,
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            onNewValue(it)
        },
        label = {
            Text(text = stringResource(id = R.string.login_email))
        },
        singleLine = true,
        textStyle = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        ),
    )
}

@Composable
fun PasswordInputField(
    modifier: Modifier,
    value: String,
    onNewValue: (String) -> Unit,
    enabled: Boolean,
    passwordVisibility: MutableState<Boolean>,
) {
    val visualTransformation = if (passwordVisibility.value) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }
    OutlinedTextField(
        value = value,
        onValueChange = {
            onNewValue(it)
        },
        label = {
            Text(text = stringResource(id = R.string.login_password))
        },
        singleLine = true,
        textStyle = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
        ),
        visualTransformation = visualTransformation,
        trailingIcon = {
            PasswordVisibility(passwordVisibility = passwordVisibility)
        },
        keyboardActions = KeyboardActions.Default,
    )
}

@Composable
fun PasswordVisibility(passwordVisibility: MutableState<Boolean>) {
    val isVisible = passwordVisibility.value

    IconButton(onClick = {
        passwordVisibility.value = !isVisible
    }) {
        Icons.Default.Close
    }
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
