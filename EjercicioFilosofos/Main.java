public class Main {
    public static void main(String[] args) {
        Desk m = new Desk(5);
        for (int i = 1; i <= 5; i++) {
            Philosopher f1 = new Philosopher(m, i);
            f1.start();
        }
    }
}