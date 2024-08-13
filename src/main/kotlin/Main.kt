import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import components.*
import consts.SniffMasks
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import utils.Sniffer
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
    val loadingStatus = remember { LoadingStatus() }
    val sniffMasks = remember { SniffMasks.sniffMasks }
    var option by remember { mutableStateOf("") }

    MaterialTheme(
        colorScheme = darkColorScheme(),
    ) {
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
        ) {
            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier.fillMaxSize()
            ) {
                Row(modifier = Modifier.fillMaxSize()) {
                    Surface(
                        modifier = Modifier.weight(3f).fillMaxHeight(),
                        color = MaterialTheme.colorScheme.surfaceContainer,
                    ) {
                        Surface(
                            modifier = Modifier.padding(30.dp).shadow(10.dp, shape = MaterialTheme.shapes.large),
                            shape = MaterialTheme.shapes.large,
                            color = MaterialTheme.colorScheme.surfaceContainerHigh,
                        ) {
                            Column(
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
                                mySelector(
                                    bundle = bundle,
                                    options = sniffMasks.keys.toTypedArray(),
                                    titleKey = "label.sniffMask",
                                    onValueChange = {
                                        option = it
                                    },
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(
                                    onClick = {
                                        output = ""
                                        loadingStatus.startLoading().circular()
                                        CoroutineScope(Dispatchers.Default).launch {
                                            try {
                                                val sniffer = withContext(Dispatchers.Default) {
                                                    Sniffer(seed, xPosMax, zPosMax, sniffMasks[option]!!)
                                                }
                                                sniffer.sniff(xPosMax, zPosMax).also { output = it }
                                                loadingStatus.stopLoading()
                                            } catch (e: Exception) {
                                                output = "Error initializing sniffer: ${e.message}"
                                                loadingStatus.failLoading()
                                            }
                                            loadingStatus.reset()
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors()
                                ) {
                                    Icon(
                                        painter = painterResource("hexagram.svg"),
                                        contentDescription = bundle.getString("button.sniff"),
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(bundle.getString("button.sniff"))
                                }
                            }
                        }
                    }
                    Surface(
                        modifier = Modifier.weight(5f).fillMaxHeight(),
                        color = MaterialTheme.colorScheme.surfaceContainer,
                    ) {
                        Surface(
                            modifier = Modifier.padding(30.dp, 80.dp).shadow(10.dp, shape = MaterialTheme.shapes.large),
                            shape = MaterialTheme.shapes.large,
                            color = MaterialTheme.colorScheme.surfaceContainerHigh,
                        ) {
                            Column(
                                modifier = Modifier.weight(5f).fillMaxHeight(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = output,
                                    modifier = Modifier.verticalScroll(rememberScrollState()),
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                        }
                    }

                }
            }

            myLoader(loadingStatus = loadingStatus)
        }
    }
}

fun main() = application {
    val bundle = getResourceBundle()
    val icon = useResource("app_icon.ico", ::loadImageBitmap)
    val state = rememberWindowState(
        position = WindowPosition(Alignment.Center),
        width = 1100.dp,
        height = 600.dp
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = bundle.getString("app.title"),
        icon = BitmapPainter(icon),
        state = state
    ) {
        App(bundle)
    }
}
