/**
 * This class extends the AdvanceTicket class and calculates the price of the Advance Student Booked ticket
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 2/3/2022
 */
public class StudentAdvanceTicket extends AdvanceTicket {

    public StudentAdvanceTicket(int NumberOfDays) {
        super(NumberOfDays);
    }

    /**
     * This class returns the cost of the advance student ticket
     *
     * @return the cost of the advance Student Booked ticket
     */
    @Override
    public double ticketCost() {
        return (super.ticketCost()) / 2;
    }

    /**
     * This class returns the type of the ticket
     *
     * @return the type of the ticket
     */
    @Override
    public String getName() {
        return "Student Advance Ticket";
    }
}
