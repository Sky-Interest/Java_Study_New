package 线程中断;

public class MyRunnable implements Runnable {
    boolean isInterupted = false;

    @Override
    public void run() {
        //如果没有中断
        while(!isInterupted){
            //在适当的时候检查
            if(Thread.currentThread().isInterrupted()){
                //中断
                isInterupted = true;
            }
        }

        //业务逻辑...
        for(int i = 0;i<50;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void interupte(){
        isInterupted = true;
    }
}
