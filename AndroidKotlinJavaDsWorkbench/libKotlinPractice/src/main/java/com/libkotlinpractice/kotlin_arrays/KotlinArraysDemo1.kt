package com.libkotlinpractice.kotlin_arrays

class KotlinArraysDemo1 {

    var array1:Array<Int> = arrayOf(1, 2, 3, 4)


    fun printArrayElements(){
        array1.forEach { eachElement ->

            println(eachElement)
        }

        array1.contentToString()
    }

    fun printArrayElementByIndex(index: Int){
        println(array1[index])
    }

    fun replaceArrayElement(index: Int, newValue: Int){
//        array1[index] = newValue
        array1.set(index, newValue)
    }

    fun arrayOperations(){
//        array1.
    }


    fun createNewArrayAndAddNewElement(newElement: Int) {
        array1 += newElement
    }


    private var emptyArray1: Array<String>? = null

    fun emptyArray(){
        emptyArray1 = emptyArray<String>()

        //emptyArray1!![0] = ""//Index 0 out of bounds for length 0
    }

    fun printEmptyArray(){
        emptyArray1?.let {
            it.forEach { element ->
                println("Empty Array: $element")
            }
        }


    }


    var nullArray1 = arrayOfNulls<Int>(4)
    var ArrayOfBool = booleanArrayOf()
    var arrayOfInt = intArrayOf(1, 2, 3, 4)
    var arrayOfFloat = floatArrayOf(1.0f, 2.0f, 3.0f, 4.0f)
    var arrayOfDouble = doubleArrayOf(1.0, 2.0, 3.0, 4.0)
    var arrayOfLong = longArrayOf(1, 2, 3, 4)


    val intArray = IntArray(4)
    val floatArray = FloatArray(4)
    val doubleArray = DoubleArray(4)
    val longArray = LongArray(4)
    val booleanArray = BooleanArray(4)
    val charArray = CharArray(4)






    fun operationsOnGenericArray(){
//        val anyArray = Array(3){}
        val anyArray = Array<Any>(3){}
        println(anyArray.contentToString())

        anyArray[0] = 1
        anyArray[1] = 2.0
        anyArray[2] = "D"
        println("Value1: ${anyArray.contentToString()}")

        anyArray[0] = "Same Value"
        println("Value2: ${anyArray.contentToString()}")


//        val anyArray2 = Array<Any>(3){"EE", 33, 5.9}

        val anyArray3 = arrayOf("VV", 5, 5.5, false)
    }


}


fun main() {
    var kotlinArraysDemo1 = KotlinArraysDemo1()


    println(kotlinArraysDemo1.array1)
    kotlinArraysDemo1.printArrayElements()



    println("*****************")

    kotlinArraysDemo1.createNewArrayAndAddNewElement(5)

//    println("check array object is same: ${}")

    println(kotlinArraysDemo1.array1)
    kotlinArraysDemo1.printArrayElements()


    println("Empty Array *****************")


    kotlinArraysDemo1.emptyArray()
    kotlinArraysDemo1.printEmptyArray()


    println("operationsOnGenericArray *****************")
    kotlinArraysDemo1.operationsOnGenericArray()


}