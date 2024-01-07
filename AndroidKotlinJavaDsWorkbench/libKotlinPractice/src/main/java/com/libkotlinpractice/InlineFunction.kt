package com.libkotlinpractice

class InlineFunction {
}

fun main() {
    print("GeeksforGeeks: ")
    higherfunc("A Computer Science portal for Geeks",::print)

}



fun higherfunc( str : String, mycall :(String)-> Unit) {

    // inovkes the print() by passing the string str
    mycall(str)
}
