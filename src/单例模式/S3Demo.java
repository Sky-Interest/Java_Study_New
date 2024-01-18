package 单例模式;

class S3{
    private S3(){}

    private static S3 s3;

    /*
      双重检查 double check
     */
    public static S3 getInstance(){
        if(s3 == null){
            //加锁，解决线程问题
            synchronized (S3.class){
                if(s3 == null){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    s3 = new S3();
                }
            }
        }

        return s3;
    }
}

public class S3Demo {
    public static void main(String[] args) {

        new Thread(()->{
            for(int i = 0;i<100;i++){
                System.out.println(S3.getInstance());
            }
        },"线程一").start();

        new Thread(()->{
            for(int i = 0;i<100;i++){
                System.out.println(S3.getInstance());
            }
        },"线程二").start();
    }
}
