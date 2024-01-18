package 单例模式;

class S2{
    private S2(){}

    private static S2 s2;

    public static S2 getInstance(){
        if(s2 == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s2 = new S2();
        }

        return s2;
    }
}

public class S2Demo {
    public static void main(String[] args) {
        /*
        S2 instance = S2.getInstance();
        S2 instance2 = S2.getInstance();
        System.out.println(instance == instance2);//有线程安全问题

        System.out.println("----------------------------");
         */
        new Thread(()->{
            for(int i = 0;i<100;i++){
                System.out.println(S2.getInstance());
            }
        },"线程一").start();

        new Thread(()->{
            for(int i = 0;i<100;i++){
                System.out.println(S2.getInstance());
            }
        },"线程二").start();
    }
}
