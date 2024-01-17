package 打印流;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class PrintDemo {
    @Test
    public void fun(){
        System.out.println("1");
        System.out.println(1);
        System.out.println(new Integer(1));

        //打印到文件中
        try(PrintStream ps = new PrintStream(new File("ps.txt"))){
            //把输出的流向改成打印到控制台
            System.setOut(ps);

            //打印内容到文件中
            ps.print("hello");
            ps.print("\n");
            ps.print("world");
            System.out.println("打印到文件中...");



        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void fun2(){
        //打印到文件中
        try(PrintStream ps = System.out;){
            //把输出的流向改成打印到控制台
            System.setOut(ps);

            ps.print("hello");
            ps.print("\n");
            ps.print("world");
            System.out.println("打印到文件中...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //标准的错误输出
    @Test
    public void fun3(){
        System.err.println("这是错误输出");
        System.out.println("这是标准输出");
    }
}
