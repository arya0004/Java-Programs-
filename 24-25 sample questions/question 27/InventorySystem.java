import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// Class to represent a product
class Product {
    private String name;
    private String productId;
    private double price;

    // Constructor
    public Product(String name, String productId, double price) {
        this.name = name;
        this.productId = productId;
        this.price = price;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product Name: " + name + ", Product ID: " + productId + ", Price: ₹" + price;
    }
}

// Class to manage the inventory
class InventoryManager {
    private ArrayList<Product> products = new ArrayList<>();

    // Method to add a product
    public boolean addProduct(Product product) {
        // Validate unique product ID
        for (Product p : products) {
            if (p.getProductId().equals(product.getProductId())) {
                System.out.println("Error: Duplicate Product ID. Product not added.");
                return false;
            }
        }
        products.add(product);
        System.out.println("Product added successfully.");
        return true;
    }

    // Method to remove a product by product ID
    public boolean removeProduct(String productId) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId().equals(productId)) {
                iterator.remove();
                System.out.println("Product removed successfully.");
                return true;
            }
        }
        System.out.println("Error: Product with ID " + productId + " not found!");
        return false;
    }

    // Method to display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Displaying all products:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    // Method to update the price of a product by product ID
    public boolean updateProductPrice(String productId, double newPrice) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setPrice(newPrice);
                System.out.println("Price updated successfully.");
                return true;
            }
        }
        System.out.println("Error: Product with ID " + productId + " not found!");
        return false;
    }
}

// Main Class to run the program
public class InventorySystem {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Display All Products");
            System.out.println("4. Update Product Price");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    Product newProduct = new Product(name, productId, price);
                    manager.addProduct(newProduct);
                    break;

                case 2:
                    System.out.print("Enter product ID to remove: ");
                    String removeId = scanner.nextLine();
                    manager.removeProduct(removeId);
                    break;

                case 3:
                    manager.displayProducts();
                    break;

                case 4:
                    System.out.print("Enter product ID to update price: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    manager.updateProductPrice(updateId, newPrice);
                    break;

                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
