/**
 * This is the customer class that is supposed to simulate customers
 * @author Vidyoot Senthilvenkatesh
 * @date 5/7/2022
 */
public class Customer {
    //The time at which they arrive at
    private int arrivalTime;

    //The time at which they get serviced
    private int serviceTime;

    //the customer name
    private String name;

    //An empty constructor
    public Customer(){}

    /**
     * Creates a new customer
     * @param value the time at which they arrive at
     * @param name the name of the customer
     */
    public Customer(int value, String name){
        this.name = name;
        setArrival(value);
    }

    /**
     * Sets the time that the customer arrives at
     * @param ArrivalTime the time that the customer arrives at
     */
    public void setArrival(int ArrivalTime){
        arrivalTime = ArrivalTime;
    }

    /**
     * Returns the time that the customer arrives at
     * @return
     */
    public int getArrivalTime(){
        return arrivalTime;
    }

    /**
     * Sets the time that the customer gets serviced at
     * @param ServiceTime the time that the customer gets serviced at
     */
    public void setServiceTime(int ServiceTime){
        serviceTime = ServiceTime;
    }

    /**
     * Returns the time that the customer gets serviced at
     * @return the time that the customer gets serviced at
     */
    public int getServiceTime(){
        return serviceTime - getArrivalTime();
    }

    /**
     * Returns the name of the customer
     * @return
     */
    public String getName(){
        return name;
    }
}
