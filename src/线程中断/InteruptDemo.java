package 线程中断;

public class InteruptDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        MyThread mt2 = new MyThread();

        mt.setName("线程1，要中断的");
        mt2.setName("线程2");

        mt.start();
        mt.interrupt();//中断线程

        mt2.start();
    }
}
