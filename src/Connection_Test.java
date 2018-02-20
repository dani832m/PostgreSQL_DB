import java.sql.Connection;

public class Connection_Test {

    public static void main(String[] args) {

        //Using the method connect from DB_Connector
        Connection conn = DB_Connector.connect();
    }
}