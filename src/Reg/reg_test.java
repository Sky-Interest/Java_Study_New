package Reg;

import java.util.Scanner;

public class reg_test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //身份者,手机号,座机号
        String uid, uphone, utele;
//        System.out.println("请输入手机号");
//        uphone = sc.next();
//        System.out.println("请输入座机号");
//        utele = sc.next();
//        System.out.println(uid);
//        System.out.println(uphone);
//        System.out.println(utele);
//        StringBuffer sbf = new StringBuffer(utele);
//        //分隔符索引定位
//        String del = "-";
//        int index = sbf.indexOf(del);

//        System.out.println(index);
//        //分割后字符串存储
//        String utele_1 = sbf.substring(0, index);
//        String utele_2 = sbf.substring(index+1);
//        System.out.println(utele_1);
//        System.out.println(utele_2);

        while (true) {
            System.out.println("请输入身份证");
            uid = sc.next();
            System.out.println(uid);
            //判断身份证长度==16 or 18
            if (uid.length() == 16 || uid.length() == 18) {
                System.out.println("请输入手机号");
                uphone = sc.next();
                //判断手机号长度 == 11
                if (uphone.length() == 11) {
                    System.out.println("请输入座机号");
                    utele = sc.next();
                    StringBuffer sbf = new StringBuffer(utele);
                    //分隔符索引定位
                    String del = "-";
                    int index = sbf.indexOf(del);
                    //分割后字符串存储
                    String utele_1 = sbf.substring(0, index);
                    String utele_2 = sbf.substring(index + 1);
                    //判断座机号
                    if (utele_1.length() == 4 || utele_2.length() == 7) {
                        System.out.println("注册成功!");
                        break;
                    } else {
                        System.out.println("座机区号必须为4位,电话号码必须是7位!");
                    }
                } else {
                    System.out.println("手机号必须是11位!");
                }
            } else {
                System.out.println("身份者必须是16位或18位!");
            }
        }
    }
}
