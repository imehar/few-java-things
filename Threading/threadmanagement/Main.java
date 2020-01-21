
package threadmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Main
 */
public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        MyProducer producer = new MyProducer(buffer, ANSI_BLUE, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ANSI_GREEN, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ANSI_GREEN, bufferLock);

        // Without threadpool

        // new Thread(producer).start();
        // new Thread(consumer1).start();
        // new Thread(consumer2).start();

        // With thread pool

        executor.execute(producer);
        executor.execute(consumer1);
        executor.execute(consumer2);

        executor.shutdown();
    }
}