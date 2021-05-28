package 设计模式.C结构型;/* 2020/9/10 17:10 */

//桥接设计模式的应用
//AWT (It provides an abstraction layer which maps onto the native OS the windowing support.)
//JDBC
public interface C2_桥接_Bridge {
}

/**
 * 桥接（Bridge）
 * Intent
 * 将抽象与实现分离开来，使它们可以独立变化。
 * <p>
 * 桥接模式，将遥控器 和◇---- 电视分离，从而独立改变二者的实现。
 * 遥控器聚合了电视的功能
 */

/**
 * 抽象部分二，遥控器
 */
//Abstraction 遥控器
abstract class RemoteControl {
    protected TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    public abstract void on();

    public abstract void off();

    public abstract void tuneChannel();
}

/**
 * 抽象部分一，电视
 */
//Implementor 电视
abstract class TV {
    public abstract void on();

    public abstract void off();

    public abstract void tuneChannel();
}

/**
 * 实现部分一，电视
 */
class Sony extends TV {
    @Override
    public void on() {
        System.out.println("Sony.on()");
    }

    @Override
    public void off() {
        System.out.println("Sony.off()");
    }

    @Override
    public void tuneChannel() {
        System.out.println("Sony.tuneChannel()");
    }
}

class KangJia extends TV {
    @Override
    public void on() {
        System.out.println("KangJia.on()");
    }

    @Override
    public void off() {
        System.out.println("KangJia.off()");
    }

    @Override
    public void tuneChannel() {
        System.out.println("KangJia.tuneChannel()");
    }
}

/**
 * 实现部分二，遥控器
 */
class ConcreteRemoteControl1 extends RemoteControl {
    public ConcreteRemoteControl1(TV tv) {
        super(tv);
    }

    @Override
    public void on() {
        System.out.println("ConcreteRemoteControl1.on()");
        tv.on();
    }

    @Override
    public void off() {
        System.out.println("ConcreteRemoteControl1.off()");
        tv.off();
    }

    @Override
    public void tuneChannel() {
        System.out.println("ConcreteRemoteControl1.tuneChannel()");
        tv.tuneChannel();
    }
}

class ConcreteRemoteControl2 extends RemoteControl {
    public ConcreteRemoteControl2(TV tv) {
        super(tv);
    }

    @Override
    public void on() {
        System.out.println("ConcreteRemoteControl2.on()");
        tv.on();
    }

    @Override
    public void off() {
        System.out.println("ConcreteRemoteControl2.off()");
        tv.off();
    }

    @Override
    public void tuneChannel() {
        System.out.println("ConcreteRemoteControl2.tuneChannel()");
        tv.tuneChannel();
    }
}

/**
 * 测试，桥接模式
 */
class ClentC2 {
    public static void main(String[] args) {
        //遥控器一，连接康佳电视
        RemoteControl remoteControl1 = new ConcreteRemoteControl1(new KangJia());
        remoteControl1.on();
        remoteControl1.off();
        remoteControl1.tuneChannel();
        System.out.println();
        //遥控器二，连接Sony电视
        RemoteControl remoteControl2 = new ConcreteRemoteControl2(new Sony());
        remoteControl2.on();
        remoteControl2.off();
        remoteControl2.tuneChannel();
    }
}