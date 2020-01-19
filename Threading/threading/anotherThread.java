package threading;

import static threading.MainThread.ANSI_BLUE;

public class anotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from anotherThread");
        try {
            Thread.sleep(3000);
            System.out.println(ANSI_BLUE + " anotherThread woke up");
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "I was interrupted");
        }
    }
}