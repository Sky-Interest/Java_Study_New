package 单线程与多线程;

public class test {
    public static void main(String[] args) {

        MyThread mt = new MyThread();
        mt.setName("线程1");

        MyThread mt2 = new MyThread();
        mt2.setName("线程2");
        //线程调用类型,手动调用run方法即为普通调用.
        mt2.start();
        mt.start();
        //同一线程只能调用一次start,否则会出现非法状态:
        // IllegalThreadStateException
        // 因为mt线程执行完毕后会进入线程死亡状态
//        mt.start();


    }
}
//重写线程方法
class MyThread extends Thread {
    //方法1:继承Thread类
    @Override
    //重写run方法
    public void run() {
        for (int i = 0; i <20; i++) {
            System.out.println(this.getName() + "-" + i);
        }
    }
}
