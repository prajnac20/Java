import java.sql.SQLException;

public interface BookInterface {
    public static void insert() throws SQLException{

    }
    public static void delete() throws SQLException{

    }
    public static void display() throws SQLException {

    }
    public static void update()throws SQLException {

    }
}


--------------------------------

import java.sql.SQLException;

public interface UserInterface {
    public static void addUser() throws SQLException{

    }
    public static void deleteUser() throws SQLException{

    }
    public static void displayUser() throws SQLException{

    }
    public static void updateUser() throws SQLException{

    }
}

-----------------------------------

import java.sql.SQLException;

public interface CartInterface {
    public static void addBookToCart() throws SQLException{

    }
    public static void displayBookFromCart() throws SQLException{

    }
    public static void deleteBookCart() throws SQLException{

    }
    public static void checkUserInList() throws SQLException{

    }
}

---------------------------------------------

import java.sql.SQLException;
import java.util.Scanner;

public class Options{

    public static void chooseOption() throws SQLException {
        Scanner ip=new Scanner(System.in);
        while (true) {
            System.out.println("please chose your option to perform operation");
            System.out.println("Main Menu");
            System.out.println("1.Book_operation\n2.User_operation\n3.Cart_operation\n4.Exit");
            int option = ip.nextInt();
            switch (option) {
                case 1:
                    Book_Operations();
                    break;
                case 2:
                    User_Operations();
                    break;
                case 3:
                    Cart_Operations();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choose the correct option");
            }
        }
    }
    public static void Book_Operations() throws SQLException {
        Scanner ip = new Scanner(System.in);
        while (true) {
            System.out.println("please chose your option to perform operation of books");
            System.out.println("1.Inserting a Book\n2.Deleting a Book\n3.Displaying\n4.Updating\n5.Exit");
            int option1 = ip.nextInt();
            switch (option1) {
                case 1:
                    Main.insert();
                    break;
                case 2:
                    Main.delete();
                    break;
                case 3:
                    Main.display();
                    break;
                case 4:
                    Main.update();
                    break;
                case 5:
                    chooseOption();
                    break;
                default:
                    System.out.println("CHOOSE CORRECT OPTION");
            }
        }
    }
    public static void User_Operations() throws SQLException {
        Scanner ip = new Scanner(System.in);
        while (true) {
            System.out.println("please chose your option to perform operation on user");
            System.out.println("1.AddUser\n2.deleteUser \n3.displayUser\n4.UpdateUser\n5.Exit");
            int option = ip.nextInt();
            switch (option) {
                case 1:
                    Main.addUser();
                    break;
                case 2:
                    Main.deleteUser();
                    break;
                case 3:
                    Main.displayUser();
                    break;
                case 4:
                    Main.updateUser();
                    break;
                case 5:
                    chooseOption();
                    break;
                default:
                    System.out.println("choose the correct option");
            }
        }
    }

    public static void Cart_Operations()throws SQLException {
        while (true) {
            Scanner ip=new Scanner(System.in);
            System.out.println("please chose your option to perform operation of cart");
            System.out.println("1.Add book to cart\n2.Deleting a Book\n3.Displaying\n4.Validating user\n5.Exit");
            int option = ip.nextInt();
            switch (option) {
                case 1:
                    Main.addBookToCart();
                    break;
                case 2:
                    Main.deleteBookFromCart();
                    break;
                case 3:
                    Main.displayBookFromCart();
                    break;
                case 4:
                    int count = Main.checkUserInList();
                    if (count >= 1) {
                        Cart_Operations();
                    } else {
                        System.out.println("Enter user id which is present in database");
                    }
                    break;
                case 5:
                    chooseOption();
                    break;
                default:
                    System.out.println("choose the correct option");
            }
        }
    }
}


------------------------------------------


import java.sql.*;
import java.util.Scanner;

public class Main implements UserInterface,BookInterface,CartInterface {
    static Scanner ip = new Scanner(System.in);
    private static Connection con;
    private static Statement stm;

    public static void main(String[] args) throws SQLException {

        try {
            String addr = "jdbc:mysql://localhost:3306/onlinebookstore";
            String username = "root";
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to my sql!!!");
            con = DriverManager.getConnection(addr, username, password);
            stm = con.createStatement();
            Options obj=new Options();
            obj.chooseOption();
        } catch (ClassNotFoundException exe) {
        } catch (SQLException exe) {
        }
    }

