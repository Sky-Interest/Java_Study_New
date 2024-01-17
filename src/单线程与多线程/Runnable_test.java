package 单线程与多线程;

public class Runnable_test {
//方法2:实现Runnable方式
    public static void func2() {
        //方法2
        //创建线程对象
        MyRunnable mr = new MyRunnable();
        //不能直接调用start
        //借助Thread
        Thread t = new Thread(mr);
        Thread t2 = new Thread(mr);
        //设置线程名称
        t.setName("线程一");
        t2.setName("线程二");

        //启动线程
        t.start();
        t2.start();
    }

}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "_" + i);
        }
    }
}
