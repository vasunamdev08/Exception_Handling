package assignment.q10;

public class BadLoopControl {
    public static void main(String[] args) {
        String[] names = { "Alice", "Bob", "Charlie", "David" };

        try {
            for (String name : names) {
                System.out.println("Checking: " + name);
                if ("Charlie".equals(name)) {
                    throw new Exception("Found target, exiting loop");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception used to break loop: " + e.getMessage());
        }
    }
}
