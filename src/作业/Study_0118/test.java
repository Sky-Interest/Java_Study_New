package 作业.Study_0118;


import java.util.concurrent.locks.ReentrantLock;

public class test {
    public static void main(String[] args) {
//        print_func();
//        run_func();
        ticket_func();
    }

    public static void print_func() {
        MyThread mt = new MyThread();
        MyThread mt2 = new MyThread();

        mt.setName("线程1");
        mt2.setName("线程2");

        mt.start();
        mt2.start();
    }

    public static void run_func() {
        RunThread r1 = new RunThread();

        for (int i = 1; i <= 10; i++) {
            new Thread(r1, i + "号选手").start();
        }

    }

    public static void ticket_func() {
        ticket mr = new ticket();
        Thread mt1 = new Thread(mr, "黄牛党");
        Thread mt2 = new Thread(mr, "张票票");
        Thread mt3 = new Thread(mr, "桃跑跑");

        //启动3个窗口卖票
        mt1.start();
        mt2.start();
        mt3.start();


    }


}

class MyThread extends Thread {
    private static int num = 1;//static共享资源
    private static String obj = new String();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                //唤醒方法:唤醒别的等待线程
                obj.notify();
                //判断
                if (num > 100) {
                    break;
                }
                System.out.println(getName() + ":" + num);
                num++;
                try {
                    //自己暂停,让下个进程继续打印,调用wait释放锁
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class RunThread extends Thread {
    static int mittle = 1000;
    private boolean f = false;

    @Override
    public synchronized void run() {
        while (!f) {
            Run();
            mittle -= 100;
            if (mittle == 0) {
                System.out.println(Thread.currentThread().getName() + "跑完接力赛");
                f = true;
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return;
//                //唤醒方法:唤醒别的等待线程
//                obj.notify();
//                //判断
//                if(mittle==0){
//                    break;
//                }
//                System.out.println(getName()+":"+mittle);
//                mittle++;
//                try {
//                    //自己暂停,让下个进程继续打印,调用wait释放锁
//                    obj.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
        }
    }

    public synchronized void Run() {
        System.out.println(Thread.currentThread().getName() + "拿到接力棒");
        for (int i = 10; i <= 100; i += 10) {
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "米");
        }
    }
}


class ticket implements Runnable {

    static int tickets = 100;
    static int count = 0;
    static ReentrantLock lock = new ReentrantLock();//公平锁，是抢占式调度的
//    static ReentrantLock lock = new ReentrantLock(true);//公平锁，是轮调式调度的

    @Override
    public void run() {

        while (true) {
            //获得锁
            lock.lock();
            try {

                //判断线程名是否为黄牛
                //放在这个位置判断则未进行买票,黄牛就炸了
//                if (Thread.currentThread().getName() == "黄牛党") {
//                    break;
//                } else {
                if (tickets > 0) {

                    tickets--;
                    count++;
                    System.out.println(Thread.currentThread().getName() + "抢到了第" + count + "票." + "剩余" + tickets + "张");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //改进判断位置
                    if (Thread.currentThread().getName() == "黄牛党") {
//                    Thread.interrupted();//线程中断
                        break;//改进:为黄牛时直接退出循环
                    }

                } else {
                    System.out.println("票卖完了");
                    break;
                }
//            }

            } finally {
                //释放锁
                //不在finally使用则在try若干出现错误不能解锁
                lock.unlock();
            }
            //票为0退出
            if (tickets == 0) {
                break;
            }
        }
    }
}

