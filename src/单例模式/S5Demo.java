package 单例模式;

enum S5{
    INSTANCE;
}

public class S5Demo {
    public static void main(String[] args) {
        new Thread(()->{
            for(int i = 0;i<100;i++){
                System.out.println(System.identityHashCode(S5.INSTANCE));
            }
        },"线程一").start();

        new Thread(()->{
            for(int i = 0;i<100;i++){
                System.out.println(System.identityHashCode(S5.INSTANCE));
            }
        },"线程二").start();
    }
}
