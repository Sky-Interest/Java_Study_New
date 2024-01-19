package 线程通信;

class PrintWord{
    int count =1;
    public void print1(){
        for(int i = 1;i<=10;i++){
            synchronized (Object.class){
                try{
                    if(count != 1){
                        Object.class.wait();//当前打印的线程就进入等待
                    }
                    System.out.print("今");
                    System.out.print("天");
                    System.out.print("天");
                    System.out.print("气");
                    System.out.print("好");
                    System.out.println();
                    this.count = 2;
                    Object.class.notifyAll();//把另外一个线程唤醒
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Object.class.notifyAll();//把另外一个线程唤醒
                }
            }
        }
    }


    public void print2(){
        for(int i = 1;i<=10;i++){
            synchronized (Object.class){
                try{
                    if(count != 2){
                        Object.class.wait();//当前打印的线程就进入等待
                    }
                    System.out.print("我");
                    System.out.print("想");
                    System.out.print("晒");
                    System.out.print("太");
                    System.out.print("阳");
                    System.out.println();
                    this.count = 1;
                    Object.class.notifyAll();//把另外一个线程唤醒
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Object.class.notifyAll();//把另外一个线程唤醒
                }
            }
        }
    }
    public void print3(){
        for(int i = 1;i<=10;i++){
            synchronized (Object.class){
                try{
                    if(count != 3){
                        Object.class.wait();//当前打印的线程就进入等待
                    }
                    System.out.print("我");
                    System.out.print("想");
                    System.out.print("打");
                    System.out.print("原");
                    System.out.print("神");
                    System.out.println();
                    this.count = 1;
                    Object.class.notifyAll();//把另外一个线程唤醒
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Object.class.notifyAll();//把另外一个线程唤醒
                }
            }
        }
    }


}


public class Demo {
    public static void main(String[] args) {
        PrintWord pd = new PrintWord();
        new Thread(()->{
            pd.print1();
        }).start();

        new Thread(()->{
            pd.print2();
        }).start();

        new Thread(()->{
            pd.print3();
        }).start();
    }
}
