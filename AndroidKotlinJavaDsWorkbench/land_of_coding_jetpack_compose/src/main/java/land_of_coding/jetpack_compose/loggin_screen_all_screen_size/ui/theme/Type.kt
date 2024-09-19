package land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import land_of_coding.jetpack_compose.R

val InterAllScreen = FontFamily(
    listOf(
        Font(resId = R.font.inter_medium, weight = FontWeight.Medium)
    )
)

val RubikAllScreen = FontFamily(
    listOf(
        Font(resId = R.font.rubik_bold, weight = FontWeight.Bold)
    )
)

val RobotoAllScreen = FontFamily(
    listOf(
        Font(resId = R.font.roboto_medium, weight = FontWeight.Medium),
        Font(resId = R.font.roboto_regular, weight = FontWeight.Normal),
        Font(resId = R.font.roboto_bold, weight = FontWeight.ExtraBold)
    )
)


// Set of Material typography styles to start with
val CompactTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = RobotoAllScreen,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = RubikAllScreen,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    titleMedium = TextStyle(
        fontFamily = InterAllScreen,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoAllScreen,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)

val CompactMediumTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = RobotoAllScreen,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = RubikAllScreen,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = InterAllScreen,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoAllScreen,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)

val CompactSmallTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = RobotoAllScreen,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = RubikAllScreen,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    titleMedium = TextStyle(
        fontFamily = InterAllScreen,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoAllScreen,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )
)

val MediumTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = RobotoAllScreen,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 38.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = RubikAllScreen,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    titleMedium = TextStyle(
        fontFamily = InterAllScreen,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoAllScreen,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

val ExpandedTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = RobotoAllScreen,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 42.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = RubikAllScreen,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),
    titleMedium = TextStyle(
        fontFamily = InterAllScreen,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoAllScreen,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    )
)