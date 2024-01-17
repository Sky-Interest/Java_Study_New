package 单线程与多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Callable_test {

    //方法3用法
    public static void func3() throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        //计算结果封装在FutureTask对象
        FutureTask ft = new FutureTask(mc);
        //借助Thread
        Thread t = new Thread(ft);
        //启动
        t.start();
        System.out.println("1-36累加结果:"+ft.get());

    }

}
class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {


        int sum = 0;
        for (int i = 0; i < 37; i++) {
            sum += i;

        }
        return sum;
    }
}
