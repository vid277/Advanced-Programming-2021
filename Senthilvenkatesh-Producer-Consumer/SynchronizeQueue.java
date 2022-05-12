import java.util.Scanner;

public class SynchronizeQueue {
    public static void main(String[] args){

        System.out.println("Input the number of producer and consumer threads: ");
        Scanner scanner = new Scanner(System.in);
        int threadInputProducer = scanner.nextInt();

        if (threadInputProducer > 0){
            for (int i = 0; i < threadInputProducer; i++){
                Producer producer = new Producer();
                Consumer consumer = new Consumer(producer);
                producer.start();
                consumer.start();
            }
        }
    }
}
