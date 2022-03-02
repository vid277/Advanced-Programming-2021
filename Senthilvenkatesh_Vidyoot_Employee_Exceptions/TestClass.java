import java.util.Date;

public class TestClass {
    ProductionWorker[] workers = new ProductionWorker[5];
    int numberOfEmployees = 0;

    public TestClass() throws InvalidEmployeeNumber, InvalidShift, InvalidPayRate {

        try {

            workers[0] = new ProductionWorker("Jack", "122-B", new Date(1 / 24 / 2022));
            workers[1] = new ProductionWorker("Josh", "120-A", new Date(1 / 24 / 2022));
            workers[2] = new ProductionWorker("John", "121-M", new Date(1 / 25 / 2022));
            workers[3] = new ProductionWorker("Jasmine", "119-z", new Date(1 / 24 / 2022));
            workers[4] = new ProductionWorker("Shawn", "1242-M", new Date(1 / 24 / 2022));
        } catch (InvalidEmployeeNumber z) {
            System.out.println(z);
        }

        try {
            workers[0].setShift(1);
            workers[1].setShift(2);
            workers[2].setShift(1);
            workers[3].setShift(4);
            workers[4].setShift(5);
        } catch (InvalidShift x) {
            System.out.println(x);
        }

        try{
            workers[0].setHourlyPayRate(16.29);
            workers[1].setHourlyPayRate(12.92);
            workers[2].setHourlyPayRate(14.53);
            workers[3].setHourlyPayRate(-5.23);
            workers[4].setHourlyPayRate(-1.12);
        } catch (InvalidPayRate e) {
            System.out.println(e);
        }

        testMethod();
    }

    public void testMethod(){
        for (int i = 0; i < workers.length; i++) {
            System.out.printf("Name: %s; ID Number: %s; Date Hired: %s; Shift: %s; Hourly Pay Rate: %f; \n", workers[i].getEmployeeName(), workers[i].getEmployeeNumber(), (workers[i].getHiredDate()).toString().substring(0,10), workers[i].getShift(), workers[i].getHourlyPayRate());
        }
    }

    public static void main(String[] args) throws InvalidShift, InvalidPayRate, InvalidEmployeeNumber {
        new TestClass();
    }
    }
