package assignment.q1;

import java.io.IOException;

public class Main {

    public void readData() throws IOException {
        throw new IOException("Failed to read data");
    }

    public void processData() throws DataProcessingException {
        try {
            readData();
        }catch (IOException e){
            throw new DataProcessingException("Failed to process data", new IOException("Failed to read data"));
        }
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();
            main.processData();
        } catch (DataProcessingException e) {
            System.out.println("Caught DataProcessingException: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getMessage());
        }
    }
}
