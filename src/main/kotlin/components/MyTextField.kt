package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color

@Composable
@Preview
fun myTextField(label: String?, value: Any, onValueChange: (String) -> Unit, onFocusChanged: (Boolean) -> Unit = {}) {
    TextField(
        label = {
            label?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                    modifier = Modifier.background(Color.Transparent)
                )
            }
        },
        value = value.toString(),
        onValueChange = {
            onValueChange(it)
        },
        singleLine = true,
        modifier = Modifier.onFocusChanged { focusState ->
            onFocusChanged(focusState.isFocused)
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = MaterialTheme.colorScheme.outline,
            unfocusedLabelColor = MaterialTheme.colorScheme.outlineVariant,
            focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f),
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
        )
    )
}