import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import static java.lang.Math.sin;
public class CityDAO {

    public void create(int country, String name, boolean capital, double latitude, double longitude)
            throws SQLException {
        Connection connection = Database.getConnection();
        assert connection != null;
        try (PreparedStatement preparedStatement = connection.
                prepareStatement(
                        "insert into cities (country, name, capital, latitude, longitude) values (?,?,?,?,?)"
                )) {
            preparedStatement.setInt(1, country);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, capital ? 1 : 0);
            preparedStatement.setDouble(4, latitude);
            preparedStatement.setDouble(5, longitude);
            preparedStatement.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        name = name.replaceAll("'", " ");
        Connection connection = Database.getConnection();
        assert connection != null;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select id from cities where name ='" + name + "'"
             )) {
            return resultSet.next() ? resultSet.getInt(1) : -1;
        }
    }

    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        assert connection != null;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select name from cities where id ='" + id + "'"
             )) {
            return resultSet.next() ? resultSet.getString(1) : null;
        }
    }

    public void loadFromFile() {
        try {
            Connection connection = Database.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into cities(country, name, capital, latitude, longitude) values (?,?,?,?,?)"
            );

            CountryDAO country = new CountryDAO();

            File file = new File("src/main/resources/concap.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] columns;

            while ( (line = bufferedReader.readLine()) != null ) {
                columns = line.split(",");

                int id;

                if ( (id = country.findByName(columns[0])) != -1 )
                    preparedStatement.setInt(1,id);
                else preparedStatement.setInt(1, -1);

                String name = columns[1].replaceAll("'", " ");
                preparedStatement.setString(2, name);
                preparedStatement.setBoolean(3,true);
                preparedStatement.setDouble(4, Double.parseDouble(columns[2]));
                preparedStatement.setDouble(5, Double.parseDouble(columns[3]));

                CityDAO city = new CityDAO();

                if (city.findByName(columns[1]) < 0)
                    preparedStatement.executeUpdate();
            }

            fileReader.close();
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public double distanceBetween(String city1, String city2) {
        Connection connection = Database.getConnection();
        double distance = -1;
        city1 = city1.replaceAll("'", " ");
        city2 = city2.replaceAll("'", " ");

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select latitude,longitude from cities where name ='" + city1 + "'" + "or name='" +  city2 + "'"
            );

            if (resultSet == null){
                System.out.println("This is not a city!!!");
                return -1;
            }

            resultSet.next();
            double latitude1 = resultSet.getDouble(1);
            double longitude1 = resultSet.getDouble(2);

            resultSet.next();
            double latitude2 = resultSet.getDouble(1);
            double longitude2 = resultSet.getDouble(2);

            distance = calculateDistance(latitude1, longitude1, latitude2, longitude2);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            return distance;
        }
    }

    public double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
        latitude1 = Math.toRadians(latitude1);
        longitude1 = Math.toRadians(longitude1);
        latitude2 = Math.toRadians(latitude2);
        longitude2 = Math.toRadians(longitude2);

        double longitude = longitude2 - longitude1;
        double latitude = latitude2 - latitude1;

        double ans = Math.pow(sin(latitude/2), 2) +
                Math.cos(latitude1) * Math.cos(latitude2) +
                Math.pow(Math.sin(longitude/2), 2);

        ans = 2 * Math.asin(Math.sqrt(ans));

        double radius = 6371;

        ans = ans * radius;

        return ans;
    }
}