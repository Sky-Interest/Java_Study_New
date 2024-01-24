package 数据库连接池.src.com.gec.testpool;



import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import 数据库连接池.src.com.gec.service.BookService;
import 数据库连接池.src.com.gec.service.impl.BookServiceImpl;
import 数据库连接池.src.com.gec.utils.JDBCUtil;

import java.sql.*;

public class Demo {

   @Test
   public void fun(){
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUsername("root");
        bds.setPassword("root");
        bds.setUrl("jdbc:mysql:///g2405");

        System.out.println("----------------");
        try{
            Connection conn = bds.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from t_book");
            while (rs.next()){
                System.out.println(rs.getString("book_no"));
                System.out.println(rs.getString("book_name"));
                System.out.println(rs.getString("book_price"));
                System.out.println(rs.getString("book_author"));
                System.out.println(rs.getString("book_date"));
                System.out.println("++++++++++++++++++++++");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void fun2(){
        BookService service = new BookServiceImpl();
        service.findAllBooks().forEach(book -> System.out.println(book));
    }

    @Test
    public void fun4(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql:///g2405", "root", "root2");
            System.out.println(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun3(){
        Connection conn = JDBCUtil.getConnection();
        System.out.println(conn.hashCode());

    }

    @Test
    public void fun5(){
        Connection conn = JDBCUtil.getConnection();
        System.out.println(System.identityHashCode(conn));
        Connection conn2 = JDBCUtil.getConnection();
        System.out.println(System.identityHashCode(conn));
        Connection conn3 = JDBCUtil.getConnection();
        System.out.println(System.identityHashCode(conn));
        Connection conn4 = JDBCUtil.getConnection();
        System.out.println(System.identityHashCode(conn));

    }
}
