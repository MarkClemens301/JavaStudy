package 设计模式.C结构型;/* 2020/9/10 17:09 */


//配适器案例

public class C1_配适器_Adapter {
}

/**
 * 1. 适配器（Adapter）
 * Intent
 * 把一个类接口转换成另一个用户需要的接口。
 */
interface Duck {
    void quack();
}

interface Turkey {
    void gobble();
}

//真土鸡
class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Actually, I do gobble!");
    }
}


//土鸡到鸭子的适配器，传入土鸡，假扮鸭子
class TurckeyAdapter implements Duck {
    private Turkey turkey;

    public TurckeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble(); //土鸡假装是鸭子
    }
}

class Client1 {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        Duck duck = new TurckeyAdapter(turkey);
        duck.quack();
    }
}