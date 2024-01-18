package 线程死锁;

public class test {
    public static void main(String[] args) {
        DieLock dl1 = new DieLock(true);
        DieLock dl2 = new DieLock(false);

        dl1.setName("1");
        dl2.setName("2");

        dl1.start();
        dl2.start();
    }
}
