package join方法;

public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 0;i<20;i++){
            System.out.println(getName()+"****"+i);
        }
    }
}
