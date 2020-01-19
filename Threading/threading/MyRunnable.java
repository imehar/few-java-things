package threading;

/**
 * MyRunnable
 */

import static threading.MainThread.ANSI_RED;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + " Hello from MyRunnable");

    }

}