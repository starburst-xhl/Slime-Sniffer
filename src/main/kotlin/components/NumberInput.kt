package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf


@Composable
@Preview
fun numberInput(
    value: Int? = null,
    label: String,
    onValueChange: (Int?) -> Unit = {},
    onUnfocused: (Int) -> Int = {0}
) {
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
                v = if (v.isEmpty()) {
                    onUnfocused(0).toString()
                } else if (v.toIntOrNull() == null) {
                    onUnfocused(0).toString()
                } else {
                    onUnfocused(v.toInt()).toString()
                }
            }
        }
    )
}

@Composable
@Preview
fun longNumberInput(
    value: Long? = null,
    label: String,
    onValueChange: (Long?) -> Unit = {},
    onUnfocused: (Long) -> Long = {0L}
) {
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
                v = if (v.isEmpty()) {
                    onUnfocused(0L).toString()
                } else if (v.toLongOrNull() == null) {
                    onUnfocused(0L).toString()
                } else {
                    onUnfocused(v.toLong()).toString()
                }
            }
        }
    )
}