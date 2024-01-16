package StringBuffer_Test;

public class StringBuffer_1 {
    public static void main(String[] args) {
        String str = new String("Yes");

        StringBuffer strbuf = new StringBuffer("Now!");
        strbuf.append("Time!");
        System.out.println(strbuf);
    }
}
