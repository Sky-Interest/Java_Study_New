package StringBuffer_Test;

public class StringBufferDemo {
    public static void main(String[] args) {
        /*
        String s = "hello";
        System.out.println(s.hashCode());
        s += "world";
        System.out.println(s.hashCode());
         */
        String s = new String("hello");
        System.out.println(s.hashCode());
        s += "world";
        System.out.println(s.hashCode());


        //创建字符对象
        StringBuffer sbf = new StringBuffer("hello");
        System.out.println(sbf.hashCode());
        //追加内容
        sbf.append("world");
        System.out.println(sbf.hashCode());
        System.out.println(sbf);

        //按指定位置插入
        sbf.insert(1,"aa");
        System.out.println(sbf);//haaelloworld

        //反转  dlrowolleaah
        System.out.println(sbf.reverse());

        //截取字符串
        StringBuffer sbf2 = new StringBuffer("今天天气很好");
        System.out.println(sbf2.substring(0, 2));
        System.out.println(sbf2.substring(2));

    }
}
