package 线程课堂练习;

public class ClimbThread extends Thread {
    String name;//线程名称
    int time;
    int num;

    public ClimbThread( int time, int num,String name) {
        this.time = time;
        this.num = num;
        this.name = name;
    }

    @Override
    public void run() {
        while(num>0){
            System.out.println(name + "爬完100米");
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num-=100;
        }
        System.out.println(name + "到达终点");
    }
}
