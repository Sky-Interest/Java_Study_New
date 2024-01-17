package 合并流;

import org.junit.Test;

import java.io.*;

public class Demo {
    @Test
    public void fun(){
        File file = new File("1.txt");
        File file2 = new File("2.txt");
        try(FileInputStream fis = new FileInputStream(file);
            FileInputStream fis2 = new FileInputStream(file2);
            //合并流 1.txt合并2.txt
            SequenceInputStream sis = new SequenceInputStream(fis,fis2);
            //输出流合并成3.txt
            FileOutputStream fos = new FileOutputStream("3.txt")
        ){
            //读取内容
            int hasRead =0;
            while((hasRead = sis.read()) >0){
                //写内容
                fos.write(hasRead);
            }

            //合并完成
            System.out.println("已合并...");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
