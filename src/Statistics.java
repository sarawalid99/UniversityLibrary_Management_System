import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class Statistics {

    public static int noOfBooks()
    {
        String query = "SELECT COUNT(*) AS totalBooks FROM book";
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement ps = null;
        int totalBooks = 0;

        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                totalBooks = resultSet.getInt("totalBooks");
            }
        } catch (Exception e) {
            System.out.println("com.Models.user.noOfBooks(): " + e.getMessage());
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

        return totalBooks;
    }

    public static int noOfStudents() {
        String query = "SELECT COUNT(*) AS totalStudents FROM student";
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement ps = null;
        int totalStudents = 0;

        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                totalStudents = resultSet.getInt("totalStudents");
            }
        } catch (Exception e) {
            System.out.println("com.Models.user.noOfStudents(): " + e.getMessage());
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

        return totalStudents;
    }

    public static int noOfAdmins() {
        String query = "SELECT COUNT(*) AS totalAdmins FROM admin";
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement ps = null;
        int totalAdmins = 0;

        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                totalAdmins = resultSet.getInt("totalAdmins");
            }
        } catch (Exception e) {
            System.out.println("com.Models.user.noOfAdmins(): " + e.getMessage());
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

        return totalAdmins;
    }

    public static Map<String, Integer> countStudentsByDepartment() {
        String query = "SELECT Department, COUNT(*) AS totalStudents FROM Student GROUP BY Department";
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement ps = null;
        Map<String, Integer> studentCountMap = new HashMap<>();

        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String department = resultSet.getString("Department");
                int totalStudents = resultSet.getInt("totalStudents");
                studentCountMap.put(department, totalStudents);
            }
        } catch (Exception e) {
            System.out.println("com.Models.user.countStudentsByDepartment(): " + e.getMessage());
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

        return studentCountMap;
    }
    public static Map<String, Integer> countBooksByPublishingYear() {
        String query = "SELECT PublisingYear, COUNT(*) AS BookCount FROM Book GROUP BY PublisingYear Order by PublisingYear";
        Map<String, Integer> bookCountMap = new HashMap<>();
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String publishingYear = resultSet.getString("PublisingYear");
                int bookCount = resultSet.getInt("BookCount");
                bookCountMap.put(publishingYear, bookCount);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
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
            } catch (SQLException e) {
                System.out.println("Error closing database resources: " + e.getMessage());
            }
        }

        return bookCountMap;
    }

}
