package assignment.q11;

public class ThreadExceptionDemo {

    public static void main(String[] args) {
        // Create a child thread that will throw a RuntimeException
        Thread childThread = new Thread(() -> {
            System.out.println("Child thread is running...");
            throw new RuntimeException("Unexpected error in child thread");
        });

        // Set uncaught exception handler for the thread
        childThread.setUncaughtExceptionHandler((thread, exception) -> {
            System.err.println("Caught exception from thread: " + thread.getName());
            System.err.println("Exception message: " + exception.getMessage());
            exception.printStackTrace();
        });

        // Start the thread
        childThread.start();

        // Optional: wait for child thread to finish
        try {
            childThread.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted while waiting.");
        }

        System.out.println("Main thread ends.");
    }
}

