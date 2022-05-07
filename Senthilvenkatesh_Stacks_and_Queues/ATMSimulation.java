public class ATMSimulation <T>  {
    public int ATMisAvailable;
    public int numArrivals;
    public int totalWaitingTime;
    public int numCustomersServed;
    public LinkListQueue<Customer> list = new LinkListQueue<Customer>();

    public ATMSimulation(){
        numArrivals = 0;
        totalWaitingTime = 0;
        numCustomersServed = 0;
        ATMisAvailable = 0;
    }

    public int getArrival(){
        int randomNum = (int)(Math.random()*10);
        if (randomNum == 0||randomNum == 1||randomNum == 2||randomNum == 3||randomNum == 4){
            numArrivals = 0;
        }
        else if (randomNum == 5||randomNum == 6||randomNum == 7||randomNum == 8){
            numArrivals = 1;
        }
        else if (randomNum == 9){
            numArrivals = 2;
        }

        return numArrivals;
    }

    public void displayStatistics(){
        System.out.println("*******************************************************************");
        System.out.printf("Number of customers served during an hour: %d\n", numCustomersServed);
        System.out.printf("Average wait during an hour is about: %d minute\n", (int)(totalWaitingTime/numCustomersServed));
        System.out.printf("Numbers of customers left in a queue at the end of an hour: %d \n", list.size());
        System.out.println("Names of customers left in a queue at the end of an hour: ");
        while (!list.isEmpty()){
            System.out.printf("%s ", (list.peek()).getName());
            list.dequeue();
        }
        System.out.println("");
        System.out.println("*******************************************************************");
    }

    public void simulate(){
        int counter = 0;
        for (int i = 0; i < 59; i++){
            for (int j = 0; j < getArrival(); j++){
                counter++;
                String name = "C" + (counter);
                list.enqueue(new Customer(i, name));
            }

            if (!(list.isEmpty()) && ATMisAvailable == 0){
                int waitTime = (int) (Math.random() * 3) + 1;

                list.peek().setServiceTime(i);
                totalWaitingTime += list.peek().getServiceTime();
                list.dequeue();
                numCustomersServed++;

                ATMisAvailable += waitTime;
            }

            if (ATMisAvailable <= 0){
                ATMisAvailable = 0;
            } else {
                ATMisAvailable--;
            }
        }
        displayStatistics();
    }
}
