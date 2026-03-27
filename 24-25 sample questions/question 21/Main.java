// Abstract Class
abstract class Appliance {
    private String name;
    private int powerConsumption; // in watts

    // Constructor
    public Appliance(String name, int powerConsumption) {
        this.name = name;
        this.powerConsumption = powerConsumption;
    }

    // Abstract method to turn on the appliance
    public abstract void turnOn();

    // Abstract method to perform specific functions
    public abstract void performFunction();

    // Concrete method to show power consumption
    public void showPowerConsumption() {
        System.out.println("Power Consumption of " + getName() + ": " + powerConsumption + " watts");
    }

    // Concrete method to adjust power consumption
    public void adjustPowerConsumption(int consumptionChange) {
        powerConsumption += consumptionChange;
        // Ensure power consumption is within the range [0, 5000]
        if (powerConsumption > 5000) {
            powerConsumption = 5000;
            System.out.println("Power consumption adjusted to maximum limit of 5000 watts.");
        } else if (powerConsumption < 0) {
            powerConsumption = 0;
            System.out.println("Power consumption cannot go below 0 watts.");
        }
    }

    // Protected method to get the name
    protected String getName() {
        return name; // Accessing the private member from the superclass
    }
}

// Concrete Class for Washing Machine
class WashingMachine extends Appliance {
    public WashingMachine(String name, int powerConsumption) {
        super(name, powerConsumption);
    }

    @Override
    public void turnOn() {
        System.out.println(getName() + " is now ON.");
    }

    @Override
    public void performFunction() {
        System.out.println(getName() + " is starting a wash cycle (consuming 1500 watts).");
        adjustPowerConsumption(1500); // Adjusting power consumption by the wash cycle
    }
}

// Concrete Class for Air Conditioner
class AirConditioner extends Appliance {
    public AirConditioner(String name, int powerConsumption) {
        super(name, powerConsumption);
    }

    @Override
    public void turnOn() {
        System.out.println(getName() + " is now ON.");
    }

    @Override
    public void performFunction() {
        System.out.println(getName() + " is cooling the room (consuming 1500 watts).");
        adjustPowerConsumption(1500); // Adjusting power consumption by cooling
    }
}

// Test Program
public class Main {
    public static void main(String[] args) {
        Appliance washingMachine = new WashingMachine("LG Washing Machine", 2000);
        Appliance airConditioner = new AirConditioner("Samsung Air Conditioner", 3000);

        // Operating Washing Machine
        washingMachine.turnOn();
        washingMachine.performFunction();
        washingMachine.showPowerConsumption();

        // Operating Air Conditioner
        airConditioner.turnOn();
        airConditioner.performFunction();
        airConditioner.showPowerConsumption();

        // Adjusting power consumption
        washingMachine.adjustPowerConsumption(-800);
        airConditioner.adjustPowerConsumption(2500);

        // Displaying updated power consumption
        washingMachine.showPowerConsumption();
        airConditioner.showPowerConsumption();
    }
}
