package threadmanagement;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * MyConsumer
 */
public class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    /**
     * @param buffer
     * @param color
     */
    /*
     * public MyConsumer(List<String> buffer, String color) { this.buffer = buffer;
     * this.color = color; }
     */

    /**
     * @param buffer
     * @param color
     * @param bufferLock
     */
    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            // synchronized (buffer) { //without lock
            if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.get(0).equals("EOF")) {
                        System.out.println(color + "Poping EOF ");
                        break;
                    } else {
                        System.out.println("Count is " + counter);
                        System.out.println(color + "Poping " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }

            // }

        }
    }

}