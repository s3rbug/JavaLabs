import ParallelMonteCarloPi.MonteCarloCalculations;
import ParallelMonteCarloPi.ParallelMonteCarloPi;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int countThreads = 4;
        int iterations = (int) 1e7;
        MonteCarloCalculations calculations = new MonteCarloCalculations(countThreads, iterations);
        double pi;
        try {
            pi = ParallelMonteCarloPi.calculatePi(calculations);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("PI is " + pi);
        System.out.println("THREADS " + countThreads);
        System.out.println("ITERATIONS " + iterations);
        System.out.println("ITERATIONS THREAD " + calculations.getCountOfThreadIterations());
        System.out.println("TIME " + executionTime + "ms");
    }
}