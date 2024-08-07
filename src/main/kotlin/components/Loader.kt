package components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun circularLoader(loadingState: LoadingState) {

    Box(modifier = Modifier.fillMaxSize()) {
        when (loadingState) {
            LoadingState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            LoadingState.Success -> {
                Text(text = "加载成功", modifier = Modifier.align(Alignment.Center))
            }
            else -> {
                Text(text = "加载失败", modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

enum class LoadingState {
    Loading,
    Success,
    Failed
}