package 数据库连接池.src.com.gec.ui;

import 数据库连接池.src.com.gec.entity.Book;
import 数据库连接池.src.com.gec.service.BookService;
import 数据库连接池.src.com.gec.service.impl.BookServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Demo {

    //全局的控制台输入对象
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("欢迎进入粤嵌书城...");
        BookService service = new BookServiceImpl();
        while(true){
            System.out.println("\t1查询所有的图书信息");
            System.out.println("\t2新增图书");
            System.out.println("\t3修改图书信息");
            System.out.println("\t4删除指定的图书");
            System.out.println("\t5退出系统");

            System.out.println("请输入选择");
            int num = sc.nextInt();
            switch (num){
                case 1:
                    System.out.println("--查询所有的图书信息--");
                    findAllBooks(service);
                    break;
                case 2:
                    System.out.println("--新增图书--");
                    addBook(service);
                    break;
                case 3:
                    System.out.println("--修改图书信息--");
                    updateBook(service);
                    break;
                case 4:
                    System.out.println("--删除指定的图书--");
                    deleteBook(service);
                    break;
                case 5:
                    System.out.println("--退出系统--");
                    return;
            }
        }
    }

    private static void findAllBooks(BookService service) {
        //service.findAllBooks().forEach(book -> System.out.println("\t"+book+"\t"));
        List<Book> allBooks = service.findAllBooks();

        System.out.println("\t编号\t书名\t价格\t作者\t日期\t");//String.format
        for (Book book : allBooks) {
            System.out.print("\t" +book.getBookNo());
            System.out.print("\t" +book.getBookName());
            System.out.print("\t" +book.getBookPrice());
            System.out.print("\t" +book.getBookAuthor());
            System.out.print("\t" +book.getBookDate());
            System.out.println();
        }
    }


    private static void addBook(BookService service) {
        Book book = null;
        book = inputInfo(book);

        service.addBook(book);
    }

    private static Book inputInfo(Book book) {
        System.out.println("请输入编号");
        String bookNo = sc.next();
        System.out.println("请输入书名");
        String bookName = sc.next();
        System.out.println("请输入价格");
        double bookPrice = sc.nextDouble();
        System.out.println("请输入作者");
        String bookAuthor = sc.next();
        System.out.println("请输入时间");
        String bookDate = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //创建书籍对象
        try {
            book = new Book(bookNo,bookName,bookPrice,bookAuthor,sdf.parse(bookDate));
            //存储
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return book;
    }

    private static void updateBook(BookService service) {
        Book book = null;
        book = inputInfo(book);
        service.update(book);
    }

    private static void deleteBook(BookService service) {
        System.out.println("请输入编号");
        String bookNo = sc.next();
        System.out.println("你确定要删除吗?输入是|否:");
        String isDelete = sc.next();
        if(isDelete.equals("是")){
            service.delete(bookNo);
        }
    }


}
