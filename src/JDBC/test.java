package JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main(String[] args) {
//        createDatabase();
        createTable();
    }
    public static void createDatabase(){
        //贾链欲执事
        /*
        贾:加载链接
        链：获取链接
        欲：语句对象
        执：执行Sql
        事：释放资源
         */
        //注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //获取连接
        /*
        url:jdbc:mysql://localhost:3306/gec_db
        user:root
        pass:root
         */
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8808/studb", "root", "root123456");
            //创建语句对象Statement
            Statement statement = connection.createStatement();

            //准备sql语句
            String sql = "CREATE DATABASE g2405";

            //执行sql
            statement.execute(sql);
            System.out.println("执行成功");

            //关闭连接和语句对象
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(){
        //贾链欲执事
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8808/studb", "root", "root123456");

            //创建语句对象
            Statement statement = connection.createStatement();
            //sql
            String sql = "CREATE TABLE tb_user(id INT PRIMARY KEY AUTO_INCREMENT,username VARCHAR(30),PASSWORD VARCHAR(30));";

            //执行
            statement.execute(sql);
            System.out.println("创建表成功...");

            //关闭
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
