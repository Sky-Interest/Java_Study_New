package 数据库连接池.src.com.gec.dao.impl;



import 数据库连接池.src.com.gec.dao.BookDao;
import 数据库连接池.src.com.gec.entity.Book;
import 数据库连接池.src.com.gec.utils.JDBCUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public void addBook(Book book) {
        //准备sql
        String sql = "insert into t_book(book_no,book_name,book_price,book_author,book_date)values(?,?,?,?,?)";
        //调用方法传参
        JDBCUtil.update(sql,book.getBookNo(),book.getBookName(),book.getBookPrice(),book.getBookAuthor(),book.getBookDate());

    }

    @Override
    public void update(Book book) {
        //准备sql
        String sql = "update t_book set book_name=?,book_price=?,book_author=?,book_date=? where book_no=?";
        //调用方法传参
        JDBCUtil.update(sql,book.getBookName(),book.getBookPrice(),book.getBookAuthor(),book.getBookDate(),book.getBookNo());

    }

    @Override
    public void delete(String bookNo) {
        //准备sql
        String sql = "delete from  t_book where book_no=?";
        //调用方法传参
        JDBCUtil.update(sql,bookNo);

    }

    @Override
    public Book getBookByNo(String bookNo) {
        String sql = "select * from t_book where book_no=?";
        ResultSet rs = null;
        Book book = null;
        try {
            rs = JDBCUtil.query(sql,bookNo);
            while (rs.next()){
                book = new Book(rs.getString("book_no"),rs.getString("book_name"),
                        rs.getDouble("book_price"),rs.getString("book_author"),
                        rs.getDate("book_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,rs);
        }
        return book;
    }

    @Override
    public List<Book> findAllBooks() {
        String sql = "select * from t_book";
        ResultSet rs = null;
        List<Book> books= new ArrayList<>();
        try {
            rs = JDBCUtil.query(sql);
            while (rs.next()){
                Book book = new Book(rs.getString("book_no"),rs.getString("book_name"),
                        rs.getDouble("book_price"),rs.getString("book_author"),
                        rs.getDate("book_date"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,rs);
        }
        return books;
    }
}
