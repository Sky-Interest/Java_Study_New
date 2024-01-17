package 单线程与多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class test {
    public static void main(String[] args) {
        func1();
        func2();
        /*
        不同点:
        1所共享的资源  继承Thread不共享，实现Runnable共享
        2继承Thread ，创建对象后可以start, 实现runnable要借助Thread才能启动
        3继承Thread,就不能再继承的类，java是单继承，实现runnable类可以再继承别的类
        4获取线程名称 继承Thread可以直接getName(),实现runnable要Thread.currentThread().getName()
        */
    }
    //方法1用法
    public static void func1() {
        MyThread mt = new MyThread();
        mt.setName("线程1");

        MyThread mt2 = new MyThread();
        mt2.setName("线程2");
        //线程调用类型,手动调用run方法即为普通调用.
        mt2.start();
        mt.start();
        //同一线程只能调用一次start,否则会出现非法状态:
        // IllegalThreadStateException
        // 因为mt线程执行完毕后会进入线程死亡状态
        //  mt.start();
    }
    //方法2用法
    public static void func2() {
        //方法2
        //创建线程对象
        MyRunnable mr = new MyRunnable();
        //不能直接调用start
        //借助Thread
        Thread t = new Thread(mr);
        Thread t2 = new Thread(mr);
        //设置线程名称
        t.setName("线程一");
        t2.setName("线程二");

        //启动线程
        t.start();
        t2.start();
    }
    //方法3用法
    public static void func3() throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        //计算结果封装在FutureTask对象
        FutureTask ft = new FutureTask(mc);
        //借助Thread
        Thread t = new Thread(ft);
        //启动
        t.start();
        System.out.println("1-36累加结果:"+ft.get());

    }
}
//重写线程方法
//方法1:继承Thread类

class MyThread extends Thread {
    @Override
    //重写run方法
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(this.getName() + "-" + i);
        }
    }
}

//方法2:实现Runnable方式
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "_" + i);
        }
    }
}

class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {


        int sum = 0;
        for (int i = 0; i < 37; i++) {
            sum += i;

        }
        return sum;
    }
}
