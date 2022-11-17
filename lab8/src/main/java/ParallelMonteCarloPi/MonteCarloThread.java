package ParallelMonteCarloPi;

import java.util.Random;

public class MonteCarloThread extends Thread {
    final int countOfEachThreadIterations;
    private int passed = 0;

    public MonteCarloThread(String name, int countOfEachThreadIterations) {
        super(name);
        this.countOfEachThreadIterations = countOfEachThreadIterations;
    }

    public int getPassed() {
        return passed;
    }

    public void run() {
        Random random = new Random();
        passed = 0;
        double x, y;
        for (int i = 0; i < countOfEachThreadIterations; ++i) {
            x = random.nextDouble();
            y = random.nextDouble();
            if ((x * x + y * y) <= 1) {
                ++passed;
            }
        }
    }
}
