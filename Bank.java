import java.util.*;

public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) return; // Not enough money to transfer
        // Enough money to transfer
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        // System.out.printf("%10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        // System.out.printf("Total Balance: %10.2f", getTotalBalance());
    }

    public int size() {
        return accounts.length;
    }
}