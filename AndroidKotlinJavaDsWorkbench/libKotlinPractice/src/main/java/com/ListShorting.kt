package com

/*class ListShorting {

    fun shortList(list1: List<Int>, list2: List<Int>): List<Int> {




        return emptyList();
    }



//    Output: 3 ->54-> 15 -> 61-> 21 -> 41



//    fun mergeShot(list: List<Int>): List<Int> {
//        for (int i = 0; i < list.size; i++){
            //1. i = 0, list: 54-> 15 -> 61-> 21 -> 41
//            recursiveCall(list.subList(i+1, list.size), list[i])
//        }

    }


    fun recursiveCall(list: List<Int>, value: Int): List<Int> {
        if (list.size/2 <= 1) return list



        val temp = list.size/2

        //1. value = 3, temp = 2

        if (value<=list[temp]) {
            recursiveCall(list.subList(0, temp), value)
        } else {
//            recursiveCall(list.subList(temp, ))
        }



    }


}*/


fun main() {

    val arr = arrayOf(7, 8, 3, 1, 2)
    for (index in 0 until arr.size-1) {
        var tempIndex = -1
        for (j in index until arr.size-1){
            tempIndex  = if(arr[j]>arr[j+1]) (j+1) else j
        }
        val temp = arr[index]
        arr[index] = arr[tempIndex]
        arr[tempIndex] = temp

        println(arr.toList())
    }

    println(arr.toList())
}