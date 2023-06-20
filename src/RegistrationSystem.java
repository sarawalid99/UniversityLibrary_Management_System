import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationSystem {
    Admin admin;
    Student student;
    Authentication insert = new Authentication();
    int count = 0;

    public static boolean isValidPassword(String password) {
        // Checks if the password is at least 8 characters long and contains at least
        // one digit and one special character
        boolean hasDigit = false;
        boolean hasSpecial = false;
        if (password.length() < 8) {
            return false;
        }
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isWhitespace(c) || Character.isISOControl(c)) {
                return false; // reject whitespace or control characters
            } else if (!Character.isLetter(c)) {
                hasSpecial = true;
            }
        }
        return hasDigit && hasSpecial;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^(012|011|015)\\d{8}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public void adminSignUp(int id,String firstName,String lastName,String city,String street
            ,String phoneNum,String gender, String role,String password) {
            admin = new Admin(firstName, lastName, street, city, phoneNum, gender, id, role, password);
            insert.InsertAdminAccount(admin);
            insert.InsertAdmin(admin);
            admin.editAccID(admin.getID());
    }

    public void studentSignUp(int id,String firstName,String lastName,String city,String street
            ,String phoneNum,String gender, String department,String password) {
            student = new Student(id,firstName, lastName, city,street, phoneNum, gender, department, password);
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setCity(city);
            student.setStreet(street);
            student.setPhoneNum(phoneNum);
            student.setID(id);
            student.setDepartment(department);
            student.setPassword(password);
            student.setGender(gender);
            insert.InsertStudentAccount(student);
            insert.InsertStudent(student);
            student.editAccID(student.getID());
    }
}
