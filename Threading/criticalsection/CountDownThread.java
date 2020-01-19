package criticalsection;

/**
 * CountDownThread
 */
public class CountDownThread extends Thread {

    private CountClass countDownObject;

    public CountDownThread(CountClass countDownObject) {
        this.countDownObject = countDownObject;
    }

    @Override
    public void run() {
        countDownObject.doCountDown();
    }

}