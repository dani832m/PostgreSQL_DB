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
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(employee);

            byte[] employeeAsByte = baos.toByteArray();

            pst = con.prepareStatement(query1);

            ByteArrayInputStream bais = new ByteArrayInputStream(employeeAsByte);

            pst.setBinaryStream(1, bais, employeeAsByte.length);

            pst.executeUpdate();

            System.out.println("\n--- Query1 executed ---");
        }

        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("\n--- Query1 did not execute ---");
        }

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query2);

            while(rs.next()) {
                byte[] st = (byte[])rs.getObject(2);
                ByteArrayInputStream baip = new ByteArrayInputStream(st);
                ObjectInputStream ois = new ObjectInputStream(baip);
                Employee emp = (Employee)ois.readObject();
                System.out.println("\n---" + emp.toString() + " ---");
            }

            System.out.println("\n--- Retrieve executed ---");
        }

        catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n--- Retrieve did not execute");
        }

    }

}