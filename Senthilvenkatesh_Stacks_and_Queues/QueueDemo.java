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
