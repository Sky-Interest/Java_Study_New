package 作业.Study_0117;

public class Thread_test {
    public static void main(String[] args) {
        func1();
        func2();
    }
    public static void func1() {
        MyThread mt = new MyThread();
        mt.setName("Thread-0");

        MyThread mt2 = new MyThread();
        mt2.setName("Thread-1");
        //线程调用类型,手动调用run方法即为普通调用.
        mt2.start();
        System.out.println("==========华丽的分割线==========");
        mt.start();
        //同一线程只能调用一次start,否则会出现非法状态:
        // IllegalThreadStateException
        // 因为mt线程执行完毕后会进入线程死亡状态
        //  mt.start();
    }
    public static void func2() {
        //方法2
        //创建线程对象
        MyRunnable mr = new MyRunnable();
        //不能直接调用start
        //借助Thread
        Thread t = new Thread(mr);
        Thread t2 = new Thread(mr);
        //设置线程名称
        t.setName("Thread-0");
        t2.setName("Thread-1");

        //启动线程
        t.start();
        System.out.println("==========华丽的分割线==========");
        t2.start();
    }
}
class MyThread extends Thread {
    @Override
    //重写run方法
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("你好，来自线程"+this.getName());
        }
    }
}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("你好，来自线程"+Thread.currentThread().getName());
        }
    }
}
