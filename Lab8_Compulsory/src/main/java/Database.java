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
        //init();

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Error Connection");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }

    public static void createConnection() throws SQLException {
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public static void rollback() {
    }

//    public static Connection getConnection() {
//        Connection c = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            c = DriverManager
//                    .getConnection(URL,
//                            USER, PASSWORD);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }
//        System.out.println("Opened database successfully");
//        return c;
//    }
//
//    private static void createConnection() {
//        try {
//           // Connection = TODO
//            assert false;
//            connection.setAutoCommit(false);
//        } catch (SQLException e) {
//            System.err.println();
//        }
//    }
//
//    public static void closeConnection() throws SQLException {
//        assert false;
//        connection.close();
//    }
//
//    public static void rollback() {
//    }
}
