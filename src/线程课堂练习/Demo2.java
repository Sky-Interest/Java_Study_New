package 线程课堂练习;

public class Demo2 {
    public static void main(String[] args) {
        //特需号  main线程 Thread.currentThread获得
        Thread vip = Thread.currentThread();
        vip.setName("特需号");
        vip.setPriority(10);

        //普通号
        SeeADoctor sd = new SeeADoctor(vip);
        sd.setName("普通号");
        sd.setPriority(1);


        sd.start();

        for(int i =1;i<11;i++){
            System.out.println(Thread.currentThread().getName() +":"+i+"号病人在看病");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
