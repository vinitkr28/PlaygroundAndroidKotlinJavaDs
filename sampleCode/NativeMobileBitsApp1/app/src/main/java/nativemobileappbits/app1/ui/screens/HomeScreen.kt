package nativemobileappbits.app1.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import nativemobileappbits.app1.ui.viewmodel.NewsViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import nativemobileappbits.app1.ui.components.Loader
import nativemobilebits.utilities.ResourceState

private const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsRes by newsViewModel.news.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (newsRes) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Inside_Loading: ")
                Loader()
            }

            is ResourceState.Error -> {
                Log.d(TAG, "Inside_Error: ${newsRes}")
            }

            is ResourceState.Success -> {
                Log.d(TAG, "Inside_Success: $newsRes")
            }
        }
    }
}

@Preview(name = "HomeScreen", showSystemUi = true, device = Devices.PIXEL_7_PRO)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}