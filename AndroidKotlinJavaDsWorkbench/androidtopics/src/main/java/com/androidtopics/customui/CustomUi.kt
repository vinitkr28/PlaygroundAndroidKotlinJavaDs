package com.androidtopics.customui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidtopics.ui.theme.AndroidKotlinJavaDsWorkbenchTheme

// In order to use compose properties annotate with @Compose
@Composable
fun allButtons() {
    Text(text = "Buttons", style = typography.bodyMedium, modifier = Modifier.padding(8.dp))
    // Here we are using Row to add
    // two buttons in single Column
    // You can change it as per your need
    Row {
        // Create a Main Button or Normal Button
        Button(onClick = {}, modifier = Modifier.padding(8.dp)) {
            Text(text = "Main Button")
        }
        // Create a Text Button
        TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Text Button")
        }
    }
    Row {
        // Elevated Button
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(8.dp),
            elevation = ButtonDefaults.elevatedButtonElevation()
        ) {
            Text(text = "Elevated Button")
        }

        // Rounded Button
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "Rounded")
        }

    }
    Row {
        // Outlined Button
        // add border field and set BorderStroke and its color
        OutlinedButton(
            onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, Color.Red),
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Outlined")
        }

        // Outlined Button with icon
        // add border field and set BorderStroke and its color
        // add Icon field
        OutlinedButton(
            onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, Color.Red),
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(text = "Outlined Icon")
        }

    }

    Row {
        // Icon Button
        // Icon on the left of text
        Button(onClick = {}, modifier = Modifier.padding(8.dp)) {
            Row {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text = "Icon Button")
            }
        }

        // Icon Button
        // Icon on the Right of text
        Button(onClick = {}, modifier = Modifier.padding(8.dp)) {
            Text(text = "Icon Button")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }

    //custom background buttons
    // create a variable mainButtonColor and define background Color and content Color
    val mainButtonColor = ButtonDefaults.buttonColors(
//        backgroundColor = Color.Magenta,
        contentColor = MaterialTheme.colorScheme.surface
    )

    Row {
        Button(colors = mainButtonColor, onClick = {}, modifier = Modifier.padding(8.dp)) {
            Text(text = "Custom colors")
        }
    }

    Row {
        // Create variable horizontalGradient and inside color property define start and end color
        val horizontalGradient = Brush.horizontalGradient(
            colors = listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.primary),
            0f,
            250f
        )
        // Horizontal gradient Button
        // Create a text and set its background to horizontalGradient that we created above
        Text(
            text = "Horizontal gradient",
            style = typography.displayMedium.copy(color = Color.White),
            modifier = Modifier
                .padding(12.dp)
                .clickable(onClick = {})
                .clip(RoundedCornerShape(4.dp))
                .background(brush = horizontalGradient)
                .padding(12.dp)
        )

        // Create variable verticalGradient and inside color property define top and bottom color
        val verticalGradient = Brush.verticalGradient(
            colors = listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.onSurfaceVariant),
            startY = 0f,
            endY = 100f
        )
        // Vertical gradient Button
        // Create a text and set its background to verticalGradient that we created above
        Text(
            text = "Vertical gradient",
            style = typography.bodyLarge.copy(color = Color.White),
            modifier = Modifier
                .padding(12.dp)
                .clickable(onClick = {})
                .clip(RoundedCornerShape(4.dp))
                .background(brush = verticalGradient)
                .padding(12.dp)
        )
    }


}
// To see the preview annotate with @Preview to the function
@Preview
@Composable
fun DefaultPreview() {
    AndroidKotlinJavaDsWorkbenchTheme {
        Column {
            allButtons()
        }
    }
}