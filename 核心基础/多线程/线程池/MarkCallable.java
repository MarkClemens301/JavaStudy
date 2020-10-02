package 多线程.线程池;/* 2020/10/2 23:46 */

public interface MarkCallable<V> {//

    /* 自己实现的Callable */
    V call() throws Exception;
}
