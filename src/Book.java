import java.sql.Connection;
import java.sql.PreparedStatement;

public class Book {

    private int ISBN;
    private String title;
    private String Category;
    private String language;
    private String Edition;
    private String publishingYear;
    private String author;
    public Book(){

    }
    public Book(int ISBN,String title,String Category,String language,String Edition,String publishingYear){
        this.ISBN = ISBN;
        this.title = title;
        this.Category = Category;
        this.language = language;
        this.Edition = Edition;
        this.publishingYear = publishingYear;
    }


    //check if the book is already exist in the database by ISBN
    public boolean checkBook(int ISBN){
        String query = "select * from book where ISBN = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ISBN);
            ps.executeQuery();
        } catch (Exception e) {
            System.out.println("com.Models.user.Book is already exist " + e.getMessage());
        }
        return false;
    }
    //add new book to the database table book
    public void addNewBook(int ISBN, String title, String Category, String languge, String Edition, String publisingYear){
        boolean check = false;
        String query = "insert into book values(?,?,?,?,?,?)";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ISBN);
            if (!checkBook(ISBN)) {

                ps.setString(2, title);
                ps.setString(3, Category);
                ps.setString(4, languge);
                ps.setString(5, Edition);
                ps.setString(6, publisingYear);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("com.Models.user.Insertuser()" + e.getMessage());
        }

    }
    //Update book information in the database table book
    //update book title
    public void updateBookTitle(int ISBN,String title){
        String query  = "update book set title = ? where ISBN = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, title);
            ps.setInt(2, ISBN);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("com.Models.user.Insertuser()" + e.getMessage());
        }
    }
    //update book Category
    public void updateBookCategory(int ISBN,String Category){
        String query  = "update book set Category = ? where ISBN = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Category);
            ps.setInt(2, ISBN);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("com.Models.user.Insertuser()" + e.getMessage());
        }
    }
    //update book language
    public void updateBookLanguage(int ISBN,String Languge){
        String query  = "update book set languge = ? where ISBN = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Languge);
            ps.setInt(2, ISBN);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("com.Models.user.Insertuser()" + e.getMessage());
        }
    }
    //update book Edition
    public void updateBookEdition(int ISBN,String Edition){
        String query  = "update book set Edition = ? where ISBN = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Edition);
            ps.setInt(2, ISBN);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("com.Models.user.Insertuser()" + e.getMessage());
        }
    }
    //update book publisingYear
    public void updateBookPublisingYear(int ISBN,String publishingYear){
        String query  = "update book set publisingYear = ? where ISBN = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, publishingYear);
            ps.setInt(2, ISBN);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("com.Models.user.Insertuser()" + e.getMessage());
        }
    }

    public void deleteBook(int ISBN){
        String query = "delete from book where ISBN = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ISBN);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("com.Models.user.Insertuser()" + e.getMessage());
        }
    }


    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String edition) {
        Edition = edition;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }


    public void setAuthor(String author){this.author = author;}
    public String getAuthor(){return author;}
}