    public static void insert() throws SQLException {
        System.out.println("PLEASE ENTER BOOK NAME");
        String bookname = ip.next();
        System.out.println("PLEASE ENTER THE PRICE");
        Float price = ip.nextFloat();
        System.out.println("PLEASE ENTER THE NUMBER COPIES");
        int num_of_copies = ip.nextInt();
        System.out.println("PLEASE ENTER THE AUTHOR NAME");
        String author = ip.next();
        System.out.println("PLEASE ENTER YEAR OF PUBLISH");
        int YOP = ip.nextInt();
        String sql11 = "insert into book values(?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(sql11);
        pstm.setString(1, bookname);
        pstm.setFloat(2, price);
        pstm.setInt(3, num_of_copies);
        pstm.setString(4, author);
        pstm.setInt(5, YOP);
        int status11 = pstm.executeUpdate();
        if (status11 == 0) {
            System.out.println("PLEASE ENTER VALID BOOK NAME");
        } else {
            System.out.println("BOOK DETAILS ARE INSERTED");
        }
    }

    public static void delete() throws SQLException {
        System.out.println("PLEASE ENTER BOOKNAME WHICH YOU WANT TO DELETE");
        String bookname = ip.next();
        String sql12 = "delete from book where bookname='"+ bookname + "'";
        int status12 = stm.executeUpdate(sql12);
        if (status12 == 0) {
            System.out.println("PLEASE ENTER VALID BOOK NAME");
        } else {
            System.out.println("BOOK DETAILS ARE DELETED");
        }
    }

    public static void update() throws SQLException {
        System.out.println("PLEASE ENTER BOOK NAME");
        String bookname = ip.next();
        System.out.println("PLEASE ENTER THE CURRENT AUTHOR NAME ");
        String current_name = ip.next();
        System.out.println("PLEASE ENTER THE AUTHOR NAME WHICH YOU WANT TO UPDATE");
        String pri_name = ip.next();
        String sql13 = "update book set author=? where author=? and bookname='" + bookname + "'";
        PreparedStatement pstm = con.prepareStatement(sql13);
        pstm.setString(1, pri_name);
        pstm.setString(2, current_name);
        int status = pstm.executeUpdate();
        if (status == 0) {
            System.out.println("PLEASE ENTER CORRECT BOOKNAME");
        } else {
            System.out.println("BOOK DETAILS ARE UPDATED SUCCESFULLY");
        }
    }

    public static void display() throws SQLException {
        //System.out.println("PLEASE ENTER THE BOOKNAME");
        //String bookname = ip.next();
        String sql13 = "select * from book ";
        ResultSet res = stm.executeQuery(sql13);
        while (res.next()) {
            System.out.println("Bookname :" + res.getString(1) + "\tPrice :" + res.getFloat(2) + "\tCopies :" + res.getInt(3) + "\tAuthor :" + res.getString(4) + "\tYop:" + res.getInt(5));
        }
    }

    public static void addUser() throws SQLException {
        System.out.println("PLEASE ENTER USER ID");
        int userid = ip.nextInt();
        System.out.println("PLEASE ENTER USER NAME");
        String username = ip.next();
        System.out.println("PLEASE ENTER PASSWORD");
        String password = ip.next();
        System.out.println("ENTER YOUR PLACE");
        String place = ip.next();
        String sql21 = "insert into user values(?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(sql21);
        pstm.setInt(1, userid);
        pstm.setString(2, username);
        pstm.setString(3, password);
        pstm.setString(4, place);
        int status21 = pstm.executeUpdate();
        if (status21 == 0) {
            System.out.println("PLEASE ENTER VALID USER ID");
        } else {
            System.out.println("USER DETAILS ARE INSERTED");
        }
    }

    public static void deleteUser() throws SQLException {
        System.out.println("PLEASE ENTER USER ID TO DELETE THE USER");
        int userid = ip.nextInt();
        String sql22 = "delete from user where userid=" + userid + "";
        int status22 = stm.executeUpdate(sql22);
        if (status22 == 0) {
            System.out.println("PLEASE ENTER VALID USER ID");
        } else {
            System.out.println("USER DETAILS ARE DELETED");
        }
    }

    public static void displayUser() throws SQLException {
        //System.out.println("PLEASE ENTER USER ID");
        //int userid = ip.nextInt();
        String sql23 = "select * from user";
        ResultSet res = stm.executeQuery(sql23);
        while (res.next()) {
            System.out.println("UserID:" + res.getInt(1) + "\tUserName :" + res.getString(2) + "\tPassword :" + res.getString(3) + "\tPlace :" + res.getString(4));
        }
    }

