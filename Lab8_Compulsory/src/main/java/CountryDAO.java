import javax.xml.crypto.Data;
import java.sql.*;

public class CountryDAO {


    public void create(String name, int code, int continent) throws SQLException {
        Connection connection = Database.getConnection();
        assert connection != null;
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into countries (name, code, continent) values (?,?,?)"
        ))
        {
            pstmt.setString(1, name);
            pstmt.setInt(2, code);
            pstmt.setInt(3, continent);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        name = name.replaceAll("'", " ");
        Connection connection = Database.getConnection();
        assert connection != null;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select id from countries where name='" + name + "'"
             ))
        {
            return resultSet.next() ? resultSet.getInt(1) : -1;
        }
    }

    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        assert connection != null;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                        "select name from countries where id = '" + id + "'"
                ))
        {
            return resultSet.next() ? resultSet.getString(1) : null;
        }
    }
}
