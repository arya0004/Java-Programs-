import java.util.Scanner;

public class Car {
    // Define the Engine interface inside the Car class
    interface Engine {
        void start();
        void stop();
        void checkStatus();
        void increaseRPM(int increment);
        void decreaseRPM(int decrement);
    }

    // Common attributes for all cars
    protected boolean batteryCharged;
    protected int currentRPM;
    protected int engineTemperature; // in degrees Celsius
    protected long runtime; // in milliseconds
    protected long startTime; // used to calculate runtime

    // Constructor
    public Car(boolean batteryCharged) {
        this.batteryCharged = batteryCharged;
        this.currentRPM = 0;
        this.runtime = 0;
        this.engineTemperature = 25; // default engine temperature
    }

    // Method to check if the engine can start
    protected boolean canStart() {
        return batteryCharged;
    }

    // Method to log runtime
    protected void logRuntime() {
        runtime = System.currentTimeMillis() - startTime;
        System.out.println("Engine runtime: " + (runtime / 1000) + " seconds.");
    }

    // Sedan class implementing Engine interface
    public static class Sedan extends Car implements Engine {
        private final int MAX_RPM = 6000;

        public Sedan(boolean batteryCharged) {
            super(batteryCharged);
        }

        @Override
        public void start() {
            if (canStart()) {
                System.out.println("Sedan engine started.");
                startTime = System.currentTimeMillis();
            } else {
                System.out.println("Cannot start the engine. Please charge the battery.");
            }
        }

        @Override
        public void stop() {
            System.out.println("Sedan engine stopped.");
            logRuntime();
            currentRPM = 0; // reset RPM when stopped
        }

        @Override
        public void checkStatus() {
            System.out.println("Battery charged: " + batteryCharged);
            System.out.println("Current RPM: " + currentRPM);
            System.out.println("Engine temperature: " + engineTemperature + "°C");
        }

        @Override
        public void increaseRPM(int increment) {
            if (currentRPM + increment <= MAX_RPM) {
                currentRPM += increment;
                System.out.println("Sedan RPM increased to: " + currentRPM);
            } else {
                System.out.println("RPM cannot exceed " + MAX_RPM);
            }
        }

        @Override
        public void decreaseRPM(int decrement) {
            if (currentRPM - decrement < 500) {
                System.out.println("Warning: RPM is too low!");
            }
            currentRPM = Math.max(0, currentRPM - decrement);
            System.out.println("Sedan RPM decreased to: " + currentRPM);
        }
    }

    // SUV class implementing Engine interface
    public static class SUV extends Car implements Engine {
        private final int MAX_RPM = 7000;

        public SUV(boolean batteryCharged) {
            super(batteryCharged);
        }

        @Override
        public void start() {
            if (canStart()) {
                System.out.println("SUV engine started.");
                startTime = System.currentTimeMillis();
            } else {
                System.out.println("Cannot start the engine. Please charge the battery.");
            }
        }

        @Override
        public void stop() {
            System.out.println("SUV engine stopped.");
            logRuntime();
            currentRPM = 0; // reset RPM when stopped
        }

        @Override
        public void checkStatus() {
            System.out.println("Battery charged: " + batteryCharged);
            System.out.println("Current RPM: " + currentRPM);
            System.out.println("Engine temperature: " + engineTemperature + "°C");
        }

        @Override
        public void increaseRPM(int increment) {
            if (currentRPM + increment <= MAX_RPM) {
                currentRPM += increment;
                System.out.println("SUV RPM increased to: " + currentRPM);
            } else {
                System.out.println("RPM cannot exceed " + MAX_RPM);
            }
        }

        @Override
        public void decreaseRPM(int decrement) {
            if (currentRPM - decrement < 500) {
                System.out.println("Warning: RPM is too low!");
            }
            currentRPM = Math.max(0, currentRPM - decrement);
            System.out.println("SUV RPM decreased to: " + currentRPM);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter battery status (true for charged, false for not charged): ");
        boolean batteryStatus = scanner.nextBoolean();

        // Create Sedan and SUV instances
        Sedan sedan = new Sedan(batteryStatus);
        SUV suv = new SUV(batteryStatus);

        // Demonstrate Sedan functionalities
        sedan.start();
        sedan.increaseRPM(3000);
        sedan.checkStatus();
        sedan.decreaseRPM(1000);
        sedan.stop();

        // Demonstrate SUV functionalities
        suv.start();
        suv.increaseRPM(6500);
        suv.checkStatus();
        suv.decreaseRPM(600);
        suv.stop();

        scanner.close();
    }
}
