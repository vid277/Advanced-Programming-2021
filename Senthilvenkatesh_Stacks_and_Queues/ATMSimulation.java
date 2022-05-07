/**
 * This class is used to simulate the ATM traffic
 * @author Vidyoot Senthilvenkatesh
 * @date 5/7/2022
 * @param <T> the type to simulate
 */
public class ATMSimulation <T> {

    //the time before an ATM is available
    public int ATMisAvailable;

    //The number of people that arrive at the atm
    public int numArrivals;

    //The total waiting time for the customers
    public int totalWaitingTime;

    //The number of customers that have been served
    public int numCustomersServed;

    //This contains the queue for the customers
    public LinkListQueue<Customer> list = new LinkListQueue<Customer>();

    /**
     * Initializes all the variables to 0 when the simulator is created
     * Assumes that the ATM is available when the simulation begins and that no customers are waiting.
     */
    public ATMSimulation(){
        numArrivals = 0;
        totalWaitingTime = 0;
        numCustomersServed = 0;
        ATMisAvailable = 0;
    }

    /**
     * During any minute, returns the number of customers that arrive
     * @return the number of customers that arrive at any minute
     */
    public int getArrival(){
        //Generates a random from 0 to 10
        int randomNum = (int)(Math.random()*10);

        /**
         * During any minute:
         * no customers arrive	(50% chance),
         * one customer arrives	(40% chance),
         * or two customers arrive	(10% chance).
         */
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

    /**
     * At the end of an hour, the following summary statistics:
     * the number of customers served
     * the average time a customer waits in line before being served
     * the number of customers that remain in the waiting line at the end of the simulation.
     */
    public void displayStatistics(){
        System.out.println("*******************************************************************");
        System.out.printf("Number of customers served during an hour: %d\n", numCustomersServed);
        System.out.printf("Average wait during an hour is about: %d minute\n", (int)(totalWaitingTime/numCustomersServed));
        System.out.printf("Numbers of customers left in a queue at the end of an hour: %d \n", list.size());
        System.out.println("Names of customers left in a queue at the end of an hour: ");

        //Prints out the name of each customer that is left at the end of an hour
        while (!list.isEmpty()){
            System.out.printf("%s ", (list.peek()).getName());
            list.dequeue();
        }

        System.out.println("");
        System.out.println("*******************************************************************");
    }

    /**
     * This is the method that primarily simulates the customers arriving at getting served
     */
    public void simulate(){
        //The current customer number
        int counter = 0;

        //Ticks through a sixty minute simulation.
        for (int i = 0; i < 59; i++){

            //Adds a random number of people to the queue
            for (int j = 0; j < getArrival(); j++){
                counter++;

                //The name of each customer
                String name = "C" + (counter);

                //Adds each customer to the queue
                list.enqueue(new Customer(i, name));
            }

            //If there are customers waiting and the ATM is available, this code is run
            if (!(list.isEmpty()) && ATMisAvailable == 0){
                //The time that the customer has to wait between atm uses
                int waitTime = (int) (Math.random() * 3) + 1;

                //Sets the time at which the customer is being serviced
                list.peek().setServiceTime(i);

                //The total duration that the customer has to wait between arrivalTime and getting serviced
                totalWaitingTime += list.peek().getServiceTime();

                //Removes the customer from the list
                list.dequeue();

                //Increases the number of customers served
                numCustomersServed++;

                //Increments the time that the customer has to wait between ATM uses
                ATMisAvailable += waitTime;
            }

            //Makes sure that the duration between ATM uses does not go below 0
            if (ATMisAvailable <= 0){
                ATMisAvailable = 0;
            } else {
                //Reduces the remaining duration that the customer has to wait
                ATMisAvailable--;
            }
        }
        //Displays the final statics at the end of an hour
        displayStatistics();
    }
}
