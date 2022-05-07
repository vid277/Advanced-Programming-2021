/**
 Should a local bank add a second machine?

 The local bank should add a second machine because at the end of 60 minutes, on average 6 customers were left in the queue.
 After analyzing 10 simulation runs, there was a customer left in the queue 8/10 times. This number could be decreased by adding another ATM machine.
 The average wait times were also fairly high, with an average wait time of 7 minutes. This impacted the number of people left at the end of the queue.
 By adding another ATM machine, the number of customers left at the end of the queue and the average wait time for each customer could be reduced significantly.
 Adding another ATM will also allow a greater number of customers to be served over the course of an hour.
 This simulation showed that another ATM will be useful and should be implemented to further improve their service by reducing their customer waiting times
 and reducing the number of customers that are left in the queue at the end of an hour.
 */

/**
 * This is the QueueDemo class that helps simulate ATMs
 * @author Vidyoot Senthilvenkatesh
 * @date 5/7/2022
 */
public class QueueDemo {

    /**
     * This creates an object of the ATMSimulation class and simulates the ATMs
     */
    public QueueDemo(){
        //This is the ATM simulation
        ATMSimulation<Customer> simulate = new ATMSimulation<Customer>();
        simulate.simulate();
    }

    /**
     * This is the main method that is used to create an object of the queue demo class
     * @param args
     */
    public static void main(String[] args){
        new QueueDemo();
    }
}
