// Base Class: InventoryItem
class InventoryItem {
    private String name;
    private int itemID;
    private static int idCounter = 1; // Static counter for unique itemID

    // Constructor
    public InventoryItem(String name) {
        this.name = name;
        this.itemID = idCounter++; // Assign and increment the ID counter
    }

    // Method to display basic information
    public void displayInfo() {
        System.out.println("Item Name: " + name);
        System.out.println("Item ID: " + itemID);
    }
}

// Derived Class: Electronics
class Electronics extends InventoryItem {
    private int warrantyPeriod; // Warranty period in months

    // Constructor
    public Electronics(String name, int warrantyPeriod) {
        super(name); // Call the constructor of InventoryItem
        this.warrantyPeriod = warrantyPeriod;
    }

    // Overriding displayInfo() to include warranty period
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the base class method
        System.out.println("Warranty Period: " + warrantyPeriod + " months");
    }
}

// Derived Class: Clothing
class Clothing extends InventoryItem {
    private String size; // Size of the clothing item

    // Constructor
    public Clothing(String name, String size) {
        super(name); // Call the constructor of InventoryItem
        this.size = size;
    }

    // Overriding displayInfo() to include size
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the base class method
        System.out.println("Size: " + size);
    }
}

// Test Program
public class InventoryManagement {
    public static void main(String[] args) {
        // Create instances of Electronics and Clothing
        Electronics laptop = new Electronics("Laptop", 24);
        Clothing shirt = new Clothing("T-Shirt", "M");

        // Display information about the items
        System.out.println("Electronics Item Info:");
        laptop.displayInfo();

        System.out.println("\nClothing Item Info:");
        shirt.displayInfo();
    }
}
