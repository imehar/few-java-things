package threadmanagement;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * MyProducer
 */
public class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock buffeLock;

    /**
     * @param buffer
     * @param color
     */

    /*
     * //Without lock; public MyProducer(List<String> buffer, String color) {
     * this.buffer = buffer; this.color = color; }
     */

    // With lock

    /**
     * @param buffer
     * @param color
     * @param buffeLock
     */
    public MyProducer(List<String> buffer, String color, ReentrantLock buffeLock) {
        this.buffer = buffer;
        this.color = color;
        this.buffeLock = buffeLock;
    }

    @Override
    public void run() {

        String nums[] = { "1", "2", "3", "4", "5" };
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            try {
                System.out.println(color + "Adding " + nums[i]);
                // synchronized (buffer) { //without lock
                buffeLock.lock(); // with lock
                try {
                    buffer.add(nums[i]);
                } finally {
                    buffeLock.unlock(); // with lock
                }

                // }
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        // synchronized (buffer) { //without lock
        buffeLock.lock(); // with lock
        try {
            buffer.add("EOF");
        } finally {
            buffeLock.unlock(); // with lock
        }
        // }

    }

}