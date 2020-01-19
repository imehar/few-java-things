package threading;

/**
 * MainThread
 */
public class MainThread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Thread anotherthread = new anotherThread();
        anotherthread.start();
        System.out.println(ANSI_PURPLE + "Hello from main thread");

        // You cannot start an instance of thread more than once ,
        // in order to run it again, we need to create another instance

        // anotherthread.start();

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_CYAN + "Hello from anonymous class");
            }
        }.start();

        Thread anonymusRunnable = new Thread(new MyRunnable() {

            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from anonymus Runnable");
                try {
                    anotherthread.join();
                    System.out.println(ANSI_RED + "anotherthread completed, now I'm running");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I was interrupted");
                }
            }
        });
        anonymusRunnable.start();

        System.out.println(ANSI_PURPLE + "Hello again from main thread");
    }
}