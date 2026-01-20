import java.util.List;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Alice", 1);

        TransactionReader reader = new TransactionReader();
        TransactionParser parser = new TransactionParser();
        TransactionLogger logger = new TransactionLogger();

        // 1) Manual demo (still useful)
        try {
            customer.deposit(200);
            logger.log("MANUAL DEPOSIT 200 | Balance: " + customer.getBalance());

            customer.withdraw(50);
            logger.log("MANUAL WITHDRAW 50 | Balance: " + customer.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Manual transaction failed: " + e.getMessage());
        }

        // 2) File-driven demo: read commands and apply
        List<String> commands = reader.readAll();

        for (String line : commands) {
            if (line.isBlank()) continue;

            try {
                TransactionParser.TransactionCommand cmd = parser.parse(line);
                parser.apply(cmd, customer);

                logger.log(cmd.getAction() + " " + cmd.getAmount() + " | Balance: " + customer.getBalance());

            } catch (IllegalArgumentException e) {
                // Bad input line (format, unknown command, invalid number)
                System.out.println("Skipping invalid line: " + line + " (" + e.getMessage() + ")");
            } catch (InsufficientFundsException e) {
                // Business rule failure
                System.out.println("Transaction failed: " + line + " (" + e.getMessage() + ")");
            }
        }

        // 3) Show session history at the end
        customer.listTransactions();
        System.out.println("Final Balance: " + customer.getBalance());
    }
}


