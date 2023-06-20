import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class loginSystem {

    public static Admin admin = null ;
    public static Student student = null;

    public boolean AisAuthenticated(String email, String password) throws SQLException {
        try {
            String query = "SELECT * FROM Account as a ,admin as s WHERE a.Email = s.A_ID AND a.Email = ? AND a.Password = ?";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            // Execute the query
            ResultSet requiredResult = statement.executeQuery();
            // Check if the account exists in the database
            if (requiredResult.next()) {
                int id = requiredResult.getInt("A_ID");
                String fName  = requiredResult.getString("FirstName");
                String lName  = requiredResult.getString("LastName");
                String city  = requiredResult.getString("City");
                String street  = requiredResult.getString("Street");
                String gender  = requiredResult.getString("Gender");
                String phone  = requiredResult.getString("PhoneNumber");
                String role  = requiredResult.getString("Role");
                admin = new Admin(fName,lName,street,city,phone,gender,id,role,password);
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean SisAuthenticated(String email, String password) throws SQLException {
        try {
            String query = "SELECT * FROM Account as a ,student as s WHERE a.Email = s.S_ID AND a.Email = ? AND a.Password = ?";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            // Execute the query
            ResultSet requiredResult = statement.executeQuery();
            // Check if the account exists in the database
            if (requiredResult.next()) {
                int id = requiredResult.getInt("S_ID");
                String fName  = requiredResult.getString("FirstName");
                String lName  = requiredResult.getString("LastName");
                String city  = requiredResult.getString("City");
                String street  = requiredResult.getString("Street");
                String gender  = requiredResult.getString("Gender");
                String phone  = requiredResult.getString("PhoneNumber");
                String dep  = requiredResult.getString("Department");
                student = new Student(id,fName,lName,city,street,phone,gender,dep,password);
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

