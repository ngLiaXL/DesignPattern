package com.kotlin.test

/**
 * 静态工厂方法(简单工厂)
 */
fun main(args: Array<String>) {

    FactoryStatic()

}

class FactoryStatic {

    init {
        var printer: Printer? = PrinterFactory.provide("usb")
        printer?.print("data")
    }

    interface Printer {
        fun print(data: String)
    }

    class UsbPrinter : Printer {
        override fun print(data: String) {
            println("UsbPrinter data=$data")
        }
    }

    class BlePrinter : Printer {
        override fun print(data: String) {
            println("BlePrinter data=$data")
        }

    }

    /**
     * 调用者可以免除直接创建对象的职责
     */
    class PrinterFactory {
        companion object {
            fun provide(type: String): Printer? {
                when (type) {
                    "usb" -> return UsbPrinter()
                    "ble" -> return BlePrinter()
                    else -> {
                        throw RuntimeException("类型错误")
                    }
                }
                return null
            }
        }


    }
}
