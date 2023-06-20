import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library";

//   private static final String URL = "jdbc:mysql://localhost:3306/unilibaray";
    private static final String UserName = "root";
    private static final String password = "123456";

//    private static final String password = "1234";
    private static Connection connection = null;
    public static Connection getConnection()
    {
        try {
            connection = DriverManager.getConnection(URL, UserName, password);
            if(connection == null)
            {
                System.out.println("the connection is null");
            }
            else{
                System.out.println("the connection is not null");
            }
        }
        catch (Exception e)
        {
            System.out.println("com.Models.DBConnection.getConnection()" + e.getMessage());
        }
        return connection;
    }
}
