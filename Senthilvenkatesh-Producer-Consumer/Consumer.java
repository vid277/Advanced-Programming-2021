public class Consumer extends Thread{
    private Producer producer;

    public Consumer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        try{
            int counter = 0;
            while (counter < 100) {
                String storeData = producer.Consume();
                System.out.println("Consumer: " + Thread.currentThread().getName() + "\t Item: " + storeData);
                counter++;
            }
        } catch (Exception e){}
    }
}
