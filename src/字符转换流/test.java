package 字符转换流;

import java.io.*;

public class test {
    public static void main(String[] args) {
            out_put();
            in_put();
    }
    public static void out_put(){
        File file = new File("d:\\dir\\3.txt");

        try(//输出流
            OutputStream ops = new FileOutputStream(file);
            //
            OutputStreamWriter osw = new OutputStreamWriter(ops, "UTF-8")
        ){
            //写出字符串
            osw.write("你好");
            System.out.println("写完了");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void in_put(){
        File file = new File("d:\\dir\\3.txt");

        try(//把file的内容读取到is
                InputStream is = new FileInputStream(file);
                //把
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
        ){

            System.out.println("读:"+(char)isr.read());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
