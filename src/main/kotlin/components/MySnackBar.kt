package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
@Preview
fun mySnackBar(message: String = "Snackbar",dismissMessage: String = "Dismiss") {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show snackbar") },
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = message,
                            actionLabel = dismissMessage
                        )
                    }
                }
            )
        }
    ) { contentPadding ->
        // Screen content
    }
}