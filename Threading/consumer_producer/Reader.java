package consumer_producer;

import java.util.Random;

/**
 * Reader
 */
public class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String newmessage = message.read(); !newmessage.equals("Finished");) {

            System.out.println(newmessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            newmessage = message.read();
        }

    }

}