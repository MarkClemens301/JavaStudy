package 设计模式.A创建型;/* 2020/8/29 1:38 */

/**
 * 单例（Singleton）
 * Intent
 * 确保一个类只有一个实例，并提供该实例的全局访问点。
 */
public class A1饿汉式单例 {
    // TODO: 2020/8/29 饿汉式：简单，线程安全，但是直接实例化不利于节约资源。
}

class Singleton_Hungry {

    private static Singleton_Hungry singleton = new Singleton_Hungry();

    private Singleton_Hungry() {
    }

    public static Singleton_Hungry getSingleton() {
        return singleton;
    }

    public static void doSth() {
        System.out.println("do something");
    }
}