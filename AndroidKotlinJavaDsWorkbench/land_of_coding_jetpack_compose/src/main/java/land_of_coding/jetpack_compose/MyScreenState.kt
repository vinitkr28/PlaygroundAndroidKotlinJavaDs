package land_of_coding.jetpack_compose

data class MyScreenState(
    var testState: String = "",
    val nameList: MutableList<String> = mutableListOf()
)