package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf


@Composable
@Preview
fun numberInput(value: Int? = null, label: String, onValueChange: (Int?) -> Unit = {}, onUnfocused: (Int) -> Unit = {}) {
    var v by remember { mutableStateOf(value?.toString() ?: "") }
    myTextField(
        label = label,
        value = v,
        onValueChange = {
            if (it.isEmpty()) {
                onValueChange(null)
            } else if (it == "-") {
                onValueChange(null)
            } else if (it.toIntOrNull() == null) {
                return@myTextField
            } else {
                onValueChange(it.toInt())
            }
            v = it
        },
        onFocusChanged = {
            if (!it) {
                if (v.isEmpty()) {
                    onUnfocused(0)
                } else if (v.toIntOrNull() == null) {
                    onUnfocused(0)
                } else {
                    onUnfocused(v.toInt())
                }
            }
        }
    )
}

@Composable
@Preview
fun longNumberInput(value: Int? = null, label: String, onValueChange: (Long?) -> Unit = {}, onUnfocused: (Long) -> Unit = {}) {
    var v by remember { mutableStateOf(value?.toString() ?: "") }
    myTextField(
        label = label,
        value = v,
        onValueChange = {
            if (it.isEmpty()) {
                onValueChange(null)
            } else if (it == "-") {
                onValueChange(null)
            } else if (it.toLongOrNull() == null) {
                return@myTextField
            } else {
                onValueChange(it.toLong())
            }
            v = it
        },
        onFocusChanged = {
            if (!it) {
                if (v.isEmpty()) {
                    onUnfocused(0L)
                } else if (v.toLongOrNull() == null) {
                    onUnfocused(0L)
                } else {
                    onUnfocused(v.toLong())
                }
            }
        }
    )
}