// Base class Employee
class Employee {
    protected String name;
    protected int employeeID;
    protected double hourlyRate;

    // Constructor for Employee
    public Employee(String name, int employeeID, double hourlyRate) {
        this.name = name;
        this.employeeID = employeeID;
        this.hourlyRate = hourlyRate;
    }

    // Method to calculate salary (implemented in subclasses)
    public double calculateSalary() {
        return 0;
    }

    // Display employee details
    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
        System.out.println("Hourly Rate: " + hourlyRate);
    }
}

// Full-time Employee subclass
class FullTimeEmployee extends Employee {
    private double salary;
    private double benefits;

    // Constructor for FullTimeEmployee using super to call Employee constructor
    public FullTimeEmployee(String name, int employeeID, double hourlyRate, double salary, double benefits) {
        super(name, employeeID, hourlyRate); // Calling the constructor of Employee class
        this.salary = salary;
        this.benefits = benefits;
    }

    // Method to calculate monthly salary for full-time employee (salary + benefits)
    @Override
    public double calculateSalary() {
        return salary + benefits;
    }

    // Display full-time employee details
    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo(); // Call base class method to display common details
        System.out.println("Salary: " + salary);
        System.out.println("Benefits: " + benefits);
    }
}

// Part-time Employee subclass
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double overtimeRate;

    // Constructor for PartTimeEmployee using super to call Employee constructor
    public PartTimeEmployee(String name, int employeeID, double hourlyRate, int hoursWorked, double overtimeRate) {
        super(name, employeeID, hourlyRate); // Calling the constructor of Employee class
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
    }

    // Method to calculate monthly salary for part-time employee (hours worked * hourly rate + overtime)
    @Override
    public double calculateSalary() {
        double regularPay = hoursWorked * hourlyRate;
        double overtimePay = (hoursWorked > 160) ? (hoursWorked - 160) * overtimeRate : 0;
        return regularPay + overtimePay;
    }

    // Display part-time employee details
    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo(); // Call base class method to display common details
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Overtime Rate: " + overtimeRate);
    }
}

// Main class to test the Employee system
public class CompanyManagement {
    public static void main(String[] args) {
        // Creating a full-time employee
        FullTimeEmployee fullTimeEmp = new FullTimeEmployee("Alice", 101, 50.0, 4000.0, 500.0);
        System.out.println("\nFull-Time Employee Details:");
        fullTimeEmp.displayEmployeeInfo();
        System.out.println("Monthly Salary: $" + fullTimeEmp.calculateSalary());

        // Creating a part-time employee
        PartTimeEmployee partTimeEmp = new PartTimeEmployee("Bob", 102, 20.0, 170, 25.0);
        System.out.println("\nPart-Time Employee Details:");
        partTimeEmp.displayEmployeeInfo();
        System.out.println("Monthly Salary: $" + partTimeEmp.calculateSalary());
    }
}
