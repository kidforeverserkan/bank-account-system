import java.util.ArrayList;
import java.util.List;

public class BankAccount implements AccountOperations {

    private double balance;
    private final List<String> transactionHistory;

    public BankAccount() {
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot deposit a negative amount.");
        }
        balance += amount;
        recordTransaction("DEPOSIT " + amount + " | Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds: balance is " + balance);
        }
        balance -= amount;
        recordTransaction("WITHDRAW " + amount + " | Balance: " + balance);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    // Session-only history (in-memory). No printing here.
    private void recordTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public void listTransactions() {
        System.out.println("Transaction History (session):");
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }
}


