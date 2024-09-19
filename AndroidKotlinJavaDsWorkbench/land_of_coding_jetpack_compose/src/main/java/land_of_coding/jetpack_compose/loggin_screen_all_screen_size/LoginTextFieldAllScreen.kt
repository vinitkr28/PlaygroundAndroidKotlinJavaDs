package land_of_coding.jetpack_compose.loggin_screen_all_screen_size

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.BlackAllScreen
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.focusedTextFieldTextAllScreen
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.textFieldContainerAllScreen
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.unfocusedTextFieldTextAllScreen

@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    label: String,
    trailing: String
) {

    val uiColor = if (isSystemInDarkTheme()) Color.White else BlackAllScreen

    TextField(
        modifier = modifier,
        value = "",
        onValueChange = {

        },
        label = {
            Text(text = label, style = MaterialTheme.typography.labelMedium, color = uiColor)
        },
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldTextAllScreen,
            focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldTextAllScreen,
            unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainerAllScreen,
            focusedContainerColor = MaterialTheme.colorScheme.textFieldContainerAllScreen
        ),
        trailingIcon = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = trailing,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                    color = uiColor
                )
            }
        }
    )
}
