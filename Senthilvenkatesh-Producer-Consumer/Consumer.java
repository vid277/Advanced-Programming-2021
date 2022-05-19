/**
 * This is the consumer class which is used to simulate consumers
 * They consume the items produced by the producers
 * @author Vidyoot Senthilvenkatesh
 * @date 5/18/2022
 */
public class Consumer extends Thread{

    //Stores a copy of the linked list
    LinkListQueue<String> customerQueue = new LinkListQueue<String>();

    /**
     * Copies the linked list into a local variable
     * @param customerQueue the linked list that is shared between the consumers and the producers
     */
    public Consumer(LinkListQueue customerQueue){
        this.customerQueue = customerQueue;
    }

    /**
     * This runs for 100 iterations and repeatedly dequeues items from the queue until there are no items left
     */
    public void run(){
        for (int i = 0; i < 100; i++){
            try {
                //Dequeues the item from the list
                String returnLine = customerQueue.dequeue();

                //Outputs when an item is dequeued
                System.out.println("Consumer: " + Thread.currentThread().getId() + "\t Item: " + returnLine);
            }
            catch (InterruptedException e){}
        }
    }
}
