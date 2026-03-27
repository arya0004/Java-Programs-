class NumberPrinter {
    private int currentNumber = 1; // Track the current number to be printed

    // Synchronized method to print numbers in order
    public synchronized void printNumber(int threadId, int maxNumber) {
        while (currentNumber <= maxNumber) {
            if (currentNumber % 3 == threadId) { // Ensure the correct thread is printing
                System.out.println("Thread " + (threadId + 1) + " prints: " + currentNumber);
                currentNumber++;
                notifyAll(); // Notify other threads waiting to print
            } else {
                try {
                    wait(); // Wait for the correct turn to print
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

class PrinterThread extends Thread {
    private final NumberPrinter printer;
    private final int threadId;
    private final int maxNumber;

    public PrinterThread(NumberPrinter printer, int threadId, int maxNumber) {
        this.printer = printer;
        this.threadId = threadId;
        this.maxNumber = maxNumber;
    }

    @Override
    public void run() {
        printer.printNumber(threadId, maxNumber);
    }
}

public class SequentialPrinter {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();
        int maxNumber = 10;

        // Create 3 threads that will print numbers sequentially
        PrinterThread thread1 = new PrinterThread(printer, 0, maxNumber);
        PrinterThread thread2 = new PrinterThread(printer, 1, maxNumber);
        PrinterThread thread3 = new PrinterThread(printer, 2, maxNumber);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Join the threads to ensure all are completed before exiting main
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All numbers printed.");
    }
}