    public static void updateUser() throws SQLException {
        System.out.println("ENTER USER ID TO UPDATE THE USER");
        int userid = ip.nextInt();
        System.out.println("ENTER THE CURRENT USER NAME");
        String current_name = ip.next();
        System.out.println("ENTER THE NAME WHICH YOU WANT TO UPDATE AS USERNAME");
        String pri_name = ip.next();
        String sql24 = "update user set username=? where username=? and userid=" + userid + "";
        PreparedStatement pstm = con.prepareStatement(sql24);
        pstm.setString(1, pri_name);
        pstm.setString(2, current_name);
        int status = pstm.executeUpdate();
        if (status == 0) {
            System.out.println("PLEASE ENTER USERID WHICH IS PRESENT IN THE USER TABLE");
        } else {
            System.out.println("USER DETAILS ARE UPDATED");
        }
    }
    public static void addBookToCart() throws SQLException {
        int num_of_copies = 0;
        System.out.println("PLEASE ENTER USER ID");
        int userid = ip.nextInt();
        System.out.println("PLEASE ENTER BOOK NAME WHICH YOU WANT TO ADD TO THE CART");
        String bookname = ip.next();
        System.out.println("ENTER THE NUMBER COPIES TO ADDED ON TO THE CART");
        int addCopies = ip.nextInt();
        String sql422 = "select num_of_copies from book where bookname='" + bookname + "'";
        ResultSet resnum_of_copies = stm.executeQuery(sql422);
        while (resnum_of_copies.next()) {
            num_of_copies = resnum_of_copies.getInt(1);
        }
        if (num_of_copies>= addCopies) {
            String sql41 = "insert into cart values(" + userid + ",'" + bookname + "'," + addCopies + ")";
            int status = stm.executeUpdate(sql41);
            num_of_copies=num_of_copies-addCopies;
            if (status == 0) {
                System.out.println("PLEASE ENTER DIFFERNET OOK NAME");
            }
            else {
                System.out.println("YOUR CART IS UPDATED");
            }
            if (status > 0) {
                if (num_of_copies > 0) {
                    String decrement_num_of_copies = "update book set num_of_copies=" + num_of_copies + " where bookName='" + bookname + "'";
                    stm.executeUpdate(decrement_num_of_copies);
                } else {
                    String sql42 = "delete from book where bookname='" + bookname + "'";
                    stm.executeUpdate(sql42);
                }
            }
        }
        else {
            System.out.println("BOOK IS NOT PRESENT IN THE TABLE");
        }
    }

    public static void displayBookFromCart() throws SQLException {
        System.out.println("PLEASE ENTER USER ID TO RETRIVE THE DATA");
        int userid=ip.nextInt();
        String sql43="select bookname,num_of_copies from cart where userid="+userid+"";
        ResultSet res=stm.executeQuery(sql43);
        while (res.next()){
            System.out.println(" Num_of_copies: "+res.getInt(2)+"Book Name: "+res.getString(1));
        }
    }

    public static void deleteBookFromCart() throws SQLException {
        int num_of_copies=0;
        int  bookCopies=0;
        System.out.println("PLEASE ENTER USER ID");
        int userid=ip.nextInt();
        System.out.println("PLEASE ENTER BOOK NAME WHICH YOU WISH TO DELETE");
        String bookname=ip.next();
        String sql433="select num_of_copies from cart where userid="+userid+" and bookname='"+bookname+"'";
        ResultSet res=stm.executeQuery(sql433);
        while (res.next()){
            num_of_copies=num_of_copies+res.getInt(1);
        }
        String sql43="delete from cart where userid="+userid+" and bookname='"+bookname+"'";
        int status=stm.executeUpdate(sql43);
        if(status>0){
            System.out.println("Deletion done in cart");
            String checkCopiesInBook="select num_of_copies from book where bookname='"+bookname+"'";
            ResultSet resCheck=stm.executeQuery(checkCopiesInBook);
            while (resCheck.next()){
                bookCopies=resCheck.getInt(1);
            }
            bookCopies=bookCopies+num_of_copies;

            String sql44="update book set num_of_copies="+bookCopies+" where bookName='"+bookname+"'";
            stm.executeUpdate(sql44);
        }
        else {
            System.out.println("Book not present in cart");
        }
    }
    public static int  checkUserInList() throws SQLException {
        int count=0;
        System.out.println("PLEASE ENTER USER ID TO CONFIRM THE USER :");
        int userid=ip.nextInt();
        String sql51="select userName from user where userid="+userid+"";
        ResultSet res=stm.executeQuery(sql51);
        while (res.next()){
            count++;
        }
        if(count>=1){
            System.out.println("THANK YOU USER IS VALIDATED");
        }
        return count;
    }

}
