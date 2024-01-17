package join方法;

public class 小霸王Demo {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        mt.start();

        for(int i = 0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+"****"+i);
            //判断
            if(i == 4){
                //加入线程 此时的main就会暂时停止执行，直到mt线程死亡之后
                mt.join();
            }
        }
    }
}
