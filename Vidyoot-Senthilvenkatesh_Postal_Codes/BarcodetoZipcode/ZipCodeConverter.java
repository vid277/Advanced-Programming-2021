
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class converts 5-digit zipcodes into barcodes, and barcodes back into 5-digit zipcodes
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 1/22/2022
 */
public class ZipCodeConverter {

    //The scannerInput variable uses the Scanner to get input from the user
    private Scanner scannerInput;

    /*
     * This Hashmap stores the specific code-patterns for each number
     * The number (Integer) is the key
     * The barcode (associated with each number(String) is the value
     */
    private static HashMap<Integer, String> storeConversion;

    /*
     * Initializes Scanner and the Hashmap
     * Adds all the numbers and their barcodes to the hashmap
     */
    public ZipCodeConverter() {
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


        //Calls the method that displays options and prompts the user for input
        beginOptions();
    }

    /*
     * This method displays options and gets input from the user using the scanner class
     * This method runs until the user inputs a valid option, or the user decides to exit
     * Calls the convertToZipcode or convertToBars methods based on user input
     */
    private void beginOptions() {
        boolean isRunning = true;

        System.out.println();
        System.out.println("Welcome to zipcode converter! Choose an option!");

        while (isRunning) {
            String optionsInput = "";

            //Initial menu options
            System.out.println("------------------------------");
            System.out.println("1) Convert a zipcode to bars");
            System.out.println("2) Convert bars to zipcode");
            System.out.println("3) Exit");
            System.out.println("------------------------------");
            System.out.println("Choose an option: ");

            //Scans the first option input by the user
            optionsInput = scannerInput.nextLine();

            //Makes sure that the user inputs something
            if (optionsInput.equals("")) {
                System.out.println("Enter a valid option!");

            } else if (optionsInput.equals("1")) {
                System.out.println("Enter a zipcode: ");
                String zip = String.valueOf(getNumber(scannerInput));
                if (zip.length() != 5){
                    System.out.println("Enter a valid zipcode!");
                }
                else {
                    convertToBars(zip);
                    isRunning = false;
                }
            } else if (optionsInput.equals("2")) {
                System.out.println("Enter bars: ");
                String enteredValue = scannerInput.nextLine();

                //Making sure that bars are input by the user
                if (enteredValue.equals("")){
                    System.out.println("Nothing Input. Input a barcode!");
                }
                else if (enteredValue.substring(0, 1).equals("|")) {
                    convertToZipcode(enteredValue);
                    isRunning = false;
                } else {
                    System.out.println("Enter valid bars!");
                }

            } else if (optionsInput.equals("3")) {
                //Choosing to exit the game
                System.out.println("Bye, thank you for using this program!");
                isRunning = false;

            } else {
                //If the user does not input a valid option
                System.out.println("Not a valid input!");
            }
        }
    }

    /*
     * Converts the 5-digit zipcode input by the user into a barcode that takes
     * the zipcode input by the user as input.
     *
     * @param userInputZipcode - The zipcode input by the user
     */
    private void convertToBars(String userInputZipcode) {
        String zipcode = userInputZipcode;
        int checkDigit = 0;
        String finalString = "|";
        int sum = 0;

        // Finds the sum of all the digits in the zipcode
        for (int x = 0; x < zipcode.length(); x++) {
            sum += Integer.parseInt(zipcode.substring(x, x + 1));
        }

        // Makes sure that the number does not produce a remainder of zero
        if (sum % 10 == 0) {
            checkDigit = 11;
        } else {
            // Used to calculate the check digit
            // The check digit tells how far the sum is a number is from the closest multiple of 10
            checkDigit = (10 - sum % 10);
        }

        // Used the numbers as key to retrieve values from the HashMap
        // Uses the substring method to split the zipcode
        // Concatenated these strings to form a large barcode
        for (int i = 0; i < zipcode.length(); i++) {
            finalString = finalString + storeConversion.get(Integer.parseInt(zipcode.substring(i, i + 1)));
        }

        //Adds the "|" at the end to complete the barcode.
        finalString = finalString + storeConversion.get(checkDigit) + "|";
        System.out.println("Your bars are: " + finalString);
    }

    /*
     * Converts the barcode input by the user into a 5-digit zipcode
     *
     * @param userInputBars - The barcode input by the user
     */
    private void convertToZipcode(String userInputBars) {
        ArrayList<String> splitBarCodes = new ArrayList<>();
        String userInputs = userInputBars;
        
        //Removes the "|" of both of the ends of the barcode
        if (userInputBars.length() > 2){
            userInputs = userInputBars.substring(1, userInputBars.length() - 1);
        }
        
        String finalZipcode = "";

        //Makes sure that the barcode is a multiple of 5
        //If it is not a multiple of 5, it outputs an error
        //It calls the beginOptions method, to again display menu options
        if (userInputs.length() % 5 == 0) {
            int counter = 0;

            //splits the barcode input by 5s
            //Adds each of these barcodes to an ArrayList
            for (int i = 0; i < (userInputs.length() / 5); i++) {
                splitBarCodes.add(userInputs.substring(counter, counter + 5));
                counter += 5;
            }
        } else {
            System.out.println("Error. Incorrect barcode length.");
            beginOptions();
        }


        //Gets the number values associated with these barcodes
        //Concatenates these numbers
        for (String numbers : splitBarCodes) {
            for (Map.Entry<Integer, String> entry : storeConversion.entrySet()) {
                if (numbers.equals(entry.getValue())) {
                    finalZipcode = finalZipcode + (entry.getKey()).toString();
                }
            }
        }

        //Removes the Check Digit
        finalZipcode = finalZipcode.substring(0, finalZipcode.length() - 1);

        //Makes sure that the length of the zipcode is 5, if the length of the
        //- zipcode is less than 5, it means that certain bar patterns could not be found
        if (finalZipcode.length() != 5) {
            System.out.println("Not a valid zipcode. Code not find these bars.");
        } else {
            System.out.println("The zipcode is: " + finalZipcode);
        }
    }

    //Makes sure that the values input by the user are numbers
    //If they are not numbers, it ouputs an error
    private int getNumber(Scanner input) {
        while (true) {
            try { return Integer.valueOf(input.nextLine()); }
            catch (NumberFormatException e) {}
            System.out.println("That wasn't a valid number");
            beginOptions();
        }
    }
}
