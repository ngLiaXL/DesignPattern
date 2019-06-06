package com.java.test;

/**
 * 抽象工厂
 * 工厂负责创建一系列或者相互依赖的对象
 * <p>
 * 产品只有一个的时候，抽象工厂退化成工厂方法
 * 工厂方法产品变多时，进化成抽象工厂
 */
public class AbstractFactory {

    public static void main(String[] args) {

        ComputerFactory factory = new DellFactory();
        factory.keyboard().input();
        factory.monitor().show();
        // ...

    }
}

interface ComputerFactory {
    Keyboard keyboard();

    Monitor monitor();
}

class DellFactory implements ComputerFactory {

    @Override
    public Keyboard keyboard() {
        return new DellKeyboard();
    }

    @Override
    public Monitor monitor() {
        return new DellMonitor();
    }
}

class ThinkPadFactory implements ComputerFactory {

    @Override
    public Keyboard keyboard() {
        return new ThinkPadKeyboard();
    }

    @Override
    public Monitor monitor() {
        return new ThinkPadMonitor();
    }
}


interface Keyboard {
    void input();
}


interface Monitor {
    void show();
}

class DellKeyboard implements Keyboard {

    @Override
    public void input() {
        System.out.println("DellKeyboard input...");
    }
}

class ThinkPadKeyboard implements Keyboard {

    @Override
    public void input() {
        System.out.println("ThinkPadKeyboard input...");
    }
}

class DellMonitor implements Monitor {

    @Override
    public void show() {
        System.out.println("DellMonitor show...");
    }
}

class ThinkPadMonitor implements Monitor {

    @Override
    public void show() {
        System.out.println("ThinkPadMonitor show...");
    }
}