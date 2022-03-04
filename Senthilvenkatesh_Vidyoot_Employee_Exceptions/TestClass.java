import java.util.Date;

public class TestClass {
    ProductionWorker[] workers = new ProductionWorker[5];
    int numberOfEmployees = 0;

    public TestClass() throws InvalidEmployeeNumber, InvalidShift, InvalidPayRate {

        try {
            try{
                try{
                    workers[0] = new ProductionWorker("Jack", "122-B", new Date(1 / 24 / 2022), 1, 5.28);
                    workers[1] = new ProductionWorker("Josh", "120-A", new Date(1 / 24 / 2022), 2, 12.29);
                    workers[2] = new ProductionWorker("John", "121-M", new Date(1 / 25 / 2022), 1, 19.29);
                    workers[3] = new ProductionWorker("Jasmine", "119-z", new Date(1 / 24 / 2022), 5, -12.98);
                } catch (InvalidShift e) {
                    System.out.println(e);
                }
            } catch (InvalidPayRate x){
                System.out.println(x);
            }
        } catch (InvalidEmployeeNumber z) {
            System.out.println(z);
        }

        testMethod();
    }

    public void testMethod() {
        for (int i = 0; i < workers.length; i++) {
            //System.out.printf("Name: %s; ID Number: %s; Date Hired: %s; Shift: %s; Hourly Pay Rate: %f; \n", workers[i].getEmployeeName(), workers[i].getEmployeeNumber(), (workers[i].getHiredDate()).toString().substring(0, 10), workers[i].getShift(), workers[i].getHourlyPayRate());
            System.out.println(workers[i]);
        }
    }

    public static void main(String[] args) throws InvalidShift, InvalidPayRate, InvalidEmployeeNumber {
        new TestClass();
    }
    }
