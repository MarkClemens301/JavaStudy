package 设计模式.A创建型;/* 2020/8/29 1:54 */


public class A1懒汉式单例 {
    public static void main(String[] args) {
        SingletonLazyDualLock singleton = SingletonLazyDualLock.getSingleton();
        //singleton.show();
        SingletonLazyDualLock.show();
    }
}

class Singleton_Lazy {//public
    // TODO: 2020/8/29 懒汉式 线程不安全，有解决措施
    private static Singleton_Lazy singleton = null;

    private Singleton_Lazy() {
    }

    public static Singleton_Lazy getSingleton() {
        if (singleton == null) { //不安全：多个线程可同时进入if
            singleton = new Singleton_Lazy();
        }
        return singleton;
    }

    public static void doSth() {
        System.out.println("do something");
    }
}

//饿汉式1，线程安全
class Singleton_Lazy_Syn {//public*
    // TODO: 2020/8/29 懒汉式 线程不安全，有解决措施
    private static Singleton_Lazy_Syn singleton = null;

    private Singleton_Lazy_Syn() {
    }

    //存在性能问题，一个线程获取资源时，其他线程都必须等待
    public static synchronized Singleton_Lazy_Syn getSingleton() {//函数 同步锁
        if (singleton == null) { //不安全：多个线程可同时进入if
            singleton = new Singleton_Lazy_Syn();
        }
        return singleton;
    }
}

//todo 懒汉式，双重锁校验，提高资源获取性能
class SingletonLazyDualLock {
    //volatile 禁止JVM指令重排，singleton = new SingletonLazyDualLock();
    // 严格按照顺序执行，保证初始化：1.分配空间、2.初始化、3.指向分配的内存地址
    private volatile static SingletonLazyDualLock singleton;

    private SingletonLazyDualLock() {
    }

    public static SingletonLazyDualLock getSingleton() {
        if (singleton == null) {//一重校验
            synchronized (SingletonLazyDualLock.class) {
                if (singleton == null) { //必须再次校验，保证只new一次！。因为多个线程都可以进入上一个if
                    singleton = new SingletonLazyDualLock();
                }
            }
        }
        return singleton;
    }

    public static void show() {
        System.out.println("SingletonLazyDualLock");
    }

}

//todo 静态内部类实现，调用get才将SingletonHolder加载进内存，保证只执行一次实例化
// 优点：延迟初始化，JVM 提供对线程安全的支持
class SingletonInnerClass {
    private SingletonInnerClass() {
    }

    private static class SingletonHolder {
        private static final SingletonInnerClass SINGLETON = new SingletonInnerClass();
    }

    public static SingletonInnerClass getSingleton() {
        return SingletonHolder.SINGLETON;
    }
}

enum SingletonEnum {
    INSTANCE,
    ;

    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {
        //单例测试
        SingletonEnum si1 = SingletonEnum.INSTANCE;
        si1.setObjName("First Singleton");
        System.out.println(si1.getObjName());//First Singleton
        SingletonEnum si2 = SingletonEnum.INSTANCE;
        si2.setObjName("Second Singleton");
        System.out.println(si1.getObjName());//Second Singleton
        System.out.println(si2.getObjName());//Second Singleton

        //反射攻击测试
        try { //.class.getEnumConstants()
            SingletonEnum[] enumConstants = SingletonEnum.class.getEnumConstants();
            for (SingletonEnum enumConstant : enumConstants) {
                System.out.println(enumConstant.getObjName());//Second Singleton
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}