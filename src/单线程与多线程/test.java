package 单线程与多线程;

import java.util.concurrent.ExecutionException;


public class test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread_test.func1();
        Runnable_test.func2();
        Callable_test.func3();
        /*
        不同点:
        1所共享的资源  继承Thread不共享，实现Runnable共享
        2继承Thread ，创建对象后可以start, 实现runnable要借助Thread才能启动
        3继承Thread,就不能再继承的类，java是单继承，实现runnable类可以再继承别的类
        4获取线程名称 继承Thread可以直接getName(),实现runnable要Thread.currentThread().getName()
        */
    }
}









