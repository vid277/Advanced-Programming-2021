import java.util.Scanner;

public class ZipCodeConverter {
    
    private Scanner scannerInput;

    public ZipCodeConverter(){
        boolean isRunning = true;

        scannerInput = new Scanner(System.in);

        System.out.println("Welcome to zipcode converter! Choose an option!");

        while (isRunning){
            String optionsInput = "";

            System.out.println();
            System.out.println("------------------------------");
            System.out.println("1) Convert a zipcode to bars");
            System.out.println("2) Convert bars to zipcode");
            System.out.println("3) Exit");
            System.out.println("------------------------------");
            System.out.println("Choose an option: ");

            scannerInput = new Scanner(System.in);

            optionsInput = scannerInput.nextLine();

            if (optionsInput.equals("")){
                System.out.println("Enter a zipcode!");
            }
            else if (optionsInput.equals("1")){
                System.out.println("Enter a zipcode: ");

                String enteredValue = scannerInput.nextLine();

                if (enteredValue.length() != 5 || !Character.isDigit(enteredValue.charAt(0))){
                    System.out.println("Error! Enter a valid zipcode!"); 
                }
                else {
                    convertToBars(enteredValue);
                    isRunning = false;
                }
            }
            else if (optionsInput.equals("2")){
                System.out.println("Enter bars: ");
                String enteredValue = scannerInput.nextLine();

                if (enteredValue.substring(0, 1).equals("|")){
                    convertToZipcode(enteredValue); 
                    isRunning = false;
                }
                else {
                    System.out.println("Enter valid bars!");
                }
            }
            else if (optionsInput.equals("3")){
                System.out.println("Bye, thank you for using this program!");
                isRunning = false;
            }
            else {
                System.out.println("Not a valid input!");
            }
        }
    }

    private void convertToBars(String userInputZipcode) {
        int zipcode = Integer.parseInt(userInputZipcode);
    }
    
    private void convertToZipcode(String userInputBars) {

    }
}
