package com.kotlin.test

/**
 * 会生单例类，不依赖外部类
 */

object Singleton {
    var string: String = "object"
    fun foo() = string
}


fun main(args: Array<String>) {
    println("Singleton.foo()=>${Singleton.foo()}")
}

/**
 * java代码如下
 */
/*public final class Singleton {
    @NotNull
    private static String string;
    public static final Singleton INSTANCE;

    @NotNull
    public final String getString() {
        return string;
    }

    public final void setString(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        string = var1;
    }

    @NotNull
    public final String foo() {
        return string;
    }

    private Singleton() {
    }

    static {
        Singleton var0 = new Singleton();
        INSTANCE = var0;
        string = "object";
    }*/