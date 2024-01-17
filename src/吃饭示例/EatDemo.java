package 吃饭示例;

public class EatDemo {
    public static void main(String[] args) {
        Person p = new Person();
        p.eat();

        System.out.println("------------");
        /*
        模式最早是建筑行业，经过大量建筑，有人发现，某种结构会更结实，美观，大气，合理
        画成图纸...有图纸，有参数，就能立刻复制出来...
        模式就流行开了，因为模式NB，你也NB
         */
        Canteness c = new Canteness(p);
        c.eat();
    }
}
