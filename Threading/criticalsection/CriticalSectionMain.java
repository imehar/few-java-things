
package criticalsection;

/**
 * CriticalSectionMain
 */
public class CriticalSectionMain {

    public static void main(final String[] args) {
        CountClass obj = new CountClass();
        CountDownThread thread1 = new CountDownThread(obj);
        CountDownThread thread2 = new CountDownThread(obj);

        thread1.start();
        thread2.start();

    }
}