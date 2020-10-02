package 多线程.线程池;/* 2020/10/2 23:02 */

/**
 * 多线程之 Callable FutureTask Thread
 * 并发优势
 */

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class UserService {//

    public static void main(String[] args) throws Exception {
        UserService m = new UserService();
        Object info = m.getUserInfo("start");
        System.out.println(info);
    }

    public Object getUserInfo(String userId) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        //Callable
        Callable userInfoCallable = new Callable() {
            @Override
            public Object call() {
                String name = Thread.currentThread().getName();
                System.out.println(name);
                return name;
            }
        };
        Callable otherInfoCallable = new Callable() {
            @Override
            public Object call() {
                String name = Thread.currentThread().getName();
                System.out.println(name);
                return name;
            }
        };
        //Future
        FutureTask userInfoFutureTask = new FutureTask<>(userInfoCallable);
        FutureTask otherInfoFutureTask = new FutureTask<>(otherInfoCallable);
        //Thread
        new Thread(userInfoFutureTask).start();
        new Thread(otherInfoFutureTask).start();
        //Result
        HashMap res = new HashMap();
        res.put("user", userInfoFutureTask.get());
        res.put("other", otherInfoFutureTask.get());

        return res;
    }
}
