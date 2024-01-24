package 数据库连接池.src.com.gec.dao;



import 数据库连接池.src.com.gec.entity.Book;

import java.util.List;

public interface BookDao {
    /**
     * 添加书籍
     * @param book
     */
    void addBook(Book book);

    void update(Book book);

    void delete(String bookNo);

    Book getBookByNo(String bookNo);

    List<Book> findAllBooks();
}
