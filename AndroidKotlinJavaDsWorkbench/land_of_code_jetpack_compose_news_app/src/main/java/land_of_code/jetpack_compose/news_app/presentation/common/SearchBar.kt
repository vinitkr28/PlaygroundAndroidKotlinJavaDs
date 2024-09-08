package land_of_code.jetpack_compose.news_app.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import land_of_code.jetpack_compose.news_app.R
import land_of_code.jetpack_compose.news_app.presentation.Dimens.IconSize
import land_of_code.jetpack_compose.news_app.ui.theme.LandOfCodeNewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    readOnly: Boolean,
    onClick: (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    val isClicked = interactionSource.collectIsDraggedAsState().value

    LaunchedEffect(key1 = isClicked) {
        if (isClicked) {
            onClick?.invoke()
        }
    }

    Box(
        modifier = modifier
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .searchBarBoarder(),
            value = text,
            onValueChange = onValueChange,
            readOnly = readOnly,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier.size(
                        IconSize
                    ),
                    tint = colorResource(id = R.color.body)
                )
            },
            placeholder = {
                Text(
                    text = "Search",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(
                        id = R.color.placeholder
                    )
                )
            },
            shape = MaterialTheme.shapes.medium,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = colorResource(id = R.color.input_background),
                focusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                unfocusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                cursorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch
                }
            ),
            textStyle = MaterialTheme.typography.bodySmall,
            interactionSource = interactionSource
        )
    }


}

fun Modifier.searchBarBoarder() = composed {
    if (!isSystemInDarkTheme()) {
        border(
            width = 1.dp,
            color = if (isSystemInDarkTheme()) Color.Red else Color.Black,
            shape = MaterialTheme.shapes.medium
        )
    } else {
        this
    }
}

@Preview(name = "in_light", showSystemUi = true, showBackground = true)
@Preview(
    name = "in_dark",
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun SearchBarPreview() {
    LandOfCodeNewsAppTheme {
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            SearchBar(text = "", readOnly = false, onValueChange = {}) {

            }
        }
    }
}