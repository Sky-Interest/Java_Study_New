package 卖票Runnable;

public class MyRunnable  implements Runnable{
    int tickets = 10;

    @Override
    public void run() {
        while (true){
            if(tickets>0){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在售卖第" + tickets-- + "票" );
            }else {
                System.out.println("票源已售罄...");
                break;
            }
        }
    }
}
