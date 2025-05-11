package assignment.q9;

public class AppController {
    public static void main(String[] args) {
        UserService service = new UserService();

        try {
            service.fetchUser(1);
        } catch (ServiceLayerException e) {
            System.err.println("ERROR in Controller: " + e.getMessage());
            System.err.println("Caused by: " + e.getCause());
            e.printStackTrace();
        }
    }
}