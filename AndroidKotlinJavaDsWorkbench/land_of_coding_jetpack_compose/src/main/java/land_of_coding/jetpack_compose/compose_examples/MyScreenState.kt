package land_of_coding.jetpack_compose.compose_examples

data class MyScreenState(
    var testState: String = "",
    val nameList: MutableList<String> = mutableListOf()
)