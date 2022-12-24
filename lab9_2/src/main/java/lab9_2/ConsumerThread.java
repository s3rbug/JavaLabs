package lab9_2;

public class ConsumerThread extends Thread {
    CircularBuffer firstBuffer, secondBuffer;
    CommonResource result;
    int delayMs;
    public ConsumerThread(String name, CircularBuffer firstBuffer, CircularBuffer secondBuffer,
                          int delayMs, CommonResource result){
        super(name);
        this.firstBuffer = firstBuffer;
        this.secondBuffer = secondBuffer;
        this.result = result;
        this.delayMs = delayMs;

        setDaemon(true);
    }

    public String parseMessage(String message){
        return this.getName() + " transferred message: " + message.split(": ")[1];
    }

    public void run(){
        while (true){
            String message = firstBuffer.poll();
            if(message != null){
                secondBuffer.offer(parseMessage(message));
                result.increment();
            }
            if(result.isFull()){
                break;
            }
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
