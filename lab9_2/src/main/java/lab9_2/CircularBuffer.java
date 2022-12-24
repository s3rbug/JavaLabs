package lab9_2;

public class CircularBuffer {
    private final int capacity;
    private final String[] data;
    private int writeSequence, readSequence;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.data = new String[this.capacity];
        this.readSequence = 0;
        this.writeSequence = -1;
    }

    public synchronized boolean offer(String element) {
        if (!isFull()) {
            int nextWriteSequence = writeSequence + 1;
            data[nextWriteSequence % capacity] = element;
            writeSequence++;
            return true;
        }
        return false;
    }

    public synchronized String poll() {
        if (!isEmpty()) {
            String nextValue = data[readSequence % capacity];
            readSequence++;
            return nextValue;

        }
        return null;
    }

    public synchronized int getCapacity() {
        return capacity;
    }

    public synchronized int getSize() {
        return writeSequence - readSequence + 1;
    }

    public synchronized boolean isEmpty() {
        return writeSequence < readSequence;
    }

    public synchronized boolean isFull() {
        return getSize() >= capacity;
    }

    public void print() {
        for (int i = 0; i < capacity; ++i) {
            System.out.println(data[i]);
        }
    }
}