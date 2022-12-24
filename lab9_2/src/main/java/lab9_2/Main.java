package lab9_2;

public class Main {
    public static void main(String[] args) {
        final int CAPACITY = 100;
        final int DELAY_MS = 5;
        CommonResource result = new CommonResource();
        CircularBuffer firstBuffer = new CircularBuffer(CAPACITY);
        CircularBuffer secondBuffer = new CircularBuffer(CAPACITY);
        ProducerThread[] producerThreads = new ProducerThread[]{
                new ProducerThread("Thread №1", firstBuffer, DELAY_MS),
                new ProducerThread("Thread №2", firstBuffer, DELAY_MS),
                new ProducerThread("Thread №3", firstBuffer, DELAY_MS),
                new ProducerThread("Thread №4", firstBuffer, DELAY_MS),
                new ProducerThread("Thread №5", firstBuffer, DELAY_MS)
        };
        ConsumerThread[] consumerThreads = new ConsumerThread[]{
                new ConsumerThread("Thread №1", firstBuffer, secondBuffer, DELAY_MS, result),
                new ConsumerThread("Thread №2", firstBuffer, secondBuffer, DELAY_MS, result)
        };
        for (ProducerThread producerThread : producerThreads) {
            producerThread.start();
        }
        for (ConsumerThread consumerThread : consumerThreads) {
            consumerThread.start();
        }
        while(!result.isFull()){
            try {
                Thread.sleep(DELAY_MS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        secondBuffer.print();
    }
}