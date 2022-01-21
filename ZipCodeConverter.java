import java.util.HashMap;
import java.util.Scanner;

public class ZipCodeConverter {

    private Scanner scannerInput;
    private static HashMap<Integer, String> storeConversion;

    public ZipCodeConverter() {
        boolean isRunning = true;

        scannerInput = new Scanner(System.in);
        storeConversion = new HashMap<>();

        //Adding all values to the hashmap
        storeConversion.put(1, ":::||");
        storeConversion.put(2, "::|:|");
        storeConversion.put(3, "::|||");
        storeConversion.put(4, ":|:::");
        storeConversion.put(5, ":|:||");
        storeConversion.put(6, ":||::");
        storeConversion.put(7, "|::::");
        storeConversion.put(8, "|::||");
        storeConversion.put(9, "|:|::");
        storeConversion.put(0, "||:::");
        storeConversion.put(11, "||:::||:::");

        System.out.println("Welcome to zipcode converter! Choose an option!");

        while (isRunning) {
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

            if (optionsInput.equals("")) {
                System.out.println("Enter a zipcode!");
            } else if (optionsInput.equals("1")) {
                System.out.println("Enter a zipcode: ");

                String enteredValue = scannerInput.nextLine();

                if (enteredValue.length() != 5 || !Character.isDigit(enteredValue.charAt(0))) {
                    System.out.println("Error! Enter a valid zipcode!");
                } else {
                    convertToBars(enteredValue);
                    isRunning = false;
                }
            } else if (optionsInput.equals("2")) {
                System.out.println("Enter bars: ");
                String enteredValue = scannerInput.nextLine();

                if (enteredValue.substring(0, 1).equals("|")) {
                    convertToZipcode(enteredValue);
                    isRunning = false;
                } else {
                    System.out.println("Enter valid bars!");
                }

            } else if (optionsInput.equals("3")) {
                System.out.println("Bye, thank you for using this program!");
                isRunning = false;
            } else {
                System.out.println("Not a valid input!");
            }
        }
    }

    private void convertToBars(String userInputZipcode) {
        String zipcode = userInputZipcode;
        int checkDigit = 0;
        String finalString = "|";
        int sum = 0;

        for (int x = 0; x < zipcode.length(); x++){
            sum += Integer.parseInt(zipcode.substring(x, x + 1));
        }

        if (sum%10 == 0){
            checkDigit = 11;
        }
        else{
            checkDigit = (10 - sum%10);
        }

        for (int i = 0; i < zipcode.length(); i++) {
            finalString = finalString + storeConversion.get(Integer.parseInt(zipcode.substring(i, i + 1)));
        }

        finalString = finalString + storeConversion.get(checkDigit) + "|";
        System.out.println("Your bars are: " + finalString);
    }

    private void convertToZipcode (String userInputBars){

    }
}
