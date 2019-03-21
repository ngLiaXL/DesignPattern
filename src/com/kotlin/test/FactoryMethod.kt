package com.kotlin.test

/**
 * 工厂方法
 */
fun main(args: Array<String>) {

    FactoryMethod()

}


class FactoryMethod {


    init {

        // 打印类型固定 qrcode和text 不断增加打印机
        val printerFactory: PrintrFactory = PrintrUsbFactory()

        val usbPrinter = printerFactory.provide("qrcode")
        usbPrinter.print("data")
    }

    /**
     * 抽象工厂
     */
    interface PrintrFactory {
        fun provide(type: String): Printer
    }

    /**
     * 具体工厂
     */
    private class PrintrUsbFactory : PrintrFactory {
        override fun provide(type: String): Printer {
            if (type.equals("qrcode")) {
                return QRCodeUsbPrinter()
            } else if (type.equals("text")) {
                return TextUsbPrinter()
            } else {
                throw RuntimeException("Usb创建异常")
            }

        }

    }

    /**
     * 具体工厂
     */
    class PrintrBleFactory : PrintrFactory {
        override fun provide(type: String): Printer {
            if (type.equals("qrcode")) {
                return QRCodeBlePrinter()
            } else if (type.equals("text")) {
                return TextBlePrinter()
            } else {
                throw RuntimeException("Ble创建异常")
            }
        }

    }

    interface Printer {
        fun print(data: String)
    }

    class QRCodeUsbPrinter : Printer {
        override fun print(data: String) {
            println("QRCodeUsbPrinter=>$data")
        }

    }

    class TextUsbPrinter : Printer {
        override fun print(data: String) {
            println("TextUsbPrinter=>$data")
        }

    }

    class QRCodeBlePrinter : Printer {
        override fun print(data: String) {
            println("QRCodeBlePrinter=>$data")
        }

    }

    class TextBlePrinter : Printer {
        override fun print(data: String) {
            println("TextUsbPrinter=>$data")
        }

    }
}