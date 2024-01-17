package 线程中断;

public class InteruptDemo2 {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t = new Thread(mr);
        Thread t2 = new Thread(mr);
        t.start();
        mr.interupte();//中断线程

        t2.start();
    }
}
