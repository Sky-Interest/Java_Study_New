package 作业.Study_0118;




import java.util.concurrent.locks.ReentrantLock;

public class test {
    public static void main(String[] args) {
//        print_func();
//        run_func();
//        ticket_func();//有bug勿用
    }
    public static void print_func(){
        MyThread mt = new MyThread();
        MyThread mt2 = new MyThread();

        mt.setName("线程1");
        mt2.setName("线程2");

        mt.start();
        mt2.start();
    }

    public static void run_func(){
        RunThread r1 = new RunThread();

        for (int i = 1;i<=10;i++){
            new Thread(r1,i+"号选手").start();
        }

    }
    public static void ticket_func(){
        ticket mr = new ticket();
        ticket mr2 = new ticket();
        Thread mt1 = new Thread(mr2, "黄牛党");
        Thread mt2 = new Thread(mr, "张票票");
        Thread mt3 = new Thread(mr, "桃跑跑");

        //启动3个窗口卖票
        mt2.start();
        mt1.start();
        mt3.start();


    }


}
class MyThread extends Thread {
    private static int num = 1;//static共享资源
    private static String obj = new String();

    @Override
    public void run() {
        while (true){
            synchronized (obj) {
                //唤醒方法:唤醒别的等待线程
                obj.notify();
                //判断
                if(num>100){
                    break;
                }
                System.out.println(getName()+":"+num);
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
        while (!f){
                Run();
            mittle-=100;
            if (mittle ==0){
                    System.out.println(Thread.currentThread().getName()+"跑完接力赛");
                    f =true;
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
        public synchronized void Run(){
            System.out.println(Thread.currentThread().getName()+"拿到接力棒");
            for (int i=10; i<=100;i+=10){
                System.out.println(Thread.currentThread().getName()+"跑了"+i+"米");
            }
        }
    }


class ticket implements Runnable {
    static int tickets = 10;
    static int count = 0;
    static ReentrantLock lock = new ReentrantLock();//公平锁，是抢占式调度的
//    static ReentrantLock lock = new ReentrantLock(true);//公平锁，是轮调式调度的

    @Override
    public void run() {
            //有bug勿用
            if (Thread.currentThread().getName() == "黄牛党") {
                tickets--;
                count++;
                System.out.println(Thread.currentThread().getName() + "抢到了第" + count + "票." + "剩余" + tickets + "张");
                Thread.interrupted();

            }else{

            }

        while (true) {
            //获得锁
            lock.lock();

            try {

                if (tickets > 0) {//三个窗口，当线程是窗口一的时候，tickets是1
                    try {
                        Thread.sleep(1000);//tickets：1时 线程一暂停，线程三，线程二也是排队进来了
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }                                     //线程三 0   线程三减掉后是-1，线程二减掉后是-2
                    tickets--;
                    count++;
                    System.out.println(Thread.currentThread().getName() + "抢到了第" + count + "票."+"剩余"+tickets+"张");
                    Thread.yield();
                } else {
                    break;
                }

//                int i = 5/0;//错误
            } /*catch (InterruptedException e) {
                e.printStackTrace();
            }*/ finally {
                //释放锁
                //不在finally使用则在try若干出现错误不能解锁
                lock.unlock();
            }

        }
    }
}

