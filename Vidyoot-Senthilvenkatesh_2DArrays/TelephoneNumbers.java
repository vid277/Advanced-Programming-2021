/**
 * Converts the alphabetic characters of a telephone number into their numeric equivalent.
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 2/13/2022
 */
import java.util.Scanner;
public class TelephoneNumbers {

    public Scanner scanner = new Scanner(System.in);

    //This is similar to a hashmap, and it stores the numeric values and their corresponding values
    public static char[][] conversions = {
            {'A', '2'},
            {'B', '2'},
            {'C', '2'},
            {'D', '3'},
            {'E', '3'},
            {'F', '3'},
            {'G', '4'},
            {'H', '4'},
            {'I', '4'},
            {'J', '5'},
            {'K', '5'},
            {'L', '5'},
            {'M', '6'},
            {'N', '6'},
            {'O', '6'},
            {'P', '7'},
            {'Q', '7'},
            {'S', '7'},
            {'T', '8'},
            {'U', '8'},
            {'W', '9'},
            {'X', '9'},
            {'Y', '9'},
            {'Z', '9'},
    };


    /**
     * This serves as a main menu, and is used receive input from the user.
     */
    public TelephoneNumbers(){
        boolean isLive = true;

        while (isLive) {
            System.out.println("-----------------------------------------------");
            System.out.println("Input a 10 digit telephone number:");

            String input = ((scanner.nextLine()).replace("-", "")).toUpperCase();

            if (input.length() == 10) {
                checkNumbers(input.toCharArray());
            }
            else{
                System.out.println("Invalid Input!");
            }
        }
    }

    /**
     * This method is used to convert the alphabets in the telephone numbers into their numeric equivalent.
     *
     * @param userInput the character array containing the input from the user.
     */
    public void checkNumbers(char[] userInput) {

        for (int i = 0; i < conversions.length; i++) {
            for (int x = 0; x < userInput.length; x++) {
                if (conversions[i][0] == userInput[x]) {
                    userInput[x] = conversions[i][1];
                }
            }
        }

        System.out.println("The telephone number is: " + String.valueOf(userInput));
    }


    /**
     * This is the main method that creates an object of the TelephoneNumbers class.
     *
     * @param args
     */
    public static void main(String[] args){
        TelephoneNumbers telephone = new TelephoneNumbers();
    }
}
