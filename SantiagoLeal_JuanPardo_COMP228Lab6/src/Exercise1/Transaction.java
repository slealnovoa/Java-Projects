package Exercise1;


public class Transaction implements Runnable{

    public Account account;

    public Transaction(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try{
            account.withdraw(150);
            Thread.sleep(205);
        }catch(InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        account.deposit(245);
        try{
            Thread.sleep(500);

        }catch(InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("The new balance is: $" + account.getBalance());
    }
}
