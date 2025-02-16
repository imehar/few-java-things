package consumer_producer;

import java.util.Random;

/**
 * Writer
 */
public class Writer implements Runnable {

    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        final String[] messages = { "Humpty Dumpty sat on the wall", "Humpty Dumpty had a great fall",
                "All the kings horses and the kings men", "Couldnt put Humpty Dumpty together again" };
        Random random = new Random();
        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        message.write("Finished");
    }

}