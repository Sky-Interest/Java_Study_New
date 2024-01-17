package 吃饭示例;

public class Canteness {
    Person p;
    public Canteness(Person p){
        this.p = p;
    }

    public void drinkSoup(){
        System.out.println("五指毛桃汤...");
    }

    public void eat(){
        this.drinkSoup();
        p.eat();
    }
}
