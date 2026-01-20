import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TransactionLogger {

    private static final String FILE_NAME = "transactions_log.txt";

    public void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println(message);
        } catch (IOException e) {
            System.out.println("Failed to write transaction log.");
        }
    }
}




