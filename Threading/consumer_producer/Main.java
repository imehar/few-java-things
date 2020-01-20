
package consumer_producer;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Writer(message)).start();
        new Thread(new Reader(message)).start();
    }
}

/**
 * Message
 */
class Message {
    private String message;
    private boolean empty = true;

    // public Message(final String message) {
    // this.message = message;
    // }

    public synchronized String read() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        empty = true;
        notifyAll();
        return this.message;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }

}