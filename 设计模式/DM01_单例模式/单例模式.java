package DM01_单例模式;

public class 单例模式 { //饿汉式，线程安全
// TODO: 2020/8/16 Singleton Pattern

    private static final 单例模式 singleton = new 单例模式();

    private 单例模式() {
    }

    public static 单例模式 getSingleton() {
        System.out.println("返回单例");
        return singleton;
    }

    public static void doSth() {
    }
}

class testSingleton {
    public static void main(String[] args) {
        单例模式 s = 单例模式.getSingleton();
    }
}