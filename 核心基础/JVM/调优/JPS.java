package JVM.调优;/* 2020/10/5 12:52 */

/**
 * 查看Java进程：jps -lvm //jvm process status tool //类似于unix中的ps命令
 * 查看某个进程下的堆栈情况： jstack -l pid(如 12140)
 */
public class JPS {//
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println("count: " + i);
            Thread.sleep(1000);
        }
    }
}
