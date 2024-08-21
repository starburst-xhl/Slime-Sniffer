package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun myNavigationBar(items: List<String>, onClick: (index: Int) -> Unit, selectedItem: Int) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        modifier = Modifier.height(72.dp),
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource("hexagram.svg"),
                        contentDescription = item,
                        modifier = Modifier.height(24.dp)
                    )
                },
                label = { Text(item) },
                selected = index == selectedItem,
                onClick = { onClick(index) }
            )
        }
    }
}