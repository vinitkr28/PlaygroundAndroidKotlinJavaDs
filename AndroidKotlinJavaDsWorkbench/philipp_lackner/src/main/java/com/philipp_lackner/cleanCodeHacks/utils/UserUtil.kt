package com.philipp_lackner.cleanCodeHacks.utils

fun messageOnlineUsers(usersInRoom: List<User>, message: String) {
    val partitionedUsers = usersInRoom.partition { it.isOnline }

    partitionedUsers.first.forEach {user: User ->
        user.sendMessage(message)
    }



    val (onlineUsers, offlineUsers) = usersInRoom.partition { it.isOnline }

    onlineUsers.forEach { user ->
        user.sendMessage("online message: $message")
    }

    offlineUsers.forEach { user ->
        user.sendMessage("offline message: $message")
    }



    val map = mapOf<String, Int>()
    map.forEach { (key, value) ->
        val keyValue = key.partition {
            it.isDigit()
        }
        println("Key value first: ${keyValue.first}")
        println("Key value second: ${keyValue.second}")

    }

    val (mapValueFirst, mapValueSecond) = map.values.partition { it > 0 }
    println("mapValueFirst greater than 0: $mapValueFirst")
    println("mapValueFirst less or equal than 0: $mapValueSecond")


}

private fun User.sendMessage(message: String) {
    println(message)
}