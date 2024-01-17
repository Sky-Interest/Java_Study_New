package 序列化流;

import org.junit.Test;

import java.io.*;

public class ObjectStreamDemo {
    @Test
    public void fun(){
        //创建File对象
        File file = new File("p.txt");
        //创建Person对象
        Person p = new Person("张三");

        //把对象序列化到文件中，把看得懂的东西变成看不懂的！
        try(OutputStream os = new FileOutputStream(file);
            //序列化对象
            ObjectOutputStream oos = new ObjectOutputStream(os)
        ){
            //writeObject方法
            oos.writeObject(0);
            //写对象
            oos.writeObject(p);
            System.out.println("写完了...");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void fun2(){
        //创建File对象
        File file = new File("p.txt");
        //创建Person对象
        Person p = new Person("张三");

        //用代码把看不懂的内容，变得看得懂
        try(InputStream is = new FileInputStream(file);
            //反序列化对象
            ObjectInputStream ois = new ObjectInputStream(is)
        ){
            //readObject方法
            Object o = ois.readObject();
            System.out.println("写完了..." + o );

            Person p2 = (Person)ois.readObject();
            System.out.println(p2);
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
