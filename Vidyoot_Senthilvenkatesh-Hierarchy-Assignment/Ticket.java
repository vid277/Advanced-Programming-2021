/**
 * This class stores and updates the serial numbers and also prints the results
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 2/3/2022
 */
public abstract class Ticket {

    //Instance variables that contain the serial numbers
    private int serialNumber;
    private static int lastSerialNumber = 0;

    /**
     * Stores and updates the serial numbers
     * Updates the last serial number
     */
    public Ticket(){
        serialNumber = lastSerialNumber;
        lastSerialNumber++;
    }

    //Requires the get name method for all classes that extend this interface
    public abstract String getName();

    //Requires the ticket cost method for all classes that extend this interface
    public abstract double ticketCost();

    @Override
    /**
     * Returns the formatted string that contains the type of ticket, serialNumber of the ticket, and the price of the ticket
     *
     * @return the formatted string containing all the required information
     */
    public String toString() {
        return String.format("Type of ticket: %s;    Serial Number of the ticker: %d;    Price of ticket: %f;", getName(), serialNumber, ticketCost());
    }

    /**
     * This is the main method
     * Creates and adds 2 of each ticket to an array
     * Used to test the code
     */
    public static void main(String[] args){
        Ticket[] tickets = new Ticket[6];

        tickets[0] = new WalkupTicket();
        tickets[1] = new WalkupTicket();
        tickets[2] = new AdvanceTicket(5);
        tickets[3] = new AdvanceTicket(10);
        tickets[4] = new StudentAdvanceTicket(5);
        tickets[5] = new StudentAdvanceTicket(10);

        for (int i = 0; i < tickets.length; i++){
            System.out.println(tickets[i]);
        }
    }
}

