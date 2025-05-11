package assignment.q5;

public class Account {
    String accountNumber;
    double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void debit(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    public void credit(double amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return accountNumber + ": $" + balance;
    }
}
