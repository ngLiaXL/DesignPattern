package com.kotlin.test

fun main(args: Array<String>) {

    Let.test()
    With.test()
    Run.test()
    Apply.test()
    Also.test()
}


class Let {
    var let1: String = ""
    var let2: String = ""

    companion object {
        fun test() {
            val leter = Let()
            // 可null对象统一做非空处理,
            // 以闭包的形式返回，返回函数体内最后一行的值，如果最后一行为空就返回一个Unit类型的默认值
            val result = leter?.let {
                it.let1 = "let1"
                it.let2 = "let2"
            }
            println("result->$result")
        }
    }
}

class With {
    var with1: String = "with1"
    var with2: String = "with2"

    companion object {

        fun test() {
            var wither = With()
            // 调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可
            // 与let区别省去it
            with(wither) {
                println("with1->$with1 with2->$with2")
                with2
            }
        }
    }

}

class Run {

    var run1: String = ""
    var run2: String = ""

    companion object {

        fun test() {
            var runner = Run()

            // let with 结合体 省去it引用 弥补with传入空对象判断问题
            val result = runner.run {
                run1 = "run1"
                run2 = "run2"
                run2

            }

            println("result->$result")

        }
    }

}

class Apply {

    var apply1: String = "apply1"
    var apply2: String = "apply2"

    companion object {

        fun test() {
            val applyer = Apply()

            // 与run基本一致，返回值式调用者本身
            val result = applyer?.apply {
                println("apply1->$apply1")
                println("apply2->$apply2")
            }
            println("result->$result")
        }
    }
}

class Also {

    var also1 = ""
    var also2 = ""

    companion object {
        fun test() {
            val alsor = Also()
            // 与let基本一致，返回值式调用者本身
            val result = alsor.also {
                it.also1 = "also1"
                it.also2 = "also2"

            }

            println("result->$result")
        }


    }

}
