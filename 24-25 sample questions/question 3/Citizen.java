import java.util.Scanner;

// Main class containing Citizen and NonEligibleException
public class Citizen {

    private String name;
    private int id;
    private String country;
    private String sex;
    private String maritalStatus;
    private double annualIncome;
    private String economyStatus;
    private int age;

    // Constructor to initialize citizen attributes
    public Citizen(String name, int id, String country, String sex, String maritalStatus, double annualIncome, String economyStatus, int age) throws NonEligibleException {
        this.name = name;
        this.id = id;
        this.country = country;
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.annualIncome = annualIncome;
        this.economyStatus = economyStatus;
        this.age = age;

        // Validate age and country
        if (age < 18 && !country.equalsIgnoreCase("India")) {
            throw new NonEligibleException("Citizen is under 18 and not from India. Not eligible.");
        }
    }

    // Override the toString method to display citizen details
    @Override
    public String toString() {
        return "Citizen Details: \n" +
                "Name: " + name + "\n" +
                "ID: " + id + "\n" +
                "Country: " + country + "\n" +
                "Sex: " + sex + "\n" +
                "Marital Status: " + maritalStatus + "\n" +
                "Annual Income: " + annualIncome + "\n" +
                "Economy Status: " + economyStatus + "\n" +
                "Age: " + age;
    }

    // Main method to test the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Take input from user
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter country: ");
            String country = scanner.nextLine();

            System.out.print("Enter sex (Male/Female): ");
            String sex = scanner.nextLine();

            System.out.print("Enter marital status (Single/Married): ");
            String maritalStatus = scanner.nextLine();

            System.out.print("Enter annual income: ");
            double annualIncome = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter economy status (Poor/Medium/Rich): ");
            String economyStatus = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = scanner.nextInt();

            // Create Citizen object
            Citizen citizen = new Citizen(name, id, country, sex, maritalStatus, annualIncome, economyStatus, age);
            System.out.println("\n" + citizen.toString());

        } catch (NonEligibleException e) {
            // Handle the custom exception and display the message
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

// Custom Exception class within the same file
class NonEligibleException extends Exception {
    // Constructor for the custom exception with a message
    public NonEligibleException(String message) {
        super(message);
    }
}
