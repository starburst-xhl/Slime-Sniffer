import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import components.*

@Suppress("FunctionName")
@Composable
@Preview
fun App() {
    var seed by remember { mutableStateOf(0L) }
    var xPosMax by remember { mutableStateOf(10) }
    var zPosMax by remember { mutableStateOf(10) }

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Seed:")
            TextField(value = seed.toString(), onValueChange = { seed = it.toLongOrNull() ?: 0L })
            Spacer(modifier = Modifier.height(16.dp))
            Text("X Pos Max:")
            TextField(value = xPosMax.toString(), onValueChange = { xPosMax = it.toInt() })
            Spacer(modifier = Modifier.height(16.dp))
            Text("Z Pos Max:")
            TextField(value = zPosMax.toString(), onValueChange = { zPosMax = it.toInt() })
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                println("Seed: $seed")
                println("X Pos Max: $xPosMax")
                println("Z Pos Max: $zPosMax")
            }) {
                Text("Sniff")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Slime Chunk Sniffer") {
        App()
    }
}
