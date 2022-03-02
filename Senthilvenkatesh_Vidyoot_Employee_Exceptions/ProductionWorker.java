import java.util.Date;

public class ProductionWorker extends Employee{
    private String shift;
    private double hourlyPayRate;

    public ProductionWorker(String employeeName, String employeeNumber, Date hiredDate) throws InvalidEmployeeNumber {
        super(employeeName, employeeNumber, hiredDate);
    }

    public String getShift() {
        return shift;
    }

    public void setShift(int shift) throws InvalidShift {
        if(shift == 1){
            this.shift = "Day";
        }
        else if (shift == 2){
            this.shift = "Night";
        }
        else {
            throw new InvalidShift(
                    "Invalid Shift Number! Must be either 1 or 2. User input: ", shift
            );
        }
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) throws InvalidPayRate {
        if (hourlyPayRate >= 0){
            this.hourlyPayRate = hourlyPayRate;
        }
        else {
            throw new InvalidPayRate("Pay rate cannot be negative! Must be positive. User Input: ", hourlyPayRate);
        }
    }
}
