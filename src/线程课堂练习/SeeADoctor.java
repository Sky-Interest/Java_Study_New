package 线程课堂练习;

public class SeeADoctor extends Thread{

    Thread vip;
    public SeeADoctor(Thread vip) {
        this.vip = vip;
    }

    @Override
    public void run() {
        for(int i =1;i<51;i++){
            System.out.println(getName() +":"+i+"号病人在看病");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //当普通号看到第10个时，强制插队
            if(i==10){
                try {
                    vip.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
