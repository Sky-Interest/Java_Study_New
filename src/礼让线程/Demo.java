package 礼让线程;

public class Demo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        MyThread mt2 = new MyThread();

        //启动线程
        mt.start();
        mt2.start();
    }
}
