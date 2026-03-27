import java.util.Scanner;

// Custom exception class for invalid currency values
class InvalidCurrencyValueException extends Exception {
    public InvalidCurrencyValueException(String message) {
        super(message);
    }
}

// CurrencyConverter class with conversion methods
class CurrencyConverter {
    private static final double USD_TO_INR_RATE = 83.0;
    private static final double INR_TO_USD_RATE = 0.012;

    // Method to convert USD to INR
    public double convertUSDtoINR(double usd) throws InvalidCurrencyValueException {
        if (usd < 1 || usd > 10000) {
            throw new InvalidCurrencyValueException("Invalid USD value! Must be between $1 and $10,000.");
        }
        return usd * USD_TO_INR_RATE;
    }

    // Method to convert INR to USD
    public double convertINRtoUSD(double inr) throws InvalidCurrencyValueException {
        if (inr < 1 || inr > 10000) {
            throw new InvalidCurrencyValueException("Invalid INR value! Must be between ₹1 and ₹10,000.");
        }
        return inr * INR_TO_USD_RATE;
    }
}

// Main class to run the currency converter program
public class CurrencyConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        boolean continueConversion = true;

        System.out.println("Welcome to the Currency Converter!");
        while (continueConversion) {
            System.out.println("Choose conversion option:");
            System.out.println("1. Convert USD to INR");
            System.out.println("2. Convert INR to USD");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Convert USD to INR
                    System.out.print("Enter amount in USD (between $1 and $10,000): ");
                    double usd = scanner.nextDouble();
                    try {
                        double inr = converter.convertUSDtoINR(usd);
                        System.out.printf("%.2f USD is equivalent to %.2f INR%n", usd, inr);
                    } catch (InvalidCurrencyValueException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2: // Convert INR to USD
                    System.out.print("Enter amount in INR (between ₹1 and ₹10,000): ");
                    double inrAmount = scanner.nextDouble();
                    try {
                        double usdConverted = converter.convertINRtoUSD(inrAmount);
                        System.out.printf("%.2f INR is equivalent to %.2f USD%n", inrAmount, usdConverted);
                    } catch (InvalidCurrencyValueException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3: // Exit
                    continueConversion = false;
                    System.out.println("Exiting the Currency Converter. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
                    break;
            }

            System.out.println(); // Print a newline for better readability
        }

        scanner.close();
    }
}
