public class TransactionParser {

    public static class TransactionCommand {
        private final String action;
        private final double amount;

        public TransactionCommand(String action, double amount) {
            this.action = action;
            this.amount = amount;
        }

        public String getAction() {
            return action;
        }

        public double getAmount() {
            return amount;
        }
    }

    public TransactionCommand parse(String line) {
        String[] parts = line.split("\\s+");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid command format: " + line);
        }

        String action = parts[0].toUpperCase();
        double amount;

        try {
            amount = Double.parseDouble(parts[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number in transaction: " + parts[1]);
        }

        if (!action.equals("DEPOSIT") && !action.equals("WITHDRAW")) {
            throw new IllegalArgumentException("Unknown transaction type: " + action);
        }

        return new TransactionCommand(action, amount);
    }

    public void apply(TransactionCommand cmd, AccountOperations target) throws InsufficientFundsException {
        if (cmd.getAction().equals("DEPOSIT")) {
            target.deposit(cmd.getAmount());
        } else { // WITHDRAW
            target.withdraw(cmd.getAmount());
        }
    }
}

