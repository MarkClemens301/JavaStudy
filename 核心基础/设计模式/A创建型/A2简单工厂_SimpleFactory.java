package 设计模式.A创建型;/* 2020/8/31 16:02 */

import java.util.*; //import java.io.*;

/*
各类最好是单独建立.class文件，类和接口的权限设为public
 */
public class A2简单工厂_SimpleFactory {
    /**
     * 简单工厂（Simple Factory）
     * Intent
     * 在创建一个对象时不向客户暴露内部细节，并提供一个创建对象的通用接口。
     */
}

//1.抽象的产品接口
interface Product {
    void show();
}

//2.多个具体的实现类
class ConcreteProduct implements Product {

    @Override
    public void show() {
        System.out.println("ConcreteProduct");
    }
}

class ConcreteProduct1 implements Product {
    @Override
    public void show() {
        System.out.println("ConcreteProduct1");
    }
}

class ConcreteProduct2 implements Product {
    @Override
    public void show() {
        System.out.println("ConcreteProduct2");
    }
}

//3.执行产品生产（return）的简单工厂类
class SimpleFactory {
    public SimpleFactory() {
    }

    public Product createProduct(int type) {//传入产品的编号
        //有return 无需break
        switch (type) {
            case 1:
                return new ConcreteProduct1();
            //break;
            case 2:
                return new ConcreteProduct2();
            //break;
            default:
                return new ConcreteProduct();
        }
    }
}

//4.客户提出产品需求，（客户类中不能存在实例化代码）要通过简单工厂类获得
class Client2 {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();

        Product product = simpleFactory.createProduct(2);
        product.show();//do sth.
        Product product2 = simpleFactory.createProduct(0);
        product2.show();//do sth.
    }
}