import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Display {
    public ArrayList<Book> viewAllBooks() throws SQLException {
        String query = "SELECT * FROM book as b, author as a WHERE b.ISBN = a.ISBN";
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Book> bookList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ISBN");
                String title = resultSet.getString("Title");
                String category = resultSet.getString("Category");
                String language = resultSet.getString("Languge");
                String edition = resultSet.getString("Edition");
                String publishingYear = resultSet.getString("PublisingYear");
                String author = resultSet.getString("Name");

                Book book = new Book(id,title, category,language, edition, publishingYear);
                book.setAuthor(author);

                bookList.add(book);
            }
        } catch (Exception e) {
            System.out.println("com.Models.user.viewAllBooks(): " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error closing database resources: " + e.getMessage());
            }
        }

       return bookList;
    }
    public ArrayList<Book> searchByTitle(String title) throws SQLException {
        String query = "SELECT * FROM book as b, author as a WHERE b.ISBN = a.ISBN and title = ?";
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Book> bookList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, title);  // Set the title parameter in the query
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ISBN");
                String category = resultSet.getString("Category");
                String language = resultSet.getString("Languge");
                String edition = resultSet.getString("Edition");
                String publishingYear = resultSet.getString("PublisingYear");
                String author = resultSet.getString("Name");

                Book book = new Book(id,title, category,language, edition, publishingYear);
                book.setAuthor(author);

                bookList.add(book);
            }
        } catch (Exception e) {
            System.out.println("com.Models.user.searchByTitle(): " + e.getMessage());
        } finally {
            try {
                if(resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error closing database resources: " + e.getMessage());
            }
        }
        return bookList;
    }
    public static ArrayList<Book> searchByISBN(String ISBN) throws SQLException {
        String query = "SELECT * FROM book as b, author as a WHERE b.ISBN = a.ISBN and b.isbn = ?";
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Book> bookList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(ISBN));  // Set the title parameter in the query
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("Title");
                String category = resultSet.getString("Category");
                String language = resultSet.getString("Languge");
                String edition = resultSet.getString("Edition");
                String publishingYear = resultSet.getString("PublisingYear");
                String author = resultSet.getString("Name");

                Book book = new Book(Integer.parseInt(ISBN),title, category,language, edition, publishingYear);
                book.setAuthor(author);

                bookList.add(book);
            }
        } catch (Exception e) {
            System.out.println("com.Models.user.searchByTitle(): " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error closing database resources: " + e.getMessage());
            }
        }

        return bookList;
    }
    public ArrayList<Book> searchByCategory(String category) throws SQLException {
        String query = "SELECT * FROM book as b, author as a WHERE b.ISBN = a.ISBN and category = ?";
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Book> bookList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, category);  // Set the title parameter in the query
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int ISBN = resultSet.getInt("ISBN");
                String title = resultSet.getString("Title");
                String language = resultSet.getString("Languge");
                String edition = resultSet.getString("Edition");
                String publishingYear = resultSet.getString("PublisingYear");
                String author = resultSet.getString("Name");

                Book book = new Book(ISBN,title, category,language, edition, publishingYear);
                book.setAuthor(author);

                bookList.add(book);
            }
        } catch (Exception e) {
            System.out.println("com.Models.user.searchByTitle(): " + e.getMessage());
        } finally {
            try {
                if(resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error closing database resources: " + e.getMessage());
            }
        }

//        for (String bookInfo : bookList) {
//            System.out.println(bookInfo);
//        }
        return bookList;
    }
    public ArrayList<Book> searchByAuthor(String author) throws SQLException {
        String query = "SELECT * FROM book as b, author as a WHERE b.ISBN = a.ISBN and name = ?";
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Book> bookList = new ArrayList<>();


        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, author);  // Set the title parameter in the query
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int ISBN = resultSet.getInt("ISBN");
                String title = resultSet.getString("Title");
                String category = resultSet.getString("Category");
                String language = resultSet.getString("Languge");
                String edition = resultSet.getString("Edition");
                String publishingYear = resultSet.getString("PublisingYear");

                Book book = new Book(ISBN,title, category,language, edition, publishingYear);
                book.setAuthor(author);

                bookList.add(book);
            }
        } catch (Exception e) {
            System.out.println("com.Models.user.searchByTitle(): " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error closing database resources: " + e.getMessage());
            }
        }

        return bookList;
    }
    public ArrayList<Book> searchByYear(String year) throws SQLException {
        String query = "SELECT * FROM book as b, author as a WHERE b.ISBN = a.ISBN and publisingYear = ?";
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ArrayList<Book> bookList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, year);  // Set the title parameter in the query
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int ISBN = resultSet.getInt("ISBN");
                String title = resultSet.getString("Title");
                String category = resultSet.getString("Category");
                String language = resultSet.getString("Languge");
                String edition = resultSet.getString("Edition");
                String author = resultSet.getString("name");

                Book book = new Book(ISBN,title, category,language, edition, year);
                book.setAuthor(author);

                bookList.add(book);
            }
        } catch (Exception e) {
            System.out.println("com.Models.user.searchByTitle(): " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error closing database resources: " + e.getMessage());
            }
        }

        return bookList;
    }

}
