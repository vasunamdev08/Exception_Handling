package assignment.q8;

import java.util.Random;

public class RetryPolicyDemo {

    // Simulated flaky service that randomly fails
    public static String flakyService() throws Exception {
        if (new Random().nextInt(3) != 0) { // ~66% chance of failure
            throw new Exception("Service temporarily failed.");
        }
        return "Service response data";
    }

    // Retry wrapper with 3 attempts
    public static String readFromFlakyService() throws ServiceUnavailableException {
        int attempts = 0;
        final int maxAttempts = 3;

        while (attempts < maxAttempts) {
            try {
                return flakyService(); // Attempt to read
            } catch (Exception e) {
                attempts++;
                System.err.println("Attempt " + attempts + " failed: " + e.getMessage());
                if (attempts >= maxAttempts) {
                    throw new ServiceUnavailableException("Service unavailable after " + attempts + " attempts.");
                }
            }
        }

        throw new ServiceUnavailableException("Unexpected failure."); // Unreachable but required
    }

    public static void main(String[] args) {
        try {
            String result = readFromFlakyService();
            System.out.println("Received: " + result);
        } catch (ServiceUnavailableException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}