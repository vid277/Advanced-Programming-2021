import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
    private String employeeName;
    private String employeeNumber;
    private Date hiredDate;

    public Employee(String employeeName, String employeeNumber, Date hiredDate) throws InvalidEmployeeNumber {
        setEmployeeName(employeeName);
        setEmployeeNumber(employeeNumber);
        setHiredDate(hiredDate);
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) throws InvalidEmployeeNumber {
        if (employeeNumber != null){
            Pattern pattern = Pattern.compile("\\d\\d\\d-[A-M]");
            Matcher matchPattern = pattern.matcher(employeeNumber);
            boolean match = matchPattern.matches();

            if(match){
                this.employeeNumber = employeeNumber;
            }
            else {
                throw new InvalidEmployeeNumber("Incorrect Employee Number Format: ", employeeNumber);
            }
        }
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }
}
