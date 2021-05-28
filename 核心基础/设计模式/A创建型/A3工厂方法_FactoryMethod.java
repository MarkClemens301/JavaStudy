package 设计模式.A创建型;/* 2020/8/31 17:36 */

//import java.util.*; //import java.io.*;
//工厂方法案例

import java.util.Calendar;//
import java.util.EnumSet;
import java.util.ResourceBundle;
import java.text.NumberFormat;
import java.nio.charset.Charset;//

public class A3工厂方法_FactoryMethod {
}

/**
 * 工厂方法（Factory Method）
 * Intent
 * 定义了创建对象的接口，但由子类决定实例化哪个类。
 * 工厂方法把实例化操作推迟到子类。而简单工厂模式中，由简单工厂类来创建对象。
 * 此设计模式实际的应用如上
 */

abstract class Factory {
    abstract public Product factoryMethod();

    public void doSth() {
        Product product = factoryMethod();
        product.show();
    }
}

class ConcreteFactory extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}

class ConcreteFactory1 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 extends Factory {
    @Override
    public Product factoryMethod() {//特定创建
        return new ConcreteProduct2();
    }

    //todo 反射创建
    public Product createProduct(String c) {//传入产品的类名
        Product product = null;
        try {
            product = (Product) Class.forName(c).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
    //todo
}


class Client3 {
    public static void main(String[] args) {
        ConcreteFactory2 cf = new ConcreteFactory2();
        Product product1 = cf.factoryMethod();
        product1.show();
        Product product2 = cf.createProduct("设计模式.A创建型.ConcreteProduct1");
        product2.show();
    }
}