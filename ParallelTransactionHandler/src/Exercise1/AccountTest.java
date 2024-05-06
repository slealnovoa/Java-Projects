package Exercise1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args){
        Account account1 = new Account(10000);

        ArrayList<Transaction> transactions = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            transactions.add(new Transaction(account1));
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 4; i++){
            executorService.execute(transactions.get(i));
        }
        executorService.shutdown();
    }
}