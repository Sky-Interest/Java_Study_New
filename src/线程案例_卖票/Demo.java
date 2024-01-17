package 线程案例_卖票;

public class Demo {
    public static void main(String[] args) {
        Runnable_func();
        Thread_func();
    }
    public static void Runnable_func(){
        MyRunnable mr = new MyRunnable();
        Thread mt1 = new Thread(mr,"窗口1");
        Thread mt2 = new Thread(mr,"窗口2");
        Thread mt3 = new Thread(mr,"窗口3");

        //启动3个窗口卖票
        mt1.start();
        mt2.start();
        mt3.start();
    }
    public static void Thread_func(){
        MyThread mt1 = new MyThread("窗口1");
        MyThread mt2 = new MyThread("窗口2");
        MyThread mt3 = new MyThread("窗口3");

        //启动3个窗口卖票
        mt1.start();
        mt2.start();
        mt3.start();
    }
}

class MyRunnable  implements Runnable{
    int tickets = 10;

    @Override
    public void run() {
        while (true){
            if(tickets>0){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在售卖第" + tickets-- + "票" );
            }else {
                System.out.println("票源已售罄...");
                break;
            }
        }
    }
}
class MyThread extends Thread {
    int tickets = 10;

    String name;
    public MyThread(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        while (true){
            if(tickets>0){
                System.out.println(this.name+"正在售卖第" + tickets-- + "票" );
            }else {
                System.out.println("票源已售罄...");
                break;
            }
        }
    }
}