import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest_Part2 {
    public static void main(String[] args) {
        Account account = new Account(1000);
        List<Transaction> transactions = new LinkedList<>();
        transactions.add(new Transaction("deposit",account));
        transactions.add(new Transaction("withdraw",account));
        transactions.add(new Transaction("deposit",account));
        transactions.add(new Transaction("withdraw",account));
        transactions.add(new Transaction("withdraw",account));
        transactions.add(new Transaction("withdraw",account));
        ExecutorService service = Executors.newCachedThreadPool();

        System.out.println("Starting transaction services.\n");
        for (var transaction:transactions) {
            service.execute(transaction);
        }
        service.shutdown();
        System.out.println("\nFinished transaction services.\n");
    }
}
