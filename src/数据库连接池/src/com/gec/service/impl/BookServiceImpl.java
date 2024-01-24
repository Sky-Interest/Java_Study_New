package 数据库连接池.src.com.gec.service.impl;


import 数据库连接池.src.com.gec.dao.impl.BookDaoImpl;
import 数据库连接池.src.com.gec.dao.BookDao;
import 数据库连接池.src.com.gec.entity.Book;
import 数据库连接池.src.com.gec.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao dao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        dao.addBook(book);
    }

    @Override
    public void update(Book book) {
        dao.update(book);
    }

    @Override
    public void delete(String bookNo) {
        dao.delete(bookNo);
    }

    @Override
    public Book getBookByNo(String bookNo) {
        return dao.getBookByNo(bookNo);
    }

    @Override
    public List<Book> findAllBooks() {
        return dao.findAllBooks();
    }
}
