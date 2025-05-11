package assignment.q12;

public class GlobalExceptionHandlerDemo {

    public static void main(String[] args) {

        // Set the default uncaught exception handler for all threads
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            System.err.println("GLOBAL HANDLER: Uncaught exception in thread '" + thread.getName() + "'");
            System.err.println("Exception message: " + exception.getMessage());
            exception.printStackTrace();
        });

        // Start a thread that will throw a runtime exception
        Thread faultyThread = new Thread(() -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
            throw new RuntimeException("Oops! Something went wrong in the thread.");
        });

        // Start another thread that runs fine
        Thread healthyThread = new Thread(() -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " completed successfully.");
        });

        faultyThread.start();
        healthyThread.start();

        // Wait for threads to finish (optional for demo)
        try {
            faultyThread.join();
            healthyThread.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted");
        }

        System.out.println("Main thread exits.");
    }
}
