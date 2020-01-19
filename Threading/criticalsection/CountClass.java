package criticalsection;

/**
 * CountClass
 */
public class CountClass {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    int i = 0;

    void doCountDown() {
        String color = ANSI_RED;
        String name = Thread.currentThread().getName();

        switch (name) {
        case "Thread-0":
            color = ANSI_BLUE;
            break;
        case "Thread-1":
            color = ANSI_GREEN;
            break;
        default:
            color = ANSI_PURPLE;
            break;
        }

        for (i = 0; i <= 10; i++) {
            System.out.println(color + name + " i :" + i);
            // try {
            // Thread.sleep(2);
            // } catch (InterruptedException e) {
            // System.out.println(e.getMessage());
            // }
        }
    }

}