package 数据库连接池.src.com.gec.testqr;

import 数据库连接池.src.com.gec.entity.Book;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import 数据库连接池.src.com.gec.utils.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QueryRunnerDemo {
    @Test
    public void fun(){
        //添加书籍
        String sql = "insert into t_book(book_no,book_name,book_price,book_author,book_date)values(?,?,?,?,?)";
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql,"4","红楼梦",23.3,"曹雪芹","1793-11-11");
            System.out.println("书籍插入成功...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void fun2(){
        //添加书籍
        String sql = "update t_book set book_name=?,book_price=?,book_author=?,book_date=? where book_no=?";
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql,"红楼梦2",23.3,"高鄂","1799-11-11","4");
            System.out.println("书籍修改成功...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询
    @Test
    public void fun3(){
        String sql = "select book_no bookNo,book_name bookName,book_price bookPrice,book_author bookAuthor," +
                "book_date bookDate from t_book where book_no = ?";
        //查询
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        //结果的封装类

        ResultSetHandler<Book> rsh = new BeanHandler<>(Book.class);
        try {
            Book book = qr.query(sql, rsh,"2");
            System.out.println(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun4(){
        String sql = "select book_no bookNo,book_name bookName,book_price bookPrice,book_author bookAuthor," +
                "book_date bookDate from t_book ";
        //查询
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);

        ResultSetHandler<List<Book>> rh = new BeanListHandler<>(Book.class);
        try {
            List<Book> books = qr.query(sql, rh);
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
