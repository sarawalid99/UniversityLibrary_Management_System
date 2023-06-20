import java.sql.Connection;
import java.sql.PreparedStatement;

public class Author {
    String name;
    String nationality;
    int ISBN;
    public Author(String name, String nationality, int ISBN)
    {
        this.name = name;
        this.nationality = nationality;
        this.ISBN = ISBN;

    }
    public void addAuthor()
    {
        String query = "insert into author values(?,?,?)";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2, nationality);
            ps.setInt(3, ISBN);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("com.Models.user.addAuthor()" + e.getMessage());
        }
    }
}
