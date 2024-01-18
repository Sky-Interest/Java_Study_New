package 线程通信;

public class test {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        MyThread mt2 = new MyThread();

        mt.setName("线程1");
        mt2.setName("线程2");

        mt.start();
        mt2.start();
    }
}
class MyThread extends Thread {
    private static int num = 0;//static共享资源
    private static String obj = new String();

    @Override
    public void run() {
        while (true){
            synchronized (obj) {
                //唤醒方法:唤醒别的等待线程
                obj.notify();
                //判断
                if(num>50){
                    break;
                }
                System.out.println(getName()+":"+num);
                num++;
                try {
                    //自己暂停,让下个进程继续打印,调用wait释放锁
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
