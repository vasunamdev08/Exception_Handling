package assignment.q6;

public class ExceptionTypeDemo {

    // Simulates checking a file format (recoverable error)
    public static void validateFile(String fileName) throws FileValidationException {
        if (!fileName.endsWith(".txt")) {
            throw new FileValidationException("Only .txt files are allowed");
        }
        System.out.println("File '" + fileName + "' is valid.");
    }

    // Simulates a critical system operation (non-recoverable error)
    public static void startSystemComponent(Object config) {
        if (config == null) {
            throw new CriticalSystemException("Critical configuration missing — system cannot start");
        }
        System.out.println("System component started successfully.");
    }

    public static void main(String[] args) {
        // Use checked exception for expected recoverable input issue
        try {
            validateFile("report.pdf");  // Triggers checked exception
        } catch (FileValidationException e) {
            System.err.println("Validation failed: " + e.getMessage());
            // Might ask user to upload a correct file, etc.
        }

        // Use unchecked exception for unrecoverable failure
        try {
            startSystemComponent(null);  // Triggers unchecked exception
        } catch (CriticalSystemException e) {
            System.err.println("System failure: " + e.getMessage());
            // Might log, halt program, or alert admin
        }
    }
}
