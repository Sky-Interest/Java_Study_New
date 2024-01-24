package 数据库连接池.src.com.gec.entity;

import java.util.Date;

public class Book {
    private String bookNo;
    private String bookName;
    private double bookPrice;
    private String bookAuthor;
    private Date bookDate;

    @Override
    public String toString() {
        return "Book{" +
                "bookNo='" + bookNo + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookDate=" + bookDate +
                '}';
    }

    public Book() {
    }

    public Book(String bookNo, String bookName, double bookPrice, String bookAuthor, Date bookDate) {
        this.bookNo = bookNo;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
        this.bookDate = bookDate;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }
}
