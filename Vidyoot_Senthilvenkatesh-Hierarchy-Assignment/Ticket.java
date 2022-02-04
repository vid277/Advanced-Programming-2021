public abstract class Ticket {

    private int serialNumber;
    private static int lastSerialNumber;

    public Ticket(){
        serialNumber = 0;
        lastSerialNumber = 102;
    }

    public abstract void ticketCost();

    public int getSerialNumber(){
        return serialNumber;
    }

    public int getLastSerialNumber(){
        return lastSerialNumber;
    }

    public void setLastSerialNumber(int lastSerialNumber){
        this.lastSerialNumber = lastSerialNumber;
    }

    public void setSerialNumber(int serialNumber){
        this.serialNumber = serialNumber;
    }

    public String toString(String name, int SerialNumber, int price) {
        System.out.printf("Type of ticket: %s;    Serial Number of the ticker: %d;    Price of ticket: %d", name, SerialNumber, price);
        return "";
    }

}

