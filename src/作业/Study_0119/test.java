package 作业.Study_0119;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test{
    public static void main(String[] args) {
        dieLock_func();
//        pdc_csm_func();
//        threadPool_func();
    }
    public static void dieLock_func(){
        dieLock dl1 = new dieLock(true);
        dieLock dl2 = new dieLock(false);

        dl1.setName("a");
        dl2.setName("b");

        dl1.start();
        dl2.start();
    }

    public static void pdc_csm_func(){
        Goods g = new Goods();
        pdcThread pt = new pdcThread(g);
        csmThread ct = new csmThread(g);

        new Thread(pt).start();
        new Thread(ct).start();

    }

    public static void threadPool_func(){
        /*
        int corePoolSize: 核心线程数
        int maximumPoolSize：最大的线程数
        long keepAliveTime：线程存活时间
        TimeUnit unit：时间单位
        BlockingQueue<Runnable> workQueue 任务队列
         */
        ExecutorService exec = new ThreadPoolExecutor(3,5,30L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(300)
                );
        System.out.println("线程池初始状态"+exec);
        //创建任务对象
        myThread mt = new myThread();
        myThread mt2 = new myThread();
        myThread mt3 = new myThread();
        myThread mt4 = new myThread();
        myThread mt5 = new myThread();
        //提交任务
        exec.submit(mt);
        exec.submit(mt2);
        exec.submit(mt3);
        exec.submit(mt4);
        exec.submit(mt5);
        //查看线程池状态
        System.out.println("线程池当前状态"+exec);
        //关闭线程池的两种方式
        exec.shutdown();//线程完成任务后关闭
//        exec.shutdownNow();//马上关闭线程池




    }
}
class dieLock extends Thread{
    private boolean f;

    public dieLock(boolean f) {
        this.f = f;
    }

    public static final Object la = new Object();
    public static final Object lb = new Object();

    @Override
    public void run(){
        //拿到锁的顺序不同,导致死锁
        //解决方法,按照顺序拿锁
        if (f){
            synchronized (la) {
                System.out.println(getName() + "拿到锁a");
                synchronized (lb) {
                    System.out.println(getName() + "拿到锁b");
                }
            }
        }else{
            synchronized (lb) {
                System.out.println(getName() + "拿到锁b");
                synchronized (la){
                    System.out.println(getName()+"拿到锁a");
                }
            }
        }

    }
}

class Goods{
    private String name;

    private double price;

    private boolean flag = true;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class csmThread implements Runnable{
    public csmThread(Goods g) {
        this.g = g;
    }

    private Goods g;

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(500);
                synchronized (g) {
                    if (g.getFlag()==false){
                        System.out.println("消费者进程正在运行:"+g.getName()+"\t价格为:"+g.getPrice());
                        //标志
                        g.setFlag(true);//生产者进程标志
                        g.notify();//唤醒生产者进程
                        g.wait();//停止消费者进程

                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}

class pdcThread implements Runnable{

    private Goods g ;

    public pdcThread(Goods g) {
        this.g = g;
    }

    @Override
    public void run() {
        int i = 0;
        while (true){

            try {
                Thread.sleep(500);
                synchronized (g){
                    //生产
                    if(g.getFlag()==true){
                        if(i%3==1){
                            g.setName("电脑");
                            g.setPrice(3000.0);
                        }else if(i%3==2){
                            g.setName("冰箱");
                            g.setPrice(5000);
                        }else{
                            g.setName("核弹");
                            g.setPrice(100000000);
                        }

                        i++;
                        g.setFlag(false);//标志为消费者线程
                        System.out.println("生产线程在生产:" + g.getName()+"\n价格为:" + g.getPrice());
                        g.notify();//唤醒消费者线程
                        g.wait();//停止生产
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class myThread extends Thread {
    @Override
    public void run() {
        for(int i =0;i<30;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"在做第"+i+"个任务");
        }
        System.out.println("线程任务全部完成");
    }
}


