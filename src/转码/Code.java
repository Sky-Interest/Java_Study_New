package 转码;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Code {
    @Test
    public void fun() throws UnsupportedEncodingException {
        String str = "今晚老地方见";
        System.out.println("默认编码:" + Arrays.toString(str.getBytes()));
        System.out.println("GBK编码:" + Arrays.toString(str.getBytes("GBK")));
        System.out.println("utf-8编码:" + Arrays.toString(str.getBytes("utf-8")));
        byte[] b = new byte[]{-28, -69, -118, -26, -103, -102, -24, -128, -127, -27, -100, -80, -26, -106, -71, -24, -89, -127};
        String str2 = new String(b, 0, b.length);
        System.out.println(str2);
        byte[] b2 = new byte[]{-67, -15, -51, -19, -64, -49, -75, -40, -73, -67, -68, -5};
        String str3 = new String(b2, "GBK");
        System.out.println(str3);
    }
}
