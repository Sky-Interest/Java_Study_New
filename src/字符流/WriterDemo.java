package 字符流;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo {
    @Test
    public void fun(){
        File file = new File("d:\\c.txt");
        //创建字符输出流对象
        try(Writer w = new FileWriter(file)){
            //写内容
            w.write("你");
            w.write("好");
            w.write("啊");
            System.out.println("写完了...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun2(){
        File file = new File("d:\\c.txt");
        //创建字符输出流对象
        try(Writer w = new FileWriter(file)){
            //写内容
            char[] cs = {'你','好','啊'};
            w.write(cs);
            System.out.println("写完了...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun3(){
        File file = new File("d:\\c.txt");
        //创建字符输出流对象
        try(Writer w = new FileWriter(file)){
            //写内容
            char[] cs = {'你','好','啊'};
            w.write(cs,1,2);
            System.out.println("写完了...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun4(){
        File file = new File("d:\\c.txt");
        //创建字符输出流对象  append true:追加
        try(FileWriter w = new FileWriter(file,true)){
            //写内容
            char[] cs = {'你','好','啊'};
            w.write(cs,1,2);
            System.out.println("写完了...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
