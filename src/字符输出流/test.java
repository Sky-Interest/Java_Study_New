package 字符输出流;

import java.io.*;

public class test {
    public static void main(String[] args) {
        func();
    }

    public static void func() {
        File file = new File("d:\\dir\\2.txt");
        try (Writer w = new FileWriter(file);) {
            char[] c = {'n', 'o', 'p'};
            w.write(c, 1, 2);
            System.out.println("写完了");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void func2() {
        File file = new File("d:\\dir\\2.txt");
        try (Reader r = new FileReader(file)) {
            char[] c = new char[4];

//            System.out.println("" + r.read(c));
//            System.out.println("读完了");
            int hasRead = 0;
            int count = 0;
            while((hasRead = r.read(c))!=-1) {
                String s = new String(c,0,hasRead);
                System.out.println(s);
                count++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
