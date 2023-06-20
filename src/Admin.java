import java.sql.Connection;
import java.sql.PreparedStatement;

public class Admin {
    String firstName;
    String lastName;
    String Street;
    String City;
    String phoneNum;
    String Gender;
    String Role;
    int ID;
    int ACC_ID=11;
    String Password;
    Admin(){};
    Admin(String fname,String lname,String street,String city,String PhoneNum,String gender
            ,int id,String role,String pass){
        firstName = fname;
        lastName = lname;
        Street = street;
        City = city;
        phoneNum = PhoneNum;
        Gender = gender;
        ID = id;
        Role = role;
        Password = pass;
    }
    public void editfName(int id, String newName)
    {
        String query = "update Admin set FirstName = ? where A_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newName);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Admin first name updated successfully.");
            } else {
                System.out.println("No rows were affected. Admin first name not found or not modified.");
            }
        }
        catch (Exception e) {
            System.out.println("com.Models.Admin.editfName(): " + e.getMessage());
        }
    }
    public void editlName(int id, String newName)
    {
        String query = "update Admin set LastName = ? where A_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newName);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Admin last name updated successfully.");
            } else {
                System.out.println("No rows were affected. Admin data not found or not modified.");
            }
        }
        catch (Exception e) {
            System.out.println("com.Models.Admin.editlName(): " + e.getMessage());
        }
    }
    public void editCity(int id, String newCity)
    {
        String query = "update Admin set City = ? where A_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newCity);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Admin city updated successfully.");
            } else {
                System.out.println("No rows were affected. Admin data not found or not modified.");
            }
        }
        catch (Exception e) {
            System.out.println("com.Models.Admin.editCity(): " + e.getMessage());
        }
    }
    public void editPhone(int id, String newPhone)
    {
        String query = "update Admin set PhoneNumber = ? where A_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newPhone);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Admin phone updated successfully.");
            } else {
                System.out.println("No rows were affected. Admin data not found or not modified.");
            }
        }
        catch (Exception e) {
            System.out.println("com.Models.Admin.editPhone(): " + e.getMessage());
        }
    }
    public void editStreet(int id, String newStreet)
    {
        String query = "update Admin set Street = ? where A_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newStreet);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Admin street updated successfully.");
            } else {
                System.out.println("No rows were affected. Admin data not found or not modified.");
            }
        }
        catch (Exception e) {
            System.out.println("com.Models.Admin.editStreet(): " + e.getMessage());
        }
    }
    public void editRole(int id, String newRole)
    {
        String query = "update Admin set Role = ? where A_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newRole);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Admin role updated successfully.");
            } else {
                System.out.println("No rows were affected. Admin role not found or not modified.");
            }
        }
        catch (Exception e) {
            System.out.println("com.Models.Admin.editRole(): " + e.getMessage());
        }
    }
    public void editPass ( int id, String newPass)
    {
        String query = "update account set Password = ? where ACC_ID = (SELECT ACC_ID FROM Admin where A_ID = ?)";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newPass);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Admin password updated successfully.");
            } else {
                System.out.println("No rows were affected. Admin password not found or not modified.");
            }
        } catch (Exception e) {
            System.out.println("com.Models.Admin.editPass(): " + e.getMessage());
        }
    }
    public void editAccID(int id) {
        String query = "UPDATE Admin SET ACC_ID = (SELECT MAX(ACC_ID) FROM account) WHERE A_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Admin account ID updated successfully.");
            } else {
                System.out.println("No rows were affected. Admin ID not found or account ID not updated.");
            }
        } catch (Exception e) {
            System.out.println("com.Models.Admin.editAccID(): " + e.getMessage());
        }
    }


    //getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getStreet() {
        return Street;
    }

    public String getCity() {
        return City;
    }
    public String getPhoneNum() {
        return phoneNum;
    }

    public int getID() {
        return ID;
    }
    public int getACC_ID() {
        return ACC_ID;
    }

    public String getGender() {
        return Gender;
    }
    public String getRole() {
        return Role;
    }
    public String getPassword() {
        return Password;
    }

}
