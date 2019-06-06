package com.java.test;

/**
 * 简单工厂
 * 工厂类负责创建其他类的实例，被创建的实例有共同的父类
 */
public class FactoryStatic {

    public static Cpu provide(int type) {
        if (type == 1) return new CpuAmd();
        if (type == 2) return new CpuIntel();
        throw new RuntimeException("error type");
    }


    public static void main(String[] args) {
        Cpu cpu = FactoryStatic.provide(1);
        cpu.cal();
    }

}


interface Cpu {

    void cal();

}

class CpuAmd implements Cpu {

    @Override
    public void cal() {
        System.out.println("AMD cal...");
    }
}

class CpuIntel implements Cpu {

    @Override
    public void cal() {
        System.out.println("Intel cal...");
    }
}