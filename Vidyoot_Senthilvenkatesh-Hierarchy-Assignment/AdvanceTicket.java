/**
 * This class extends the Ticket class and calculates the price of the Advance Booked ticket
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 2/3/2022
 */
public class AdvanceTicket extends Ticket {

    //Stores the number of days in advance the ticket was booked
    public int Numberofdays;

    /**
     * This method stores the number of days in advance the ticket is booked
     */
    public AdvanceTicket(int NumberOfDays) {
        Numberofdays = NumberOfDays;
    }

    /**
     * Calculates the price of the ticket based on the number of days in advance the ticket is booked
     *
     * @return the price of the ticket
     */
    @Override
    public double ticketCost() {
        if (Numberofdays >= 10) {
            return 30.0;
        } else {
            return 40.0;
        }
    }

    /**
     * This class returns the type of the ticket
     *
     * @return the type of the ticket
     */
    @Override
    public String getName() {
        return "Advance Ticket";
    }
}
