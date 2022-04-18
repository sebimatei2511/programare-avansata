import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/laboratory_8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "database";
    private static final Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection(URL,
                            USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }

    private static void createConnection() {
        try {
           // Connection = TODO
            assert false;
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println();
        }
    }

    public static void closeConnection() throws SQLException {
        assert false;
        connection.close();
    }

    public static void rollback() {
    }
}
