package 设计模式.A创建型;/* 2020/8/31 23:05 */

import java.util.*;//import java.io.*;
import java.lang.Object;//#clone()

public class A6_原型模式_Prototype {
}

/**
 * 6. 原型模式（Prototype）
 * Intent
 * 使用原型实例指定要创建对象的类型，通过复制这个原型来创建新对象。
 */
abstract class Prototype {
    abstract Prototype myClone();
}

class ConcretePrototype extends Prototype {

    private String field;

    public ConcretePrototype(String field) {
        this.field = field;
    }

    @Override
    Prototype myClone() {
        return new ConcretePrototype(field);
    }

    @Override
    public String toString() {
        return field;
    }
}

class Client6 {
    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype("prototype");
        Prototype clone = prototype.myClone();
        System.out.println("clone.toString() = " + clone.toString());
    }
}