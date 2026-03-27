import java.util.Scanner;

public class WeatherDataAnalyzer {
    // Define constants for cities and months
    private static final int NUM_CITIES = 2;
    private static final int NUM_MONTHS = 2;
    private static final int NUM_PARAMETERS = 3; // 0: temperature, 1: humidity, 2: rainfall

    // 3D array to store weather data [city][month][parameter]
    private double[][][] weatherData = new double[NUM_CITIES][NUM_MONTHS][NUM_PARAMETERS];

    // Method to initialize the weather data
    public void initializeData() {
        Scanner scanner = new Scanner(System.in);
        for (int city = 0; city < NUM_CITIES; city++) {
            System.out.println("Enter data for City " + (city + 1) + ":");
            for (int month = 0; month < NUM_MONTHS; month++) {
                System.out.println(" Month " + (month + 1) + ":");
                System.out.print(" Average Temperature: ");
                weatherData[city][month][0] = scanner.nextDouble();
                System.out.print(" Average Humidity: ");
                weatherData[city][month][1] = scanner.nextDouble();
                System.out.print(" Total Rainfall: ");
                weatherData[city][month][2] = scanner.nextDouble();
            }
        }
    }

    // Method to find the hottest month for a given city
    public int findHottestMonth(int city) {
        int hottestMonth = 0;
        double highestTemperature = weatherData[city][0][0];
        for (int month = 1; month < NUM_MONTHS; month++) {
            if (weatherData[city][month][0] > highestTemperature) {
                highestTemperature = weatherData[city][month][0];
                hottestMonth = month;
            }
        }
        return hottestMonth; // Return the index of the hottest month
    }

    // Method to find the wettest city in a given month
    public int findWettestCity(int month) {
        int wettestCity = 0;
        double highestRainfall = weatherData[0][month][2];
        for (int city = 1; city < NUM_CITIES; city++) {
            if (weatherData[city][month][2] > highestRainfall) {
                highestRainfall = weatherData[city][month][2];
                wettestCity = city;
            }
        }
        return wettestCity; // Return the index of the wettest city
    }

    // Method to calculate the average temperature for a given city
    public double averageTemperatureForYear(int city) {
        double totalTemperature = 0;
        for (int month = 0; month < NUM_MONTHS; month++) {
            totalTemperature += weatherData[city][month][0];
        }
        return totalTemperature / NUM_MONTHS; // Return the average temperature
    }

    // Method to compare two cities for a given month
    public void compareCities(int city1, int city2, int month) {
        System.out.println("Comparing City " + (city1 + 1) + " and City " + (city2 + 1) + " for Month " + (month + 1) + ":");
        String hotter = weatherData[city1][month][0] > weatherData[city2][month][0] ? "City " + (city1 + 1) : "City " + (city2 + 1);
        String moreHumid = weatherData[city1][month][1] > weatherData[city2][month][1] ? "City " + (city1 + 1) : "City " + (city2 + 1);
        String moreRainfall = weatherData[city1][month][2] > weatherData[city2][month][2] ? "City " + (city1 + 1) : "City " + (city2 + 1);
        
        System.out.println("Hotter: " + hotter);
        System.out.println("More Humid: " + moreHumid);
        System.out.println("More Rainfall: " + moreRainfall);
    }

    // Method to display all weather data for a specific city
    public void displayData(int city) {
        System.out.println("Weather data for City " + (city + 1) + ":");
        for (int month = 0; month < NUM_MONTHS; month++) {
            System.out.printf("Month %d - Temperature: %.2f, Humidity: %.2f, Rainfall: %.2f\n", 
                month + 1, weatherData[city][month][0], weatherData[city][month][1], weatherData[city][month][2]);
        }
    }

    public static void main(String[] args) {
        WeatherDataAnalyzer analyzer = new WeatherDataAnalyzer();
        analyzer.initializeData();

        // Find the hottest month for City 0
        int hottestMonth = analyzer.findHottestMonth(0);
        System.out.println("Hottest month for City 1: Month " + (hottestMonth + 1));

        // Find the wettest city in Month 0
        int wettestCity = analyzer.findWettestCity(0);
        System.out.println("Wettest city in Month 1: City " + (wettestCity + 1));

        // Average temperature for City 0
        double averageTemp = analyzer.averageTemperatureForYear(0);
        System.out.printf("Average temperature for City 1: %.2f\n", averageTemp);

        // Compare City 0 and City 1 for Month 0
        analyzer.compareCities(0, 1, 0);

        // Display weather data for City 0
        analyzer.displayData(0);
    }
}
