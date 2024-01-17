package 卖票Runnable;

public class Demo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread mt1 = new Thread(mr,"窗口1");
        Thread mt2 = new Thread(mr,"窗口2");
        Thread mt3 = new Thread(mr,"窗口3");

        //启动3个窗口卖票
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
