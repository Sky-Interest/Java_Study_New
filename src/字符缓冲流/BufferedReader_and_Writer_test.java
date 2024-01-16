package 字符缓冲流;

import java.io.*;

public class BufferedReader_and_Writer_test {
    public static void main(String[] args) {

    }
    public static void bf_Read(){
        File f = new File("d:\\dir\\4.txt");

        try (
                Reader r = new FileReader(f);
                //带缓冲的输入流
                BufferedReader br = new BufferedReader(r);
        ){
            String line = null;
            while (//如果读取的行内容不为空
                    (line = br.readLine()) != null
            ){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void bf_Writer(){
        File f = new File("d:\\dir\\4.txt");
        try (
                Writer w = new FileWriter(f, true);
                //带缓冲的输出流
                BufferedWriter bw = new BufferedWriter(w);
        ){

            bw.write("你好啊");


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
