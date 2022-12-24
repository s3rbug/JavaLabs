package lab9_2;

public class CommonResource {
    private int count = 0;

    public synchronized void increment(){
        ++count;
    }

    public synchronized int getCount(){
        return count;
    }

    public synchronized boolean isFull(){
        return count >= 100;
    }
}
