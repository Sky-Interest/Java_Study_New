package 线程优先级;

public class test {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 20 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-"+i);
            }
        },"线程1");
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 20 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-"+i);
            }
        },"线程2");
        //优先级要在线程启动前设置
        t2.setPriority(Thread.MAX_PRIORITY);//优先级最高
        t1.setPriority(Thread.MIN_PRIORITY);
        //线程启动
        t1.start();
        t2.start();


    }
}
