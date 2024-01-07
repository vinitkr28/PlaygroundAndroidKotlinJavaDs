package cheezy_code.jetpack_compose_advance.tweetsy.screens

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import cheezy_code.jetpack_compose_advance.R
import cheezy_code.jetpack_compose_advance.tweetsy.viewmodels.CategoryViewModel

private const val TAG = "CategoryScreen"
@Composable
fun CategoryScreen(onCategorySelected: (selectedCategory: String) -> Unit) {

//    val categoryViewModel: CategoryViewModel = viewModel()
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val categories: State<List<String>> = categoryViewModel.categories.collectAsState()

    if (categories.value.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Loading...", style = MaterialTheme.typography.headlineLarge)
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
//        verticalArrangement = Arrangement.SpaceBetween
        ) {
            items(categories.value.size) {
                CategoryItem(onCategorySelected, category = categories.value[it])
            }
        }
    }


}

@Composable
fun CategoryItem(onCategorySelected: (selectedCategory: String) -> Unit, category: String) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(
                painter = painterResource(id = R.drawable.wave_haikei),
                contentScale = ContentScale.FillBounds
            )
            .clickable {
                Log.d(TAG, "CategoryItem: $category")
                onCategorySelected(category)
            }
            .border(1.dp, Color(0xFFEEEEEE)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = category,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(0.dp, 20.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCategoryItem() {
    CategoryItem(onCategorySelected = ::onCategorySelected, category = "Android")
}

fun onCategorySelected(s: String) {

}