package 设计模式.A创建型;/* 2020/8/31 21:09 */

import java.util.*; //import java.io.*;

//典型的抽象工厂模式
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.xpath.XPathFactory;

public class A4_抽象工厂_AbstactFactory {
}

/**
 * 4. 抽象工厂（Abstract Factory）
 * Intent
 * 提供一个接口，用于创建 相关的对象家族。
 * <p>
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%20-%20%E6%8A%BD%E8%B1%A1%E5%B7%A5%E5%8E%82.md
 */

//两类大产品，四类小产品
class AbstractProductA {
    public void show() {
        System.out.println("ProductA");
    }
}

class AbstractProductB {
    public void show() {
        System.out.println("ProductB");
    }
}

class ProductA1 extends AbstractProductA {
    @Override
    public void show() {
        //super.show();
        System.out.println("ProductA1");
    }
}

class ProductA2 extends AbstractProductA {
    @Override
    public void show() {
        //super.show();
        System.out.println("ProductA2");
    }
}

class ProductB1 extends AbstractProductB {
    @Override
    public void show() {
        //super.show();
        System.out.println("ProductB1");
    }
}

class ProductB2 extends AbstractProductB {
}

//一个总抽象工厂类，两个大类工厂类
abstract class AbstractFactory {
    public abstract AbstractProductA createProductA();

    public abstract AbstractProductB createProductB();
}

class ConcreteFactory01 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

class ConcreteFactory02 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}

//客户获取对象：通过抽象工厂抽象类、具体工厂类
class Client4 {
    public static void main(String[] args) { //AbstractFactory(); ConcreteFactory0X();
        System.out.println("AbstractFactory(); ConcreteFactory0X();\n");

        //借助抽象工厂和具体工厂生产对象
        AbstractFactory abstractFactory = new ConcreteFactory01();
        AbstractProductA productA = abstractFactory.createProductA();
        AbstractProductB productB = abstractFactory.createProductB();
        productA.show();
        productB.show();

        System.out.println();
        AbstractFactory abstractFactory2 = new ConcreteFactory02();
        AbstractProductB productB2 = abstractFactory2.createProductB();
        productB2.show();
    }
}
