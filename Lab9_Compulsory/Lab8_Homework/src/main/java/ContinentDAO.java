import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            return resultSet.next() ? resultSet.getInt(1) : -1;
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

    public void loadContinents() {
        Connection connection = Database.getConnection();
        List<String> continents = new ArrayList<>();

        continents.add("Asia");
        continents.add("Africa");
        continents.add("Europe");
        continents.add("North America");
        continents.add("South America");
        continents.add("Australia/Oceania");
        continents.add("Antarctica");

        try{
            for (String continent : continents) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "insert into continents (name) values (?)"
                );
                preparedStatement.setString(1, continent);
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}