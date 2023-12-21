package cheezyCode.jetpackCompose.workbenchOne

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cheezyCode.jetpackCompose.R

class ListViewSampleOne {
}

@Composable
fun BlogCategoryNameDescription(
    modifier: Modifier,
    name: String,
    description: String
) {
    Column(horizontalAlignment = Alignment.Start, modifier = modifier) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            style = MaterialTheme.typography.headlineSmall,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Thin
        )
    }
}

@Composable
fun BlogCategoryWithRow(
    img: Int,
    name: String = "John Doe",
    description: String = "Developer"
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = img),
            contentDescription = "",
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp)
                .clip(CircleShape)
                .weight(.2f)
        )
        BlogCategoryNameDescription(Modifier.weight(.8f), name, description)
    }

}

@Composable
fun BlogCategory(
    img: Int,
    name: String,
    description: String
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        BlogCategoryWithRow(img, name, description)
    }
}

@Preview(device = Devices.DEFAULT, showBackground = true, showSystemUi = true)
@Composable
fun PreviewListViewItem() {
    BlogCategory(R.drawable.heart_svgrepo_com,"John Doe", "Developer")
}

@Composable
fun RenderBlogCategoryByColumn() {
    // Modifier.verticalScroll(rememberScrollState()
    // the problem of verticalScroll is it will render all the row at start.
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        getCategoryList().map { item ->
            BlogCategory(item.imdId, item.title, item.subTitle)
        }
    }
}

@Composable
fun RenderBlogCategoryByLazyColumn() {
    LazyColumn(content = {
        items(getCategoryList()) { item ->
            BlogCategory(img = item.imdId, name = item.title, description = item.subTitle)
        }
    })
}

@Composable
fun RenderRenderBlogCategory() {
//    RenderDeveloperListByColumn()
    RenderBlogCategoryByLazyColumn()
}


@Preview(device = Devices.DEFAULT, showBackground = true, showSystemUi = true)
@Composable
fun PreviewRenderBlogCategory() {
    RenderBlogCategoryByColumn()
}




