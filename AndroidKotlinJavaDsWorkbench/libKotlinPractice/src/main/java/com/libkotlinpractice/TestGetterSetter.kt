package com.libkotlinpractice

class TestGetterSetter(private val name: String) {

    fun getABC(): Boolean = name.length > 0
}


fun main() {
    val tt = TestGetterSetter("Vinit")
    println(">> ${tt.getABC()}")
}