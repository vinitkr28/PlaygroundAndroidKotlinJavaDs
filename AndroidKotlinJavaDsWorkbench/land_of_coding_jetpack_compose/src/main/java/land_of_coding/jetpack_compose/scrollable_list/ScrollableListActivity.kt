package land_of_coding.jetpack_compose.scrollable_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme

class ScrollableListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            ScrollableListsWithColumnExample()

//            ScrollableListsWithRowExample()

//            ScrollableListsWithLazyColumnExample1()
//            ScrollableListsWithLazyColumnExample2()

//            ScrollableListsWithLazyColumnItemsIndexedExample1()
            ScrollableListsWithLazyColumnItemsIndexedExample2()
        }
    }
}


@Composable
fun ScrollableListsWithColumnExample(modifier: Modifier = Modifier) {
    LandOfCodingJetpackComposeTheme {

        val state = rememberScrollState()

        Column(
            modifier = Modifier.verticalScroll(
                state = state
            )
        ) {
            (0..100).forEach {
                Text(
                    text = "Item #$it",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp)
                )
            }
        }
    }
}

@Composable
fun ScrollableListsWithRowExample(modifier: Modifier = Modifier) {
    LandOfCodingJetpackComposeTheme {

        val state = rememberScrollState()

        Row(
            modifier = Modifier.horizontalScroll(
                state = state
            )
        ) {
            (0..100).forEach {
                Text(
                    text = "Item #$it",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp)
                )
            }
        }
    }
}


@Composable
fun ScrollableListsWithLazyColumnExample1(modifier: Modifier = Modifier) {
    LandOfCodingJetpackComposeTheme {

        LazyColumn {
            items(10000) { index ->
                Text(
                    text = "Item #$index",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp)
                )
            }
        }
    }
}

@Composable
fun ScrollableListsWithLazyColumnExample2(modifier: Modifier = Modifier) {
    LandOfCodingJetpackComposeTheme {
        LazyColumn {
            val itemList = (0..10000).toList()

            items(items = itemList) { item ->
                Text(
                    text = "Item #$item",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp)
                )
            }
        }
    }
}


@Composable
fun ScrollableListsWithLazyColumnItemsIndexedExample1(modifier: Modifier = Modifier) {
    LandOfCodingJetpackComposeTheme {
        Scaffold {
            LazyColumn(
                modifier = Modifier.padding(it)
            ) {
                itemsIndexed((0..10000).toList()) { index, item ->
                    Text(
                        text = "Item:: Index: $index and Item: $item",
                        fontSize = 16.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ScrollableListsWithLazyColumnItemsIndexedExample2(modifier: Modifier = Modifier) {
    LandOfCodingJetpackComposeTheme {
//        Scaffold {
        val state = rememberLazyListState()

//        LazyRow {}
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
//                    .padding(it),
            state = state,
            contentPadding = PaddingValues(top = 50.dp),
            reverseLayout = true,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
//                flingBehavior = FlingBehavior
            userScrollEnabled = true
        ) {
            itemsIndexed((0..10000).toList()) { index, item ->
                Text(
                    text = "Item:: Index: $index and Item: $item",
                    fontSize = 16.sp,
                    modifier = Modifier
//                            .fillMaxWidth()
                        .padding(all = 16.dp)
                )
            }
        }
//        }
    }
}


@Composable
fun ScrollableListsWithLazyColumnItemsIndexedExample3(modifier: Modifier = Modifier) {
    LandOfCodingJetpackComposeTheme {

        val state = rememberLazyListState()


        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(3)
        ) {
            items(count = 1000) {
                Text(text = it.toString())
            }
        }
    }
}


@Composable
fun ScrollableListsWithLazyColumnItemsIndexedExample4(modifier: Modifier = Modifier) {
    LandOfCodingJetpackComposeTheme {

        val state = rememberLazyListState()

//LazyHorizontalStaggeredGrid(rows = ) {}




        LazyVerticalStaggeredGrid(
//            columns = StaggeredGridCells.FixedSize(100.dp)
            columns = StaggeredGridCells.Adaptive(100.dp)
        ) {
            items(count = 1000) {
                Text(text = it.toString())
            }
        }
    }
}