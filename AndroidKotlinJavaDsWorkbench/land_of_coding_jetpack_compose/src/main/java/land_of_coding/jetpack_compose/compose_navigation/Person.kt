package land_of_coding.jetpack_compose.compose_navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Person(
    val id: Int,
    val name: String,
    val age: Int,
    val city: String
): Parcelable
