package 作业.Study_0124;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBCPDemo {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:8808/gb1840";
        String username = "root";
        String password = "root123456";
        String dirverClassName = "com.mysql.cj.jdbc.Driver";


        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(dirverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        // 创建连接对象
        Connection connection = ds.getConnection();

        Statement Statement = connection.createStatement();
        String sql = "select * from tb_user";
        ResultSet resultSet = Statement.executeQuery(sql);
        while(resultSet.next())
        {
            System.out.println("name:"+resultSet.getString("name"));
        }
        Connection.close();  //关闭数据库连接，数据库连接池中重写了close方法，它表示把数据库连接对象归还到了连接池当中，并不是彻底的销毁。


    }
}


