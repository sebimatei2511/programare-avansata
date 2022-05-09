import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/laboratory_8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "database";
    private static Connection connection;
    private static Database instance = null;

    private Database() {
    }

    public static Database getInstance() throws SQLException {
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void createConnection() throws SQLException {
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public static void rollback() {
    }

}
