public class Customer implements AccountOperations {

    private final String name;
    private final int id;
    private final BankAccount account;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
        this.account = new BankAccount();
    }

    @Override
    public void deposit(double amount) {
        account.deposit(amount);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        account.withdraw(amount);
    }

    @Override
    public double getBalance() {
        return account.getBalance();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void listTransactions() {
        account.listTransactions();
    }
}
