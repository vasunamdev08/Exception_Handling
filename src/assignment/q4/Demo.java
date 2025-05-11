package assignment.q4;

public class Demo {
    public static void main(String[] args) {
        try {
            // Simulate an exception
            throw new Exception("This is the original exception");
        } catch (Exception e) {
            // Wrap the original exception in a custom exception
            CustomException customException = new CustomException("This is a custom exception", e);
            // Print the stack trace of the custom exception
            customException.printStackTrace();
        }
    }
}
