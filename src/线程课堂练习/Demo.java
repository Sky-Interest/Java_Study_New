package 线程课堂练习;

public class Demo {
    public static void main(String[] args) {
        ClimbThread ct = new ClimbThread(100,1000,"年轻人");
        ClimbThread ct2 = new ClimbThread(500,1000,"老年人");

        ct.start();
        ct2.start();
    }
}
