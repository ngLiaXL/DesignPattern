package com.kotlin.test

/**
抽象工厂：
(1) 一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有形态的工厂模式都是重要的。
(2) 这个系统有多于一个的产品族，而系统只消费其中某一产品族。
(3) 同属于同一个产品族的产品是在一起使用的，这一约束必须在系统的设计中体现出来。
(4) 系统提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于实现。
 */


fun main(args: Array<String>) {
    FactoryAbstract()
}


class FactoryAbstract {


    init {

        val manager = Manager()

        val factory: AbstractFactory = UsbFactory()

        manager.start(factory)

    }


    /**
     * User，Printer式产品等级
     * Usb，Ble 产品族
     * 打印机类型易于扩展
     */
    class Manager {


        fun start(abstractFactory: AbstractFactory) {

            val user = abstractFactory.provideUser()
            val printer = abstractFactory.providePrinter()
            user.work(printer)
        }


    }

    interface AbstractFactory {
        fun provideUser(): User
        fun providePrinter(): Printer
    }

    class UsbFactory : AbstractFactory {
        override fun providePrinter(): Printer {
            return UsbPrinter()
        }

        override fun provideUser(): User {
            return UsbUser()
        }

    }

    class BleFactory : AbstractFactory {
        override fun providePrinter(): Printer {
            return BlePrinter()
        }

        override fun provideUser(): User {
            return BleUser()
        }

    }


    interface User {
        fun work(printer: Printer)
    }


    /**
     */
    class UsbUser : User {
        override fun work(printer: Printer) {
            println("UsbUser start to work:")
            printer.print("data")
        }


    }


    /**
     */
    class BleUser : User {
        override fun work(printer: Printer) {
            println("BleUser start to work:")
            printer.print("data")
        }

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
}