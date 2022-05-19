import java.util.Scanner;

/**
 * This is the main class that creates and starts each of the threads.
 * Also contains the main customer queue
 * @author Vidyoot Senthilvenkatesh
 * @date 5/18/2022
 */
public class SynchronizeQueue {

    /**
     * This is the main method that creates and starts the threads
     * @param args
     */
    public static void main(String[] args){
        //This is the shared linked list that is utilized by the customer and producer class.
        LinkListQueue<String> customerQueue = new LinkListQueue<String>();

        //Takes an input from the user for the number of producers and consumers.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of producers: ");
        int threadInputProducer = scanner.nextInt();
        System.out.println("Input the number of consumers: ");
        int threadInputConsumer = scanner.nextInt();

        //Makes sure that the values input by the user are valid
        if (threadInputProducer > 0 && threadInputConsumer > 0){

            //Creates and starts the producer threads for the number input by the user.
            for (int i = 0; i < threadInputProducer; i++){
                Thread producer = new Producer(customerQueue);
                producer.start();
            }

            //Creates and starts the consumer threads for the number input by the user.
            for (int x = 0; x < threadInputConsumer; x++){
                Thread consumer = new Consumer(customerQueue);
                consumer.start();
            }
        }
    }
}
