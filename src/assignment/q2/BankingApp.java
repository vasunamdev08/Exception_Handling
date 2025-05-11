package assignment.q2;

public class BankingApp {
    public static void transferFunds(String fromAccount, String toAccount, double amount)
            throws BankingException {

        if (fromAccount == null || toAccount == null || fromAccount.isEmpty() || toAccount.isEmpty()) {
            throw new InvalidAccountException("Invalid account number.");
        }

        if (amount > 1000) { // Simulate insufficient funds
            throw new InsufficientFundsException("Insufficient balance to transfer $" + amount);
        }

        System.out.println("Transferred $" + amount + " from " + fromAccount + " to " + toAccount);
    }

    public static void main(String[] args) {
        try {
            // Case 1: Invalid account
            transferFunds("", "987654", 500);
        } catch (InvalidAccountException e) {
            System.err.println("Caught InvalidAccountException: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.err.println("Caught InsufficientFundsException: " + e.getMessage());
        } catch (BankingException e) {
            System.err.println("Caught generic BankingException: " + e.getMessage());
        }

        try {
            // Case 2: Insufficient funds
            transferFunds("123456", "987654", 2000);
        } catch (BankingException e) {
            System.err.println("Caught BankingException: " + e.getMessage());
        }

        try {
            // Case 3: Successful transfer
            transferFunds("123456", "987654", 500);
        } catch (BankingException e) {
            System.err.println("Caught BankingException: " + e.getMessage());
        }
    }
}
