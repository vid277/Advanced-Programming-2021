/**
 * This class extends the abstract class ticket and returns the price of the walk-up Ticket
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 2/3/2022
 */
public class WalkupTicket extends Ticket {

    /**
     * This class returns the price of the walk-up ticket
     *
     * @return the price of the walk-up ticket
     */
    public double ticketCost() {
        return 50.0;
    }

    /**
     * This class returns the type of the ticket
     *
     * @return the type of the ticket
     */
    public String getName() {
        return "Walk-up Ticket";
    }
}
