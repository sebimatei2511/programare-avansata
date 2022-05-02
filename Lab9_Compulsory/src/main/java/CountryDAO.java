import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
            return resultSet.next() ? resultSet.getString(1) : null ;
        }
    }

    public void loadFromFile() {
        try {
            Connection connection = Database.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into countries(name, code, continent) values (?,?,?)"
            );

            ContinentDAO continent = new ContinentDAO();

            File file = new File("src/main/resources/concap.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] columns;

            while ( (line = bufferedReader.readLine()) != null ) {
                columns = line.split(",");
                String name = columns[0].replaceAll("'", " ");
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2,0);

                int id;

                if ( (id = continent.findByName(columns[5])) != -1 )
                    preparedStatement.setInt(3,id);
                else preparedStatement.setInt(3, 1);

                CountryDAO country = new CountryDAO();

                if (country.findByName(columns[0]) < 0 )
                    preparedStatement.executeUpdate();
            }

            fileReader.close();
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
