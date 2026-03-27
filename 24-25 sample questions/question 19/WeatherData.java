import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeatherData {
    public static void main(String[] args) {
        Map<String, Double> cityTemperatures = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;

        while (continueInput) {
            System.out.println("\nWeather Data Management System");
            System.out.println("1. Add/Update Temperature Reading");
            System.out.println("2. Display Average Temperature");
            System.out.println("3. Retrieve Temperature for a City");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter city name: ");
                    String cityName = scanner.nextLine();
                    System.out.print("Enter temperature for " + cityName + ": ");
                    double temperature = scanner.nextDouble();
                    cityTemperatures.put(cityName, temperature);
                    System.out.println("Temperature for " + cityName + " added/updated.");
                    break;

                case 2:
                    if (cityTemperatures.isEmpty()) {
                        System.out.println("No temperature readings available.");
                    } else {
                        double totalTemperature = 0;
                        for (double temp : cityTemperatures.values()) {
                            totalTemperature += temp;
                        }
                        double averageTemperature = totalTemperature / cityTemperatures.size();
                        System.out.printf("Average Temperature: %.2f°C%n", averageTemperature);
                    }
                    break;

                case 3:
                    System.out.print("Enter city name to retrieve temperature: ");
                    String searchCity = scanner.nextLine();
                    Double cityTemp = cityTemperatures.get(searchCity);
                    if (cityTemp != null) {
                        System.out.printf("Latest temperature for %s: %.2f°C%n", searchCity, cityTemp);
                    } else {
                        System.out.println("City not found in the records.");
                    }
                    break;

                case 4:
                    continueInput = false;
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }

        scanner.close();
    }
}
