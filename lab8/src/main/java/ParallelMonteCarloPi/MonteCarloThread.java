package ParallelMonteCarloPi;

public class MonteCarloThread extends Thread {
    final int countOfEachThreadIterations;
    private int passed = 0;

    public MonteCarloThread(String name, int countOfEachThreadIterations) {
        super(name);
        this.countOfEachThreadIterations = countOfEachThreadIterations;
    }

    public int getPassed(){
        return passed;
    }

    public void run() {
        passed = 0;
        double x, y;
        for(int i = 0; i < countOfEachThreadIterations; ++i){
            x = Math.random();
            y = Math.random();
            if((x * x + y * y) <= 1){
                ++passed;
            }
        }
    }
}
