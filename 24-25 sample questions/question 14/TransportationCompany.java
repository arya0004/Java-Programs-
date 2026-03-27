// Abstract class for Vehicle
abstract class Vehicle {
    protected int speed; // speed of the vehicle
    protected int fuel;  // fuel level of the vehicle

    public Vehicle(int speed, int fuel) {
        this.speed = speed;
        this.fuel = fuel;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void start();
    public abstract void stop();
    public abstract double fuelEfficiency(); // fuel efficiency in km/l
}

// Subclass for Car
class Car extends Vehicle {
    public Car(int speed, int fuel) {
        super(speed, fuel);
    }

    @Override
    public void start() {
        System.out.println("Car is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping.");
    }

    @Override
    public double fuelEfficiency() {
        return (double) speed / fuel; // Simplified fuel efficiency calculation
    }
}

// Subclass for Truck
class Truck extends Vehicle {
    public Truck(int speed, int fuel) {
        super(speed, fuel);
    }

    @Override
    public void start() {
        System.out.println("Truck is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Truck is stopping.");
    }

    @Override
    public double fuelEfficiency() {
        return (double) speed / fuel; // Simplified fuel efficiency calculation
    }
}

// Subclass for Bike
class Bike extends Vehicle {
    public Bike(int speed, int fuel) {
        super(speed, fuel);
    }

    @Override
    public void start() {
        System.out.println("Bike is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping.");
    }

    @Override
    public double fuelEfficiency() {
        return (double) speed / fuel; // Simplified fuel efficiency calculation
    }
}

// Abstract class for Employee
abstract class Employee {
    protected String name;
    protected int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Abstract methods to be implemented by subclasses
    public abstract double calculateSalary();
    public abstract String getRole();
}

// Subclass for Driver
class Driver extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Driver(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getRole() {
        return "Driver";
    }
}

// Subclass for Mechanic
class Mechanic extends Employee {
    private double monthlySalary;

    public Mechanic(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public String getRole() {
        return "Mechanic";
    }
}

// Main class to test the program
public class TransportationCompany {
    public static void main(String[] args) {
        // Create vehicles
        Vehicle car = new Car(120, 10);
        Vehicle truck = new Truck(80, 20);
        Vehicle bike = new Bike(60, 5);

        // Start and stop vehicles
        car.start();
        System.out.println("Car fuel efficiency: " + car.fuelEfficiency() + " km/l");
        car.stop();

        truck.start();
        System.out.println("Truck fuel efficiency: " + truck.fuelEfficiency() + " km/l");
        truck.stop();

        bike.start();
        System.out.println("Bike fuel efficiency: " + bike.fuelEfficiency() + " km/l");
        bike.stop();

        // Create employees
        Employee driver = new Driver("Alice", 1, 15, 160);
        Employee mechanic = new Mechanic("Bob", 2, 2500);

        // Display employee information and salaries
        System.out.println(driver.getRole() + " " + driver.name + " earns: $" + driver.calculateSalary());
        System.out.println(mechanic.getRole() + " " + mechanic.name + " earns: $" + mechanic.calculateSalary());
    }
}
