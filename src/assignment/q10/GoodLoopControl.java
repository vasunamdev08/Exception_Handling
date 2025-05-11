package assignment.q10;

public class GoodLoopControl {
    public static void main(String[] args) {
        String[] names = { "Alice", "Bob", "Charlie", "David" };

        for (String name : names) {
            System.out.println("Checking: " + name);
            if ("Charlie".equals(name)) {
                System.out.println("Found target, exiting loop");
                break;
            }
        }
    }
}

