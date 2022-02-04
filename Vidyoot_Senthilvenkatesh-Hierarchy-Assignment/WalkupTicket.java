import java.util.Random;

public class WalkupTicket extends Ticket {

    public WalkupTicket(){
        Random random = new Random();
        int serialNumber = 0;

        serialNumber = random.nextInt(100, 1000);

        if (getLastSerialNumber() == serialNumber){
            while (getLastSerialNumber() == serialNumber) {
                serialNumber = random.nextInt(100, 1000);
            }
        }
    }

    public void ticketCost() {

    }

    public String getName() {
        return null;
    }
}
