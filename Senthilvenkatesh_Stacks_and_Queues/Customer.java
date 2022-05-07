public class Customer {
    public int arrivalTime;
    public int serviceTime;
    public String name;

    public Customer(){}

    public Customer(int value, String name){
        this.name = name;
        setArrival(value);
    }

    public void setArrival(int ArrivalTime){
        arrivalTime = ArrivalTime;
    }

    public int getArrivalTime(){
        return arrivalTime;
    }

    public void setServiceTime(int ServiceTime){
        serviceTime = ServiceTime;
    }

    public int getServiceTime(){
        return serviceTime - arrivalTime;
    }

    public String getName(){
        return name;
    }
}
