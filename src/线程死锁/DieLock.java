package 线程死锁;

public class DieLock extends Thread{
    public DieLock(boolean flag) {
        this.flag = flag;
    }

    private boolean flag ;

    public static final Object obja = new Object();
    public static final Object objb = new Object();

    @Override
    public void run() {
    //解决方式:顺序获取锁

                if(flag) {
                    synchronized (obja){
                        System.out.println(getName()+"拿到锁a");
                        synchronized (objb){
                            System.out.println(getName()+"拿到锁b");
                        }
                    }
                }else {
                    synchronized (objb){
                        System.out.println(getName()+"拿到锁b");
                        synchronized (obja){
                            System.out.println(getName()+"拿到锁a");
                        }
                    }

                }
    }
}

