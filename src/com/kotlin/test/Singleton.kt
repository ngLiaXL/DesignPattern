package com.kotlin.test

/**
 * 饿汉式单例
 */
object UrgentSingleton {

    fun foo() = "UrgentSingleton"
}

/**
 * 懒汉式单例
 */
class LazySingleton private constructor() {

    fun foo() = "LazySingleton"

    companion object {
        val instance: LazySingleton by lazy { LazySingleton() }
    }


}

fun main(args: Array<String>) {
    UrgentSingleton.foo()
    LazySingleton.instance.foo()
}

