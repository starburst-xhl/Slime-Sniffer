import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import components.*
import kotlinx.coroutines.launch
import java.util.*

fun getResourceBundle(): ResourceBundle {
    val locale = Locale.getDefault()
    return ResourceBundle.getBundle("messages", locale)
}

@Suppress("FunctionName")
@Composable
@Preview
fun App(bundle: ResourceBundle) {
    var seed by remember { mutableStateOf(0L) }
    var xPosMax by remember { mutableStateOf(10) }
    var zPosMax by remember { mutableStateOf(10) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    var output by remember { mutableStateOf("") }

    MaterialTheme {
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            }
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    longNumberInput(
                        label = bundle.getString("label.seed"),
                        onUnfocused = {
                            seed = it
                            return@longNumberInput seed
                        },
                        value = seed,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    numberInput(
                        label = bundle.getString("label.xPosMax"),
                        onUnfocused = {
                            if (it < 10) {
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = bundle.getString("message.error.xPosMax"),
                                        actionLabel = bundle.getString("button.dismiss")
                                    )
                                }
                            } else {
                                xPosMax = it
                            }
                            return@numberInput xPosMax
                        },
                        value = xPosMax
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    numberInput(
                        label = bundle.getString("label.zPosMax"),
                        onUnfocused = {
                            if (it < 10) {
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = bundle.getString("message.error.zPosMax"),
                                        actionLabel = bundle.getString("button.dismiss")
                                    )
                                }
                            } else {
                                zPosMax = it
                            }
                            return@numberInput zPosMax
                        },
                        value = zPosMax
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {//TODO add action
                        println("Seed: $seed")
                        println("X Pos Max: $xPosMax")
                        println("Z Pos Max: $zPosMax")
                    }) {
                        Text(bundle.getString("button.sniff"))
                    }
                }
                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = output,
                        modifier = Modifier.padding(16.dp).fillMaxSize().border(1.dp, MaterialTheme.colors.primary)
                    )
                }
            }
        }
    }
}

fun main() = application {
    val bundle = getResourceBundle()
    Window(onCloseRequest = ::exitApplication, title = bundle.getString("app.title")) {
        App(bundle)
    }
}
