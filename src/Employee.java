//Necessary Imports
import java.io.Serializable;

//Public Class for Employee
public class Employee implements Serializable {

    //Instance Variables
    private int id;
    private String name;
    private double salary;

    //Constructor with 3 parameters
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

}