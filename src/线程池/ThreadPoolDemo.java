package 线程池;

import java.util.concurrent.*;

class MyThread extends Thread{
    @Override
    public void run() {
        for(int i =0;i<30;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"---"+i);
        }
    }
}

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        //创建线程池

        //阿里开发手册不推荐下面的写法，因为容易导致OOM 内存溢出
        //ExecutorService executorService = Executors.newFixedThreadPool(3);

        //建议下面写法
        /*
        int corePoolSize: 核心线程数
        int maximumPoolSize：最大的线程数
        long keepAliveTime：线程存活时间
        TimeUnit unit：时间单位
        BlockingQueue<Runnable> workQueue 任务队列
         */
        ExecutorService executorService = new ThreadPoolExecutor(4,5,50L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(300));
        System.out.println("线程池初始状态:" + executorService);
        //创建4个线程任务对象
        MyThread mt = new MyThread();
        MyThread mt2 = new MyThread();
        MyThread mt3 = new MyThread();
        MyThread mt4 = new MyThread();
        //提交任务给线程池
        executorService.submit(mt);
        executorService.submit(mt2);
        executorService.submit(mt3);
        executorService.submit(mt4);

        //Thread.sleep(2000);
        System.out.println("线程池现在状态:" + executorService);

        //Thread.sleep(2000);
        //关闭线程池
        executorService.shutdown();//等待线程任务完成后关闭
        //executorService.shutdownNow();//不等待线程任务完成，立刻关闭
    }
}
