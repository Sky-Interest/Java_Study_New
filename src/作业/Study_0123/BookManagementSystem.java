package 作业.Study_0123;

import java.sql.*;
import java.util.Scanner;


public class BookManagementSystem {

    public static void main(String[] args) {
        gui();
    }

    public static void gui() {
        boolean flag = true;
        while (flag) {
            System.out.println("1. 查询所有的图书信息");
            System.out.println("2. 新增图书");
            System.out.println("3. 修改图书信息");
            System.out.println("4. 删除指定的图书");
            System.out.println("5. 退出系统");
            Scanner input = new Scanner(System.in);
            System.out.print("请输入选择：");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    BookManager.selectAllBooks();
                    break;
                case 2:
                    BookManager.addBook();
                    break;
                case 3:
                    BookManager.updateBook();
                    break;
                case 4:
                    BookManager.deleteBook();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
            }
        }
    }


}

class BookManager {
    public static void selectAllBooks() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8808/bookdb", "root", "root123456");
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM t_book_info");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("Book No: " + rs.getString("book_no"));
                System.out.println("Book Name: " + rs.getString("book_name"));
                System.out.println("Book Price: " + rs.getFloat("book_price"));
                System.out.println("Book Author: " + rs.getString("book_author"));
                System.out.println("Book Date: " + rs.getDate("book_date"));
                System.out.println("---------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addBook() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8808/bookdb", "root", "root123456"); PreparedStatement ps = conn.prepareStatement("INSERT INTO t_book_info (book_no, book_name, book_price, book_author, book_date) VALUES (?, ?, ?, ?, ?)")) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter book number: ");
            String bookNo = input.nextLine();
            System.out.print("Enter book name: ");
            String bookName = input.nextLine();
            System.out.print("Enter book price: ");
            float bookPrice = input.nextFloat();
            input.nextLine();  // Consume the newline character
            System.out.print("Enter book author: ");
            String bookAuthor = input.nextLine();
            System.out.print("Enter book date (yyyy-MM-dd): ");
            String bookDate = input.nextLine();
            ps.setString(1, bookNo);
            ps.setString(2, bookName);
            ps.setFloat(3, bookPrice);
            ps.setString(4, bookAuthor);
            ps.setString(5, bookDate);
            ps.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBook() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8808/bookdb", "root", "root123456"); PreparedStatement ps = conn.prepareStatement("UPDATE t_book_info SET book_name = ?, book_price = ?, book_author = ?, book_date = ? WHERE book_no = ?")) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter book number to update: ");
            String bookNo = input.nextLine();
            System.out.print("Enter new book name: ");
            String bookName = input.nextLine();
            System.out.print("Enter new book price: ");
            float bookPrice = input.nextFloat();
            input.nextLine();  // Consume the newline character
            System.out.print("Enter new book author: ");
            String bookAuthor = input.nextLine();
            System.out.print("Enter new book date (yyyy-MM-dd): ");
            String bookDate = input.nextLine();
            ps.setString(1, bookName);
            ps.setFloat(2, bookPrice);
            ps.setString(3, bookAuthor);
            ps.setString(4, bookDate);
            ps.setString(5, bookNo);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book not found with the specified book number!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8808/bookdb", "root", "root123456"); PreparedStatement ps = conn.prepareStatement("DELETE FROM t_book_info WHERE book_no = ?")) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter book number to delete: ");
            String bookNo = input.nextLine();
            ps.setString(1, bookNo);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found with the specified book number!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}