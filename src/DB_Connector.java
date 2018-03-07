//Necessary Imports
import java.sql.*;

//Public Class for DB_Connector
public class DB_Connector {

    //Variables
    private static String url = "jdbc:postgresql://localhost:5432/Daniel";
    private static String user = "postgres";
    private static String pass = "1234";
    private static Connection conn = null;

    //Connecting to Database
    public static Connection connect() {

        System.out.println("\n--- Connection to PostgreSQL JDBC ---");

        try {
            conn = DriverManager.getConnection(url, user, pass);
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        if (conn != null) {
            System.out.println("\n-- Connection successful ---");
            System.out.println("\n--- You are logged in as " + user + " ---");
        } else {
            System.out.println("\n-- Connection failed ---");
        }

        return conn;
    }

}
