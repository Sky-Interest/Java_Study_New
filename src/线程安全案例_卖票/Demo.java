package 线程安全案例_卖票;

import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
//        Runnable_func();//代码块锁
//        Runnable_func2();//方法锁
        Runnable_ReentrantLock();//ReentrantLock锁

//        Thread_func();
    }

    public static void Runnable_func() {
        MyRunnable mr = new MyRunnable();
        Thread mt1 = new Thread(mr, "窗口1");
        Thread mt2 = new Thread(mr, "窗口2");
        Thread mt3 = new Thread(mr, "窗口3");

        //启动3个窗口卖票
        mt1.start();
        mt2.start();
        mt3.start();
    }

    public static void Runnable_func2() {
        MyRunnable2 mr = new MyRunnable2();
        Thread mt1 = new Thread(mr, "窗口1");
        Thread mt2 = new Thread(mr, "窗口2");
        Thread mt3 = new Thread(mr, "窗口3");

        //启动3个窗口卖票
        mt1.start();
        mt2.start();
        mt3.start();
    }

    public static void Runnable_ReentrantLock() {
        MyRunnable3 mr = new MyRunnable3();
        Thread mt1 = new Thread(mr, "窗口1");
        Thread mt2 = new Thread(mr, "窗口2");
        Thread mt3 = new Thread(mr, "窗口3");

        //启动3个窗口卖票
        mt1.start();
        mt2.start();
        mt3.start();
    }

    public static void Thread_func() {
        MyThread mt1 = new MyThread("窗口1");
        MyThread mt2 = new MyThread("窗口2");
        MyThread mt3 = new MyThread("窗口3");

        //启动3个窗口卖票
        mt1.start();
        mt2.start();
        mt3.start();
    }
}

//代码块锁
class MyRunnable implements Runnable {
    int tickets = 10;
    static Object obj = new Object();

    @Override
    public void run() {

        while (true) {
            //代码块锁
            synchronized (obj) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在售卖第" + tickets-- + "票");
                } else {
                    System.out.println("票源已售罄...");
                    break;
                }
            }

        }
    }

}

class MyRunnable2 implements Runnable {
    int tickets = 10;

    @Override
    public void run() {
        //定义标志
        boolean isSellOver = false;

        while (isSellOver) {
            isSellOver = sellTickets(isSellOver);//方法锁
        }
    }

    //方法锁
    private synchronized boolean sellTickets(boolean isSellOver) {
        if (tickets > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在售卖第" + tickets-- + "票");
        } else {
            System.out.println("票源已售罄...");
            isSellOver = false;
        }

        return isSellOver;
    }
}

class MyRunnable3 implements Runnable {
    int tickets = 10;//卖出了13

    //reentrantlock
    //static ReentrantLock lock = new ReentrantLock();//非公平锁，是抢占式调度的
    static ReentrantLock lock = new ReentrantLock(true);//公平锁，是轮调式调度的

    @Override
    public void run() {
        while (true) {
            //获得锁
            lock.lock();
            try {
                if (tickets > 0) {//三个窗口，当线程是窗口一的时候，tickets是1
                    try {
                        Thread.sleep(50);//tickets：1时 线程一暂停，线程三，线程二也是排队进来了
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }                                     //线程三 0   线程三减掉后是-1，线程二减掉后是-2
                    System.out.println(Thread.currentThread().getName() + "正在售卖第" + tickets-- + "票");
                } else {
                    System.out.println("票源已售罄...");
                    break;
                }

//                int i = 5/0;//错误
            } finally {
                //释放锁
                //不在finally使用则在try若干出现错误不能解锁
                lock.unlock();
            }

        }
    }
}

class MyThread extends Thread {
    static int tickets = 1000;
    //任何引用类型都可作为锁
//    static Object obj = new Object();
    static Integer obj = new Integer(4);
    String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            //上锁
            //还可以是字节码对象,引用类型的class,每个class在jvm只会存在一个
            //synchronized(String.class){
            synchronized (obj) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.name + "正在售卖第" + tickets-- + "票");
                } else {
                    System.out.println("票源已售罄...");
                    break;
                }
            }
        }
    }
}