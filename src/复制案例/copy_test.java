package 复制案例;

import java.io.*;

public class copy_test {
    public static void main(String[] args) throws IOException {
        copy_txt();
        copy_pic();
        copy_mp4();
    }
    //复制txt文件
    public static void copy_txt() throws IOException{
        FileInputStream fis = new FileInputStream("d:\\dir\\a.txt");
        FileOutputStream fos = new FileOutputStream("d:\\dir\\b.txt");
        int b = 0;
        while ((b = fis.read()) != -1) {
            fos.write(b);
    }
        fis.close();
        fos.close();
        System.out.println("传输成功");
    }
    public static void copy_pic() throws IOException{
        FileInputStream fis = new FileInputStream("d:\\dir\\高圆圆.jpg");
        FileOutputStream fos = new FileOutputStream("d:\\dir\\mm.jpg");
        int b = 0;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        fis.close();
        fos.close();
        System.out.println("传输成功");

    }
    public static void copy_mp4() throws IOException{
        FileInputStream fis = new FileInputStream("d:\\dir\\哥有老婆.mp4");
        FileOutputStream fos = new FileOutputStream("d:\\dir\\copy.mp4");
        int b = 0;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        fis.close();
        fos.close();
        System.out.println("传输成功");

    }
}
//判断文件后缀
class MyFileNameFilter implements FilenameFilter {
    String name;
    public MyFileNameFilter(String name) {
        this.name = name;
    }
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(this.name);
    }
}
