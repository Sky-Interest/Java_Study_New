package 守护线程;

public class DaemonDemo {
    public static void main(String[] args) {
        MyDeamon md = new MyDeamon();
        //设置为守护线程
        //守护线程不会干扰别的线程任务执行，别的线程运行时，它守护（陪护），除了守护线程外，其它执行完毕，守护线程就会退出
        //比如说 数据库连接池，如果操作数据库的线程结束后，连接对象就会释放掉操作对象获取的连接，然后连接归还到连接池里面
        //再比如说 公交车在正常营运时间运行，到晚上，所有的公交车会停放到公交总站
        md.setDaemon(true);
        md.start();//启动线程

        System.out.println("main线程的普通打印...");
    }
}
