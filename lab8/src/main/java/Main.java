import ParallelMonteCarloPi.MonteCarloCalculations;
import ParallelMonteCarloPi.ParallelMonteCarloPi;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        int countThreads = 8;
        int iterations = (int) 1e9;
        MonteCarloCalculations calculations = new MonteCarloCalculations(countThreads, iterations);
        double pi;
        long startTime = System.currentTimeMillis();
        try {
            pi = ParallelMonteCarloPi.calculatePi(calculations);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("PI is " + pi);
        System.out.println("THREADS " + countThreads);
        System.out.println("ITERATIONS " + NumberFormat.getNumberInstance(Locale.ENGLISH).format(iterations));
        System.out.println("TIME " + executionTime + "ms");
    }
}