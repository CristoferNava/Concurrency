public class Main {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            for (int i = 1; i <= 100; i++) {
                System.out.printf("Hilo 1: %d\n", i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 1; i <= 100; i++) {
                System.out.printf("Hilo 2: %d\n", i);
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
}