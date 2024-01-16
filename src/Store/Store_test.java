package Store;

import java.util.Scanner;

public class Store_test {
    //列表储存
    static Goods[] goodsList = {
            new Goods(1, "电风扇", 114.5),
            new Goods(2, "洗衣机", 1919.80),
            new Goods(3, "电视机", 11451.4),
            new Goods(4, "空气", 0),
            new Goods(5, "宝马", 114514),

    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        if ("Sky_Interest".equals(username) && "114514191980".equals(password)) {
            System.out.println("登录成功！");
            show();
            System.out.println("请输入商品编号：");
            int id = scanner.nextInt();
            System.out.println("请输入批发数量：");
            int quantity = scanner.nextInt();

            double amount = cal(id, quantity);
            System.out.println("需要付款的金额：" + change(amount));
        } else {
            System.out.println("登录不成功！");
        }
    }
    //创建show方法
    public static void show() {
        for (Goods item : goodsList) {
            System.out.println("编号：" + item.id + " 名称：" + item.name + " 价格：" + item.price + "元");
        }
    }
    public static double cal(int id, int quantity) {
        for (Goods item : goodsList) {
            if (item.id == id) {
                return item.price * quantity;
            }
        }
        return 0;
    }
    //创建Goods类
    static class Goods {
        int id;
        String name;
        double price;
        public Goods(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    public static StringBuffer change(double d) {
        StringBuffer str = new StringBuffer(String.valueOf(d));
        for (int i = str.indexOf(".") - 3; i > 0; i = i - 3) {
            str.insert(i, ',');
        }
        return str;
    }

    int[] a = new int[5];
}