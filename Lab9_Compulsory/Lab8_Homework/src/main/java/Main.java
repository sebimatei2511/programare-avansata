import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        try {
            Database.createConnection();

            var continents = new ContinentDAO();
            continents.loadContinents();

            var countries = new CountryDAO();
            countries.loadFromFile();

            var cities = new CityDAO();
            cities.loadFromFile();

            System.out.println("The distance between Paris and Moscow is: " +
                    cities.distanceBetween("Paris", "Moscow") + " km");

            Map map = new Map();
            map.setVisible(true);


        } catch (SQLException e) {
            System.err.println("Error");
            Database.rollback();
        }
    }
}
