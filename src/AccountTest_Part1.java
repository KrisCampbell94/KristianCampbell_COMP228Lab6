import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class AccountTest_Part1 {
    public static void main(String[] args) {
        Account account = new Account(100);

        System.out.println("Starting transaction services.\n");

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Transaction("deposit",account));
        service.execute(new Transaction("withdraw",account));

        service.shutdown();
        System.out.println("\nFinished transaction services.\n");
    }
}
