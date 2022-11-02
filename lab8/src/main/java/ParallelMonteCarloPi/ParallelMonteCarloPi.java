package ParallelMonteCarloPi;

public class ParallelMonteCarloPi {
    public static double calculatePi(MonteCarloCalculations calculations) throws InterruptedException {
        int countThreads = calculations.getCountThreads();
        int countOfEachThreadIterations = calculations.getCountOfThreadIterations();
        int totalIterations = calculations.getTotalIterations();
        MonteCarloThread[] threads = new MonteCarloThread[countThreads];
        for(int i = 0; i < countThreads; ++i){
            threads[i] = new MonteCarloThread("MonteCarloThread " + i, countOfEachThreadIterations);
            threads[i].start();
        }
        int totalPassed = 0;
        for(MonteCarloThread thread: threads){
            thread.join();
            totalPassed += thread.getPassed();
        }
        return 4.0 * totalPassed / totalIterations;
    }
}
