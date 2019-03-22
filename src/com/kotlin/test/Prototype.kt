package com.kotlin.test

/**
 * 原型
 */
fun main(args: Array<String>) {

    val p = Prototype("zhangsan",12)
    val copy = p.copy(name = "lisi")
    p.foo()
    copy.foo()

}

data class Prototype(var name: String, var age: Int) {


    fun foo() {
        println("My name is $name I am $age")
    }

}