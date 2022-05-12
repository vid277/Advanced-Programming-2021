import java.util.Date;

public class Producer extends Thread{

    private LinkListQueue<String> customerQueue;

    public Producer(){
        customerQueue = new LinkListQueue<>();
    }

    @Override
    public void run(){
        try {
            int counter = 0;
            while (counter < 100){
                Produce();
                counter++;
            }
        }
        catch (InterruptedException e){

        }
    }

    public synchronized void Produce() throws InterruptedException{
        while (customerQueue.size() == 10){
            wait();
        }
        Date date = new Date();
        customerQueue.enqueue(date.toString());
        notify();
    }

    public synchronized String Consume() throws InterruptedException {
        notify();
        while (customerQueue.size() == 0){
            wait();
        }
        String print = customerQueue.peek();
        customerQueue.dequeue();
        return print;
    }
}
