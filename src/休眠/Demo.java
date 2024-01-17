package 休眠;

public class Demo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();

        MyThread mt2 = new MyThread();

        mt.start();
        mt2.start();
    }
}
