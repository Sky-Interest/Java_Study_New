package 单例模式;

class S4{
    private S4(){}

    public static S4 getInstance(){
        return S4Inner.INSTANCE;
    }

    //通过一个内部类来创建S4的实例
    private static class S4Inner{
        private static final S4 INSTANCE = new S4();
    }
}

public class S4Demo {
    public static void main(String[] args) {
        new Thread(()->{
            for(int i = 0;i<100;i++){
                System.out.println(S4.getInstance());
            }
        },"线程一").start();

        new Thread(()->{
            for(int i = 0;i<100;i++){
                System.out.println(S4.getInstance());
            }
        },"线程二").start();
    }
}
