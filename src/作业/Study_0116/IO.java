package 作业.Study_0116;

import java.io.*;

public class IO {
    public static void main(String[] args) {

//        searchAndReplace_str();
//        copy_file();
//        copy_file_bf();
//        copy_pic();
//        copy_file_char();
    }

    public static void searchAndReplace_str() {
        File f = new File("D:\\Java_Study\\Java_Study_New\\src\\作业.Study_0116\\pet.template");
        File f_w = new File("D:\\dir\\pet.txt");
        try (
                BufferedReader r = new BufferedReader(new FileReader(f));
                BufferedWriter w = new BufferedWriter(new FileWriter(f_w));
        ) {
            String line = null;
            String line1 = null;

            while ((line = r.readLine()) != null) {
                System.out.print("替换前:" + line + "\n");
                line1 = line.replace("{name}", "老师").replace("{type}", "狗").replace("{master}", "浦和花子");
                System.out.print("替换后:" + line1 + "\n");
                w.write(line1);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void copy_file(){
        //读取文件目录
        File f = new File("src/作业.Study_0116/a.txt");
        //输出文件目录
        File f_w = new File("src/作业.Study_0116/b.txt");

        try(
                //文件读取器
                FileReader fr = new FileReader(f);
                //文件写入器
                FileWriter fw = new FileWriter(f_w);

                ){
            //以1kb读取的缓冲
            char[] ch = new char[1024];
            int l;
            while ((l = fr.read(ch)) != -1){
                //
                fw.write(l);
            }
            System.out.println("复制成功");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void copy_file_bf(){
        //读取文件目录
        File f = new File("src/作业.Study_0116/a.txt");
        //输出文件目录
        File f_w = new File("src/作业.Study_0116/b.txt");

        try(
                //字符流缓冲
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(f), "UTF-8"));
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(f_w), "UTF-8"));
        ){
            String l ;
            while ((l = br.readLine()) != null){
                bw.write(l);

            }
            System.out.println("复制成功");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void copy_pic() {

        int b = 0;
        byte[] by = new byte[1024];
        try (
                FileInputStream fis = new FileInputStream("src/作业.Study_0116/top.bmp");
                FileOutputStream fos = new FileOutputStream("src/作业.Study_0116/myPicture.bmp");
                ){
            while ((b = fis.read(by)) != -1) {
                fos.write(by,0,b);
            }

            System.out.println("传输成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void copy_file_char(){
        File f = new File("d:\\dir\\5.txt");
        File f_w = new File("d:\\dir\\5_w.txt");

        try (
                //字符流
                InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "UTF-8");
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f_w), "UTF-8");

                BufferedReader br = new BufferedReader(isr);
                BufferedWriter bw = new BufferedWriter(osw);

                )
        {
            String l ;
            while ((l = br.readLine()) != null){
                bw.write(l);

            }
            System.out.println("输出成功");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
