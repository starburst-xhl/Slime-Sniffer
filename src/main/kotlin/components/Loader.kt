package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@Preview
@Composable
fun circularLoader(loadingStatus: LoadingStatus) {//TODO: 完善功能
}

class LoadingStatus {
    private var loadingState by mutableStateOf(LoadingState.BeforeLoading)
    private var loaderType by mutableStateOf(LoaderType.Circular)
    //进度值，仅在Linear模式下有效，取值范围0-100
    private var progress by mutableStateOf(0)
    private var message by mutableStateOf("")

    fun startLoading(): LoadingStatus {
        loadingState = LoadingState.Loading
        return this
    }

    fun stopLoading(): LoadingStatus {
        loadingState = LoadingState.Success
        return this
    }

    fun failLoading(): LoadingStatus {
        loadingState = LoadingState.Failed
        return this
    }

    fun reset(): LoadingStatus {
        loadingState = LoadingState.BeforeLoading
        progress = 0
        return this
    }

    fun circular(): LoadingStatus {
        loaderType = LoaderType.Circular
        return this
    }

    fun linear(): LoadingStatus {
        loaderType = LoaderType.Linear
        return this
    }

    fun progress(progress: Int): LoadingStatus {
        this.progress = progress
        return this
    }

    fun message(message: String): LoadingStatus {
        this.message = message
        return this
    }

    enum class LoadingState {
        BeforeLoading,
        Loading,
        Success,
        Failed
    }

    enum class LoaderType {
        Circular,
        Linear
    }
}