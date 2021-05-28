package 设计模式.A创建型.DM01_单例模式;

public class 单例模式 { //饿汉式，线程安全
    /*
    单例模式：
    确保一个类只有一个实例，自行实例化并向整个系统提供这个实例。
    todo: Spring中每个Bean默认都是单例，优点是Spring容器可以管理这些Bean的生命周期。
     如果采用Prototype类型，怎Spring容器不再跟踪Bean的生命周期。

    单例模式场景：
    创建对象需要消耗较多资源，如访问IO、数据库等。单例模式减少内存开支。
    整个项目中需要一个共享访问点或共享数据。如计数器。
    要求生成唯一序列号的环境。
    需要定义大量静态常量或者静态方法的环节。

    经典设计：懒汉式 和 饿汉式（需考虑线程同步）
    考虑线程同步：在getInstance前面添加synchronized关键字、或函数内部加。
     */
    public static void main(String[] args) {
        System.out.println("--调用饿汉式单例--");
        饿汉式单例 s = 饿汉式单例.getSingleton();
        System.out.println("--调用懒汉式单例--");
        懒汉式单例 l = 懒汉式单例.getSingleton();
    }
    /*
    缺点：
    没有接口，不利于扩展。
    不利于测试：单例模式未完成不能测试，没有接口，无法mock虚拟对象
    与单一职责原则冲突。
     */
}


class 饿汉式单例 { // TODO: 2020/8/16 Singleton Pattern
    private static final 饿汉式单例 singleton = new 饿汉式单例();

    private 饿汉式单例() {
    }

    public static 饿汉式单例 getSingleton() { //public
        System.out.println("饿汉式单例模式");
        return singleton;
    }

    public static void doSth() {
        System.out.println("Business");
    }
}

class 懒汉式单例 {
    private static 懒汉式单例 singleton = null; //not final

    private 懒汉式单例() {
    }

    public static 懒汉式单例 getSingleton() { //public
        System.out.println("懒汉式单例模式");
        if (singleton == null) {
            singleton = new 懒汉式单例();
        }
        return singleton;
    }

    public static void doSth() {
        System.out.println("Business");
    }
}