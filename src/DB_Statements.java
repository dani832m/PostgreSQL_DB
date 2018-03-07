//Necessary Imports
import java.sql.*;
import java.io.*;

//Public Class for DB_Statements
public class DB_Statements {

    //Declare a Statement
    private static Statement stmt = null;

    //Declare and create a Connection
    private static Connection con = DB_Connector.connect();

    //Declare a Result Set
    private static ResultSet rs = null;

    //Declare a PreparedStatement
    private static PreparedStatement pst = null;

    //Method for inserting data to DB
    public void insertData() {

        //Creating new Instance of Class Employee
        Employee employee = new Employee(41,"Bob",1200);

        //Declare and initialize the two Strings
        String query1 = "insert into employee (emp) values(?)";
        String query2 = "select * from employee";

        try {
            //Take an Employee Object and convert it to a Byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(employee);

            byte[] employeeAsByte = baos.toByteArray();

            //Create a PreparedStatement
            pst = con.prepareStatement(query1);

            //Place the converted object into the input stream
            ByteArrayInputStream bais = new ByteArrayInputStream(employeeAsByte);
            pst.setBinaryStream(1, bais, employeeAsByte.length);

            //Execute the query
            pst.executeUpdate();
            System.out.println("\n--- Query1 executed ---");
        }

        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("\n--- Query1 did not execute ---");
        }

    }

    public void retrieveData() {

        String query = "select * from employee";

        try {
            //Create a Statement
            stmt = con.createStatement();

            //Execute the ResultSet
            rs = stmt.executeQuery(query);

            //Return all rows from the table
            while(rs.next()) {
                byte[] st = (byte[])rs.getObject(2);
                ByteArrayInputStream baip = new ByteArrayInputStream(st);
                ObjectInputStream ois = new ObjectInputStream(baip);
                Employee emp = (Employee) ois.readObject();
                System.out.println("\n" + emp.toString());
            }

            System.out.println("\n--- Retrieve executed ---");
        }

        //Handle all possible Exceptions
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n--- Retrieve did not execute ---");
        }

    }

}