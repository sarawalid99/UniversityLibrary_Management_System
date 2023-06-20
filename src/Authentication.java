import java.sql.Connection;
import java.sql.PreparedStatement;

public class Authentication {
    Connection connection = null;
    PreparedStatement ps = null;


    public void InsertStudent(Student student) {
        String query = "insert into Student (S_ID,FirstName, LastName, City, Street, PhoneNumber, Gender, Department) values(?, ?, ?, ? , ? ,?, ? , ?)";
        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, student.getID());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getCity());
            ps.setString(5, student.getStreet());
            ps.setString(6, student.getPhoneNum());
            ps.setString(7, student.getGender());
            ps.setString(8, student.getDepartment());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("com.Models.user.InsertStudent()" + e.getMessage());
        }
    }

    public void InsertAdmin(Admin admin) {
        String query = "insert into admin (A_ID,FirstName, LastName, City, Street, PhoneNumber, Gender, Role) values(?, ?, ?, ? , ? ,?, ? ,?)";
        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, admin.getID());
            ps.setString(2, admin.getFirstName());
            ps.setString(3, admin.getLastName());
            ps.setString(4, admin.getCity());
            ps.setString(5, admin.getStreet());
            ps.setString(6, admin.getPhoneNum());
            ps.setString(7, admin.getGender());
            ps.setString(8, admin.getRole());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("com.Models.user.InsertAdmin()" + e.getMessage());
        }
    }

    public void InsertStudentAccount(Student student) {
        String query = "insert into Account (Email,Password) values(?, ?)";
        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, student.getID());
            ps.setString(2, student.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("com.Models.user.InsertStudentAccount()" + e.getMessage());
        }
    }

    public void InsertAdminAccount(Admin admin) {
        String query = "insert into Account (Email,Password) values( ?, ?)";
        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, admin.getID());
            ps.setString(2, admin.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("com.Models.user.InsertAdminAccount()" + e.getMessage());
        }
    }
}
