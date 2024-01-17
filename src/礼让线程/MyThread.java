package 礼让线程;

public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 0;i<20;i++){
            System.out.println(getName()+"****"+i);
            if(i == 4){
                System.out.println(getName()+"在礼让...");
                //设置礼让
                Thread.yield();
            }

        }
    }
}
