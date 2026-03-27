import java.util.ArrayList;
import java.util.Scanner;

// Abstract Class: Appliance
abstract class Appliance {
    protected String name;
    protected double powerConsumption; // in watts (W)

    // Constructor
    public Appliance(String name, double powerConsumption) {
        this.name = name;
        this.powerConsumption = powerConsumption;
    }

    // Abstract method to calculate daily power consumption
    public abstract double calculateDailyConsumption(); // in kWh

    // Abstract method to calculate monthly power consumption
    public double calculateMonthlyConsumption() {
        return calculateDailyConsumption() * 30; // Assuming 30 days in a month
    }

    // Abstract method to display appliance details
    public abstract void displayDetails();
}

// Subclass: Refrigerator
class Refrigerator extends Appliance {
    private int hoursPerDay; // Average running hours per day

    public Refrigerator(String name, double powerConsumption, int hoursPerDay) {
        super(name, powerConsumption);
        this.hoursPerDay = hoursPerDay;
    }

    @Override
    public double calculateDailyConsumption() {
        return (powerConsumption * hoursPerDay) / 1000; // Convert watts to kWh
    }

    @Override
    public void displayDetails() {
        System.out.println("Appliance: Refrigerator");
        System.out.println("Name: " + name);
        System.out.println("Power Consumption: " + powerConsumption + "W");
        System.out.println("Daily Running Hours: " + hoursPerDay);
        System.out.println("Daily Power Consumption: " + calculateDailyConsumption() + " kWh");
    }
}

// Subclass: Air Conditioner
class AirConditioner extends Appliance {
    private int hoursPerDay;
    private double efficiency; // Energy efficiency ratio

    public AirConditioner(String name, double powerConsumption, int hoursPerDay, double efficiency) {
        super(name, powerConsumption);
        this.hoursPerDay = hoursPerDay;
        this.efficiency = efficiency;
    }

    @Override
    public double calculateDailyConsumption() {
        return (powerConsumption * hoursPerDay * efficiency) / 1000; // Convert watts to kWh
    }

    @Override
    public void displayDetails() {
        System.out.println("Appliance: Air Conditioner");
        System.out.println("Name: " + name);
        System.out.println("Power Consumption: " + powerConsumption + "W");
        System.out.println("Daily Running Hours: " + hoursPerDay);
        System.out.println("Efficiency Ratio: " + efficiency);
        System.out.println("Daily Power Consumption: " + calculateDailyConsumption() + " kWh");
    }
}

// Subclass: Washing Machine
class WashingMachine extends Appliance {
    private int cyclesPerDay;
    private double cycleDuration; // in hours

    public WashingMachine(String name, double powerConsumption, int cyclesPerDay, double cycleDuration) {
        super(name, powerConsumption);
        this.cyclesPerDay = cyclesPerDay;
        this.cycleDuration = cycleDuration;
    }

    @Override
    public double calculateDailyConsumption() {
        return (powerConsumption * cyclesPerDay * cycleDuration) / 1000; // Convert watts to kWh
    }

    @Override
    public void displayDetails() {
        System.out.println("Appliance: Washing Machine");
        System.out.println("Name: " + name);
        System.out.println("Power Consumption: " + powerConsumption + "W");
        System.out.println("Cycles Per Day: " + cyclesPerDay);
        System.out.println("Cycle Duration: " + cycleDuration + " hours");
        System.out.println("Daily Power Consumption: " + calculateDailyConsumption() + " kWh");
    }
}

// Main Class: ApplianceManager
public class ApplianceManager {
    private ArrayList<Appliance> appliances = new ArrayList<>();

    // Method to add appliance
    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
        System.out.println("Appliance added successfully.");
    }

    // Method to display all appliances
    public void displayAllAppliances() {
        if (appliances.isEmpty()) {
            System.out.println("No appliances available.");
        } else {
            for (Appliance appliance : appliances) {
                appliance.displayDetails();
                System.out.println("-----------------------");
            }
        }
    }

    // Method to calculate total monthly power consumption
    public void calculateTotalMonthlyConsumption() {
        double totalConsumption = 0;
        for (Appliance appliance : appliances) {
            totalConsumption += appliance.calculateMonthlyConsumption();
        }
        System.out.println("Total Monthly Power Consumption: " + totalConsumption + " kWh");
    }

    public static void main(String[] args) {
        ApplianceManager manager = new ApplianceManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Appliance");
            System.out.println("2. Display All Appliances");
            System.out.println("3. Calculate Total Monthly Power Consumption");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nSelect Appliance Type:");
                    System.out.println("1. Refrigerator");
                    System.out.println("2. Air Conditioner");
                    System.out.println("3. Washing Machine");
                    System.out.print("Enter choice: ");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Appliance Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Power Consumption (in Watts): ");
                    double power = scanner.nextDouble();

                    switch (type) {
                        case 1: // Refrigerator
                            System.out.print("Enter Daily Running Hours: ");
                            int hours = scanner.nextInt();
                            Appliance fridge = new Refrigerator(name, power, hours);
                            manager.addAppliance(fridge);
                            break;

                        case 2: // Air Conditioner
                            System.out.print("Enter Daily Running Hours: ");
                            int acHours = scanner.nextInt();
                            System.out.print("Enter Efficiency Ratio: ");
                            double efficiency = scanner.nextDouble();
                            Appliance ac = new AirConditioner(name, power, acHours, efficiency);
                            manager.addAppliance(ac);
                            break;

                        case 3: // Washing Machine
                            System.out.print("Enter Cycles Per Day: ");
                            int cycles = scanner.nextInt();
                            System.out.print("Enter Cycle Duration (in hours): ");
                            double duration = scanner.nextDouble();
                            Appliance washingMachine = new WashingMachine(name, power, cycles, duration);
                            manager.addAppliance(washingMachine);
                            break;

                        default:
                            System.out.println("Invalid appliance type.");
                    }
                    break;

                case 2:
                    manager.displayAllAppliances();
                    break;

                case 3:
                    manager.calculateTotalMonthlyConsumption();
                    break;

                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
