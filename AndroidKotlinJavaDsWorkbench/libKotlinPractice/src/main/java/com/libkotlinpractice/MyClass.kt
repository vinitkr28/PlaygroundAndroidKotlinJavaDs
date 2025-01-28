package com.libkotlinpractice

class MyClass {

    var str:String? = null

//    val length2 = str != null? { str?.length }:0;

//    val length3 = str?.let { it }?100
    val length4 = str?:100


    var length:Int = 0
        get() = field
        set(value) {
            field = value
        }
}



fun main() {


}