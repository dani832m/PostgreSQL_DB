//Necessary Imports
import java.sql.Connection;

//Public Class for Testing
public class Connection_Test {

    public static void main(String[] args) {

        //Using the Method connect from DB_Connector
        //Connection conn = DB_Connector.connect();

        //Test DB_Statements - insertData and retrieveData Methods
        DB_Statements statements = new DB_Statements();
        statements.insertData();
        statements.retrieveData();

    }

}