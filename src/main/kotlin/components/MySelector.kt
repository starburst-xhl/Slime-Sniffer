package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun mySelector(bundle: ResourceBundle, options: Array<String>, titleKey: String, onValueChange: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options[0]) }
    val title = bundle.getString(titleKey)
    val menuMap = options.associateWith { bundle.getString("menu.$it") }
    onValueChange(selectedOption)

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {
            OutlinedTextField(
                readOnly = true,
                value = menuMap[selectedOption].toString(),
                onValueChange = {},
                label = { Text(title) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.menuAnchor()
            ) {
                options.map { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(menuMap[selectionOption].toString()) },
                        onClick = {
                            selectedOption = selectionOption
                            expanded = false
                            onValueChange(selectionOption)
                        }
                    )
                }
            }
        }
    }
}