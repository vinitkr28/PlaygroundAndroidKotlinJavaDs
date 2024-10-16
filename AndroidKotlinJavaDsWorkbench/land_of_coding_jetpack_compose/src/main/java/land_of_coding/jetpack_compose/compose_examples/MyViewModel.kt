package land_of_coding.jetpack_compose.compose_examples

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    val state = mutableStateOf(MyScreenState())

    fun updateText(newText: String) {
        state.value = state.value.copy(testState = newText)
    }

    fun updateNamesList1(newName: String) {
        val currentList = state.value.nameList
        currentList.add(newName)
        state.value = state.value.copy(nameList = currentList)
    }

    fun updateNamesList2() {
        val currentList = state.value.nameList
        currentList.add(state.value.testState)
        state.value = state.value.copy(nameList = currentList)
    }
}