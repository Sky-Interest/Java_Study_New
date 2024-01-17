package 字符流;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderDemo {
    @Test
    public void fun(){
        File file = new File("d:\\c.txt");
        //读取
        try(Reader r = new FileReader(file)){
            //读取内容
            System.out.println((char)r.read());//好啊好啊 读取一个'好'
            System.out.println((char)r.read());//好啊好啊 读取一个'啊'
            System.out.println((char)r.read());//好啊好啊 读取一个'好'
            System.out.println((char)r.read());//好啊好啊 读取一个'啊'
            System.out.println(r.read());//-1
        }catch (IOException e){

        }
    }

    @Test
    public void fun2(){
        File file = new File("d:\\c.txt");
        //读取
        try(Reader r = new FileReader(file)){
            //读取内容
            char[] cs = new char[4];
            int hasRead = 0;
            //循环
            int count = 0;
            while((hasRead=r.read(cs)) != -1){
                String s = new String(cs,0,hasRead);
                System.out.println(s);
                count++;
            }
            System.out.println("count:" + count);
        }catch (IOException e){

        }
    }
}
