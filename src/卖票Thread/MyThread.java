package 卖票Thread;

public class MyThread extends Thread {
    int tickets = 10;

    String name;
    public MyThread(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        while (true){
            if(tickets>0){
                System.out.println(this.name+"正在售卖第" + tickets-- + "票" );
            }else {
                System.out.println("票源已售罄...");
                break;
            }
        }
    }
}
