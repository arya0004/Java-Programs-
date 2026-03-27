public class TwinPrimes {
    
    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        // if (num <= 1) {
        //     return false;
        // }
        // for (int i = 2; i <= Math.sqrt(num); i++) {
        //     if (num % i == 0) {
        //         return false;
        //     }
        // }
        for (int i = 2; i < num; i++) 
        {
                if (num % i == 0) {
                    return false;
                }}
            
        return true;
        
    }

    // Method to find and display twin primes less than 100
    public static void findTwinPrimes() {
        System.out.println("Twin primes less than 100 are:");
        
        for (int i = 2; i < 100; i++) {
            // Check if i and i+2 are both prime numbers
            if (isPrime(i) && isPrime(i + 2)) {
                System.out.println("(" + i + ", " + (i + 2) + ")");
            }
        }
    }

    public static void main(String[] args) {
        findTwinPrimes();
    }
}
