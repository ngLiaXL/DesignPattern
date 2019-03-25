package com.kotlin.test


fun main(args: Array<String>) {


    var name : String = "a"

    var n2 = name.let {

        println(it)

        "b"
    }

    println(n2)

}



