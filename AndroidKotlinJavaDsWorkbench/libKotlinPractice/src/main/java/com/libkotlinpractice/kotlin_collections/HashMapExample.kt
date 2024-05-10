package com.libkotlinpractice.kotlin_collections

class HashMapExample {


}


fun main() {

    val hashMap: HashMap<String, Float> = HashMap()
//    hashMap.put("Petrol", 99.54f)
    hashMap["Petrol"] = 99.54f

    println(hashMap["CNG"])
}