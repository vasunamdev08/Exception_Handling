package assignment.q5;

import java.util.HashMap;
import java.util.Map;

public class BankTransaction {

    static Map<String, Account> accounts = new HashMap<>();

    public static void setupAccounts() {
        accounts.put("A100", new Account("A100", 1000));
        accounts.put("B200", new Account("B200", 500));
        // C300 does NOT exist intentionally
    }

    public static void transferFunds(String fromAcc, String toAcc, double amount) {
        Account from = accounts.get(fromAcc);
        Account to = accounts.get(toAcc);

        if (from == null) throw new IllegalArgumentException("From account does not exist");

        double originalFromBalance = from.balance;

        try {
            from.debit(amount);

            if (to == null) {
                throw new IllegalArgumentException("To account does not exist");
            }

            to.credit(amount);
            System.out.println("Transfer successful!");
        } catch (Exception e) {
            // Rollback the debit
            from.balance = originalFromBalance;
            System.err.println("Transfer failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        setupAccounts();

        System.out.println("Before Transfer:");
        accounts.values().forEach(System.out::println);

        // Successful transfer
        transferFunds("A100", "B200", 200);

        // Failing transfer: target account doesn't exist, should rollback
        transferFunds("A100", "C300", 300);

        System.out.println("\nAfter Transfers:");
        accounts.values().forEach(System.out::println);
    }
}
