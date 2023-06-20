import java.sql.Connection;
import java.sql.PreparedStatement;

public class Student {
    String firstName;
    String lastName;
    String Street;
    String City;
    String phoneNum;
    String Gender;
    String Department;
    String Password;
    int ACC_ID=10;
    int ID;
    Student(){};
    Student(int id, String fname, String lname, String city, String street,
            String PhoneNum, String gender, String dep,  String pass) {
            firstName = fname;
            lastName = lname;
            Street = street;
            City = city;
            phoneNum = PhoneNum;
            Gender = gender;
            ID = id;
            Department = dep;
            Password = pass;
    }


    public void editfName ( int id, String newName)
    {
        String query = "update student set FirstName = ? where S_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newName);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student first name updated successfully.");
            } else {
                System.out.println("No rows were affected. Student first name not found or not modified.");
            }
        } catch (Exception e) {
            System.out.println("com.Models.Student.editfName(): " + e.getMessage());
        }
    }
    public void editCity ( int id, String newCity)
    {
        String query = "update student set City = ? where S_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newCity);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student city updated successfully.");
            } else {
                System.out.println("No rows were affected. Student city not found or not modified.");
            }
        } catch (Exception e) {
            System.out.println("com.Models.Student.editCity(): " + e.getMessage());
        }
    }
    public void editPhone ( int id, String newPhone)
    {
        String query = "update student set PhoneNumber = ? where S_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newPhone);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student phone updated successfully.");
            } else {
                System.out.println("No rows were affected. Student phone number not found or not modified.");
            }
        } catch (Exception e) {
            System.out.println("com.Models.Student.editPhone(): " + e.getMessage());
        }
    }
    public void editStreet ( int id, String newStreet)
    {
        String query = "update student set Street = ? where S_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newStreet);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student street updated successfully.");
            } else {
                System.out.println("No rows were affected. Student street not found or not modified.");
            }
        } catch (Exception e) {
            System.out.println("com.Models.Student.editStreet(): " + e.getMessage());
        }
    }
    public void editDep ( int id, String newDep)
    {
        String query = "update student set Department = ? where S_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newDep);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student department updated successfully.");
            } else {
                System.out.println("No rows were affected. Student department not found or not modified.");
            }
        } catch (Exception e) {
            System.out.println("com.Models.Student.editDep(): " + e.getMessage());
        }
    }
    public void editPass ( int id, String newPass) {
        String query = "update account set Password = ? where ACC_ID = (SELECT ACC_ID FROM student where S_ID = ?)";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newPass);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student password updated successfully.");
            } else {
                System.out.println("No rows were affected. Student password not found or not modified.");
            }
        } catch (Exception e) {
            System.out.println("com.Models.Student.editPass(): " + e.getMessage());
        }
    }
    public void editAccID(int id) {
        String query = "UPDATE student SET ACC_ID = (SELECT MAX(ACC_ID) FROM account) WHERE S_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student account ID updated successfully.");
            } else {
                System.out.println("No rows were affected. Student ID not found or account ID not updated.");
            }
        } catch (Exception e) {
            System.out.println("com.Models.Student.editAccID(): " + e.getMessage());
        }
    }
    public void editlName(int id, String newName)
    {
        String query = "update Student set LastName = ? where S_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newName);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student last name updated successfully.");
            } else {
                System.out.println("No rows were affected. Student data not found or not modified.");
            }
        }
        catch (Exception e) {
            System.out.println("com.Models.Student.editlName(): " + e.getMessage());
        }
    }

    public boolean deleteStudent(int id)
    {
        String query = "delete from student where S_ID = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("com.Models.Student.deleteStudent(): " + e.getMessage());
        }
        return true;
    }

    //setters
    public void setFirstName (String firstName){
        this.firstName = firstName;
    }
    public void setLastName (String lastName){
        this.lastName = lastName;
    }
    public void setStreet (String street){
        Street = street;
    }
    public void setCity (String city){
        City = city;
    }
    public void setPhoneNum (String phoneNum){
        this.phoneNum = phoneNum;
    }

    public void setID ( int ID){
        this.ID = ID;
    }
    public void setACC_ID ( int ACC_ID){
        this.ACC_ID = ACC_ID;
    }

    public void setDepartment (String department){
        Department = department;
    }

    public void setGender (String gender){
        Gender = gender;
    }
    public void setPassword (String password){
        Password = password;
    }

    //getters
    public String getFirstName () {
        return firstName;
    }
    public String getLastName () {
        return lastName;
    }
    public String getStreet () {
        return Street;
    }
    public String getCity () {
        return City;
    }
    public String getPhoneNum () {
        return phoneNum;
    }

    public String getGender () {
        return Gender;
    }
    public String getDepartment () {
        return Department;
    }
    public String getPassword () {
        return Password;
    }
    public int getID () {
        return ID;
    }
    public int getACC_ID () {
        return ACC_ID;
    }
}

