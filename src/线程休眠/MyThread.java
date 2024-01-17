package 线程休眠;

import java.util.Random;

public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 0;i<20;i++){
            if(i == 10){
                try {
                    System.out.println(getName()+"开始休眠，会把cpu的执行权让出去...");
                    //随机时间的休眠
                    Thread.sleep(new Random().nextInt(300));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(getName()+"****"+i);
        }
    }
}
