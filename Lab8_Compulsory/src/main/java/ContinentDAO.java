import javax.xml.crypto.Data;
import java.sql.*;

public class ContinentDAO {
    public void create(String name) throws SQLException {
        Connection connection = Database.getConnection();
        assert connection != null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into continents (name) values (?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        assert connection != null;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select id from continents where name='" + name + "'")) {
            return resultSet.next() ? resultSet.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        assert connection != null;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                        "select name from continents where id='" + id + "'"
                ))
        {
            return resultSet.next() ? resultSet.getString(1) : null;
        }
    }
}