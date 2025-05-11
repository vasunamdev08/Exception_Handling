package assignment.q7;

public class SuppressedExceptionDemo {
    public static void main(String[] args) {
        try (ResourceA a = new ResourceA(); ResourceB b = new ResourceB()) {
            throw new Exception("Exception during main try block");
        } catch (Exception e) {
            System.err.println("Caught primary exception: " + e.getMessage());

            // Display suppressed exceptions
            for (Throwable suppressed : e.getSuppressed()) {
                System.err.println("Suppressed: " + suppressed.getMessage());
            }
        }
    }
}