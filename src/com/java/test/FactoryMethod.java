package com.java.test;

/**
 * 工厂方法
 * 定义创建对象的接口
 * 调用时，子类去实现
 * 使一个类的实例化延迟到其子类
 */
public class FactoryMethod {

    public static void main(String[] args) {

        MouseFactory factory = new DellMouseFactory();
        factory.provide().click();
    }


}


interface MouseFactory {
    Mouse provide();
}


class DellMouseFactory implements MouseFactory {

    @Override
    public Mouse provide() {
        return new DellMouse();
    }
}

class ThinkPadMouseFactory implements MouseFactory {

    @Override
    public Mouse provide() {
        return new ThinkPadMouse();
    }
}

interface Mouse {

    void click();

}

class DellMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("DellMouse click...");
    }
}

class ThinkPadMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("ThinkPadMouse click...");
    }
}