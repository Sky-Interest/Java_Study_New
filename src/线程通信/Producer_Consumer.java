package 线程通信;

public class Producer_Consumer {
    public static void main(String[] args) {
        thing t = new thing();

        producerThread pt = new producerThread(t);
        consumerThread ct = new consumerThread(t);

        new Thread(pt).start();
        new Thread(ct).start();
    }

}

class thing {
    private String name;//名称
    private double price;//价格
    private int flag;//是否继续生产的标志   ：  奇数就消费  偶数就生产

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
class consumerThread implements Runnable {

    private thing t;

    public consumerThread(thing t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (true){

            try {
                //模拟一下吃包子的时间
                Thread.sleep(1000);
                synchronized (t){
                    //判断
                    if(t.getFlag() % 2 == 1){
                        System.out.println("消费者线程正在消费:" + t.getName() + ":价格为:" + t.getPrice());
                        //标志
                        t.setFlag(t.getFlag()+1);//标志是生产线程
                        t.notify();//通知生产者 赶紧生产
                        t.wait();//消费者停止消费
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class producerThread implements Runnable {
    private thing t ;

    public producerThread(thing t) {
        this.t = t;
    }

    @Override
    public void run() {
        int i = 0;
        while (true){

            try {
                //模拟生产包子所需要的时间 为什么是1秒 同频
                Thread.sleep(500);
                synchronized (t){
                    //生产
                    if(t.getFlag() % 2==0){
                        if(i%3==1){
                            t.setName("肉包");
                            t.setPrice(1.5);
                        }else if(i%3==2){
                            t.setName("豆沙包");
                            t.setPrice(1.0);
                        }else{
                            t.setName("奶黄包");
                            t.setPrice(1.5);
                        }

                        i++;
                        t.setFlag(t.getFlag()+1);//标志为消费者线程
                        System.out.println("生产线程在生产:" + t.getName()+",价格:" + t.getPrice());
                        t.notify();//唤醒消费者线程
                        t.wait();//生产进入等待...
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}