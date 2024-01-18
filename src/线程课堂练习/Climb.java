package 线程课堂练习;


public class Climb {
    public static void main(String[] args) {
        func();
    }

    public Climb() {

    }

    public static void func() {
        MyRunnable mr = new MyRunnable();
        Thread mt1 = new Thread(mr, "年轻人");
        Thread mt2 = new Thread(mr, "老年人");



        mt1.start();
        mt2.start();
    }
}
class MyRunnable implements Runnable{
    int high = 4300;

    @Override
    public void run() {
        while(high>0){
        System.out.println(Thread.currentThread().getName()+"爬完100米");
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        }

//        ReentrantLock lock = new ReentrantLock();

        /*while (true) {
            lock.lock();//lock
            try {
                if(high>0){
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    int once_climb = 100;
                    high -= once_climb;
                    System.out.println(Thread.currentThread().getName()+"爬完100米");

                }else{
                    System.out.println(Thread.currentThread().getName()+"到达终点");
                    break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally{
                lock.unlock();
            }
        }*/

    }
}
