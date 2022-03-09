/**
 * This is the main menu class that displays the options to the user and allows the user to pick from a variety of options
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 3/8/2022
 */

import java.util.Arrays;
import java.util.Scanner;


public class Menu {

    //Constants that contain unsorted and sorted lists of integers
    public static final int[] ARRAY_SORTED = {-56, 0, 2, 5, 6, 12, 22, 31, 43, 49, 89, 111};
    public static final int[] ARRAY_UNSORTED = {12, 5, -56, 43, 22, 31, 2, 6, 0, 49, 111, 89};

    /**
     * Calls the menuPane method, which contains the options to display to the user.
     */
    public Menu(){
        System.out.println("______________________________________________________________");

        menuPane();
    }

    /**
     * This is the main menu method that is used to prompt the user with options to choose from
     * Calls the methods based on the user input
     * Also performs some error checking and input validity testing on the user input
     */
    public void menuPane(){
        methodOptions options = new methodOptions();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to have fun with recursion? yes/no: ");
        String userInput = scanner.nextLine();

        //Options to display to the user
        if ((userInput.equalsIgnoreCase("yes"))){
            System.out.println("______________________________________________________________");
            System.out.println("Please select one of the following: ");
            System.out.println("1. Fibonacci Sequence");
            System.out.println("2. Towers of Hanoi");
            System.out.println("3. Binary Search");
            System.out.println("4. Sum of Elements from start index to end index");
            System.out.println("______________________________________________________________");


            userInput = scanner.nextLine();

            //This entire block checks the user input and process the user input
            //Transmits the user input to the appropriate methods
            if (userInput.equals("1")){
                System.out.println("How many terms would you like in the sequence? ");
                userInput = scanner.nextLine();

                if (checkIfValid(userInput)){
                    System.out.printf("Fibonacci series upto %s numbers : \n", userInput);
                    for(int i = 1; i <= Integer.parseInt(userInput); i++) {
                        System.out.print(options.Fibonacci(i) + " ");
                    }
                    System.out.println();
                }
                menuPane();
            }

            else if(userInput.equals("2")){
                System.out.println("How many disks would you like to move? ");
                userInput = scanner.nextLine();
                if (Integer.parseInt(userInput) == 0){
                    System.out.println("Invalid input!");
                }
                else {
                    if(checkIfValid(userInput)){
                        System.out.println(options.moveDisks(Integer.parseInt(userInput), 1, 2, 3));
                        System.out.printf("It took %d moves for this Towers of Hanoi problem \n", options.getNumberOfTries());
                    }
                }
                menuPane();
            }

            else if(userInput.equals("3")){
                System.out.println("Here is the sorted int array:" + Arrays.toString(ARRAY_SORTED));
                System.out.println("Give me a number you would like to search for in the list: ");

                userInput = scanner.nextLine();

                if (checkIfValid(userInput)){
                    if  (options.binarySearch(ARRAY_SORTED, 0, ARRAY_SORTED.length-1, Integer.parseInt(userInput)) == -1){
                        System.out.println("The number is not present in the list");
                    }
                    else {
                        System.out.printf("%s was found at index %d \n", userInput, options.binarySearch(ARRAY_SORTED, 0, ARRAY_SORTED.length-1, Integer.parseInt(userInput)));
                    }
                }

                menuPane();
            }

            else if(userInput.equals("4")){
                System.out.println("Here is the int array: [12, 5, -56, 43, 22, 31, 2, 6, 0, 49, 111, 89]");
                System.out.println("Give me the start index and the end index for finding the sum:  ");
                String num1 = scanner.nextLine();
                String num2 = scanner.nextLine();


                if (checkIfValid(num1) && checkIfValid(num2)){
                    if(Integer.parseInt(num1) >= ARRAY_UNSORTED.length || Integer.parseInt(num2) >= ARRAY_UNSORTED.length) {
                        System.out.println("Error, Invalid Input");
                        menuPane();
                    }
                    else{
                        System.out.println(options.rangeSum(ARRAY_UNSORTED, Integer.parseInt(num1), Integer.parseInt(num2)+1));
                    }
                }
                    menuPane();
                }

            else {
                System.out.println("Invalid Input");
                menuPane();
            }
        }
        else if (userInput.equalsIgnoreCase("no")){
            System.out.println("Thanks for using recursion with me! ");
        }
        else {
            System.out.println("Invalid Input");
            menuPane();
        }
    }

    /**
     * This is used by all the options to ensure that the user options do not contain letters
     *
     * @param userInput - The string input by the user
     * @return boolean - true if the user inputs only digits, false otherwise
     */
    public boolean checkIfValid(String userInput){

        boolean isValid = false;

        //Used to account for the possibility of a negative number
        if (userInput.startsWith("-")){
            isValid = true;
        }
        else{
            for (int i = 0; i < userInput.length(); i++){
                if (Character.isDigit(userInput.charAt(i))){
                    isValid = true;
                }
                else{
                    isValid = false;
                    System.out.println("Invalid Input");
                    menuPane();
                    break;
                }
            }
        }

        return isValid;
    }

    /**
     * This is the main method, and it is used to create an object of the Menu class
     *
     * @param args
     */
    public static void main(String[] args){
        new Menu();
    }
}
