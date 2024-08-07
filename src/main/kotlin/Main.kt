import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import components.*
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

    MaterialTheme {
        Row(modifier = Modifier.fillMaxSize()) {
//            Column(
//                modifier = Modifier.weight(1f).fillMaxHeight(),
//            ) { //TODO add padding
//                mySnackBar()
//            }
            Column(
                modifier = Modifier.weight(3f).fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                longNumberInput(
                    label = bundle.getString("label.seed"),
                    onUnfocused = { seed = it })
                Spacer(modifier = Modifier.height(16.dp))
                numberInput(
                    label = bundle.getString("label.xPosMax"),
                    onUnfocused = { xPosMax = it },
                    value = xPosMax
                )
                Spacer(modifier = Modifier.height(16.dp))
                numberInput(
                    label = bundle.getString("label.zPosMax"),
                    onUnfocused = { zPosMax = it },
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
        }
    }
}

fun main() = application {
    val bundle = getResourceBundle()
    Window(onCloseRequest = ::exitApplication, title = bundle.getString("app.title")) {
        App(bundle)
    }
}
