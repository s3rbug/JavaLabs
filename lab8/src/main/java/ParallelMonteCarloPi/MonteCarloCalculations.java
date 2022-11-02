package ParallelMonteCarloPi;

public class MonteCarloCalculations {
    private final int countThreads;
    private final int iterations;

    public MonteCarloCalculations(int countThreads, int iterations) {
        this.countThreads = countThreads;
        this.iterations = iterations;
    }


    public int getCountOfThreadIterations() {
        return iterations / countThreads;
    }

    public int getCountThreads(){
        return countThreads;
    }

    public int getTotalIterations(){
        return iterations;
    }
}
