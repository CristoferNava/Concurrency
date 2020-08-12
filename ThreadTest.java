public class ThreadTest {
    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1_000;

    public static void main(String[] args) {
        var bank = new Bank(4, 100_000);
        
        // 1: Create the tasks we want to execute
        // Task1: Move money from the account 1 to 2
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                   double amount = MAX_AMOUNT * Math.random();
                   bank.transfer(0, 1, amount);
                   Thread.sleep((int) (DELAY * Math.random())); 
                }
            } catch (InterruptedException e) {
                //TODO: handle exception
            }
        };

        // Task2: Move money from the account 3 to 4
        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                   double amount = MAX_AMOUNT * Math.random();
                   bank.transfer(2, 3, amount);
                   Thread.sleep((int) (DELAY * Math.random())); 
                }
            } catch (InterruptedException e) {
                //TODO: handle exception
            }
        };

        // 2: Construct the threads
        // 3: Start the threads
        new Thread(task1).start();
        new Thread(task2).start();
    }
}