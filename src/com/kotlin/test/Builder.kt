package com.kotlin.test


fun main(args: Array<String>) {
    BuilderRole()
}

class BuilderRole {


    init {

        val builder: Builder = TextMessageBuilder()

        builder.build("ngliaxl", "other")

        builder.send()

    }


    abstract class Builder {

        lateinit var message: Message

        abstract fun body()


        fun send() {
            println("connect")
            println("from=>${message.from}")
            println("body=>${message.body}")
            println("to=>${message.to}")
            println("done")
        }

        fun build(from: String, to: String) {
            message.from = from
            message.to = to
            body()

        }

    }


    class TextMessageBuilder : Builder() {

        init {
            message = TextMessage()
        }

        override fun body() {
            message.body = "TEXT"
        }


    }

    class ImageMessageBuilder : Builder() {
        init {
            message = ImageMessage()
        }

        override fun body() {
            message.body = "IMAGE"
        }

    }


    open class Message {
        lateinit var from: String
        lateinit var to: String
        lateinit var body: String


    }

    class TextMessage : Message() {
        init {
            println("I will send a  text message")
        }
    }

    class ImageMessage : Message() {
        init {
            println("I will send a image message")
        }
    }

}