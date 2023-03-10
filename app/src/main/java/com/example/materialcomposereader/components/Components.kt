package com.example.materialcomposereader.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.materialcomposereader.R
import com.example.materialcomposereader.ext.fieldModifier

@Composable
fun UsernameInputField(
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean,
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            onNewValue(it)
        },
        modifier = modifier,
        enabled = enabled,
        textStyle = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground),
        label = {
            Text(text = stringResource(id = R.string.login_username))
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ),
        singleLine = true,
    )
}

@Composable
fun EmailInputField(
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean,
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            onNewValue(it)
        },
        modifier = modifier,
        enabled = enabled,
        textStyle = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground),
        label = {
            Text(text = stringResource(id = R.string.login_email))
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        ),
        singleLine = true,
    )
}

@Composable
fun PasswordInputField(
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean,
    fieldVisibility: Boolean = false,
) {
    val passwordVisibility = rememberSaveable { mutableStateOf(fieldVisibility) }
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
        modifier = modifier,
        enabled = enabled,
        textStyle = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground),
        label = {
            Text(text = stringResource(id = R.string.login_password))
        },
        trailingIcon = {
            val image = if (passwordVisibility.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description =
                if (passwordVisibility.value) {
                    stringResource(R.string.login_passord_hide)
                } else {
                    stringResource(
                        R.string.login_password_show,
                    )
                }

            IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                Icon(imageVector = image, description)
            }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions.Default,
        singleLine = true,
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

@Preview
@Composable
private fun UsernameDefaultPreview() {
    UsernameInputField(
        value = "",
        onNewValue = { },
        enabled = true,
        modifier = Modifier.fieldModifier(),
    )
}

@Preview
@Composable
private fun UsernameFilledPreview() {
    UsernameInputField(
        value = "Us3rName",
        onNewValue = { },
        enabled = true,
        modifier = Modifier.fieldModifier(),
    )
}

@Preview
@Composable
private fun EmailDefaultPreview() {
    EmailInputField(
        value = "",
        onNewValue = { },
        enabled = true,
        modifier = Modifier.fieldModifier(),
    )
}

@Preview
@Composable
private fun EmailFilledPreview() {
    EmailInputField(
        value = "bob@tester.com",
        onNewValue = { },
        enabled = true,
        modifier = Modifier.fieldModifier(),
    )
}

@Preview
@Composable
private fun PasswordHiddenPreview() {
    PasswordInputField(
        value = "password",
        onNewValue = { },
        enabled = true,
        fieldVisibility = false,
        modifier = Modifier.fieldModifier(),
    )
}

@Preview
@Composable
private fun PasswordVisiblePreview() {
    PasswordInputField(
        value = "password",
        onNewValue = { },
        enabled = true,
        fieldVisibility = true,
        modifier = Modifier.fieldModifier(),
    )
}

@Preview
@Composable
private fun SubmitButtonDefaultPreview() {
    SubmitButton(
        label = "Submit",
        isLoading = false,
        valid = false,
    ) {
    }
}

@Preview
@Composable
private fun SubmitButtonValidPreview() {
    SubmitButton(
        label = "Submit",
        isLoading = false,
        valid = true,
    ) {
    }
}
