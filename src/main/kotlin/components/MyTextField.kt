package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged

@Composable
@Preview
fun myTextField(label: String?, value: Any, onValueChange: (String) -> Unit, onFocusChanged: (Boolean) -> Unit = {}) {
    OutlinedTextField(
        label = { label?.let { Text(text = it) } },
        value = value.toString(),
        onValueChange = {
            onValueChange(it)
        },
        singleLine = true,
        modifier = Modifier.onFocusChanged { focusState ->
            onFocusChanged(focusState.isFocused)
        },
    )
}