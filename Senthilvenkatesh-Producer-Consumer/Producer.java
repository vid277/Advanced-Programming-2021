import java.time.LocalDate;
import java.util.Date;

/**
 * This is the class that is used to simulate a producer.
 * This repeatedly adds items to the list of items.
 * @author Vidyoot Senthilvenkatesh
 * @version 5/18/2022
 */
public class Producer extends Thread {

    //A copy of the shared linked list
    LinkListQueue<String> customerQueue = new LinkListQueue<String>();

    /**
     * Creates a copy of the linked list
     * @param customerQueue the queue that contains all the items used by the producer and consumer
     */
    public Producer(LinkListQueue<String> customerQueue) {
        this.customerQueue = customerQueue;
    }

    /**
     * Runs for 100 iterations
     * Repeatedly adds strings, which contains the current date and time, to the queue
     * An output is printed when an item is produced
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            try {
                String add = new Date().toString();

                //Prints out an output when an item is produced
                System.out.println("Producer: " + Thread.currentThread().getId() + "\t Item: " + add);

                //Adds items to the end of the queue
                customerQueue.enqueue(add);
            } catch (InterruptedException e) {
            }
        }
    }
}
