package 卖票Thread;

public class Demo {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("窗口1");
        MyThread mt2 = new MyThread("窗口2");
        MyThread mt3 = new MyThread("窗口3");

        //启动3个窗口卖票
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
