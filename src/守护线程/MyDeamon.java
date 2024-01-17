package 守护线程;

public class MyDeamon extends Thread {
    @Override
    public void run() {
        while(true){
            System.out.println(getName()+"我是守护线程...");
        }
    }
}
