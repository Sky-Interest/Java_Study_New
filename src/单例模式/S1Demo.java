package 单例模式;

import java.util.Calendar;

/*
  1 私有的构造器.
  2 私有的静态的变量
  3 有一个公共的静态访问实例方法并返回
 */
class S1{
    //饿汉式 ，特点：类一加载就会马上创建实例，缺点：启动应用（系统）时会占内存，抢时间
    private S1(){}

    private static S1 instance = new S1();

    public static S1 getInstance(){
        return instance;
    }
}

public class S1Demo {
    public static void main(String[] args) {
        S1 instance = S1.getInstance();
        S1 instance2 = S1.getInstance();
        System.out.println(instance == instance2);

    }
}
