import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            Database.createConnection();

            var continents = new ContinentDAO();
            continents.create("Europe");
            Database.getConnection();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", 123, europeId);
            countries.create("Ukraine", 124, europeId);
            //Objects.requireNonNull(Database.getConnection()).commit();
            //TODO: print all the countries in Europe
            //Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println("Error");
            Database.rollback();
        }
    }
}
