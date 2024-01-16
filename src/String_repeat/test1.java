package String_repeat;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputs,word;
        System.out.println("请输入一个字符串:");
        inputs = sc.next();
        System.out.println("请输入要查找的字符:");
        word = sc.next();
        int count = counter(inputs,word);
        System.out.println("字符:"+"\""+inputs+"\""+"中包含"+count+"个"+"\""+word+"\"");
    }
    public static int counter(String inputs,String word) {
        int c = 0;
        for (int i = 0; i <inputs.length(); i++) {
            if (inputs.substring(i , i+1).equals(String.valueOf(word))){
                c++;
            }
        }
        return c;
    }
}
