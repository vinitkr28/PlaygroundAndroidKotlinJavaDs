package com.philipp_lackner.lazyColumnLag

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import java.util.UUID


//@Stable
@Immutable
data class MyImage(
    val id: String = UUID.randomUUID().toString(),
    val resId: Int,
    val title: String,
    val tags: List<String>
)


/*
*
* val id: String = UUID.randomUUID().toString(),
* id is the unique which we can use in LazyColumn as a Key
* */