package 线程中断;

import java.util.Random;

public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 0;i<500;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"****"+i);
        }
    }
}
