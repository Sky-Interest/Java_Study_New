package 匿名和lambda创建线程;

import org.junit.Test;

public class test {
    public static void main(String[] args) {

    }

    public static void func(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20 ; i++) {
                    System.out.println(Thread.currentThread().getName()+"-"+i);
                }
            }
        },"线程1").start();
    }
    //最简化lambda
    public static void func2(){
        Runnable r = ()->{
            for (int i = 0; i < 20 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-"+i);
            }
        };
        new Thread(r).start();
    }
}
