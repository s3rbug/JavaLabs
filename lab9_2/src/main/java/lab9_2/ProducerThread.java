package lab9_2;

import java.util.concurrent.ThreadLocalRandom;

public class ProducerThread extends Thread {
    CircularBuffer firstBuffer;
    int delayMs;
    public ProducerThread(String name, CircularBuffer firstBuffer, int delayMs){
        super(name);
        this.firstBuffer = firstBuffer;
        this.delayMs = delayMs;

        setDaemon(true);
    }

    private String generateMessage(){
        return this.getName() + " generated message: Message " + ThreadLocalRandom.current().nextInt(100, 1000);
    }

    public void run(){
        while (true){
            firstBuffer.offer(generateMessage());
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
