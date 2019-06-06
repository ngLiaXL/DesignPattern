package com.java.test;

public class Singleton {


    private Singleton() {
    }

    // ================================================== //
    private static Singleton HUNGRY = new Singleton();

    public static Singleton hungry() {
        return HUNGRY;
    }

    // ================================================== //
    private volatile static Singleton LAZY;

    public static Singleton lazy() {
        if (LAZY == null) {
            synchronized (Singleton.class) {
                if (LAZY == null) {
                    LAZY = new Singleton();
                }
            }
        }
        return LAZY;
    }

    // ================================================== //

    public static class Holder {
        private static Singleton HOLDER = new Singleton();
    }

    public Singleton getHolder() {
        return Holder.HOLDER;
    }
    // ================================================== //

    public enum SingletonEnum {
        INSTANCE;
    }
}
