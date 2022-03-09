import java.util.Arrays;
import java.util.Scanner;


public class Menu {
    public static final int[] arraySorted = {-56, 0, 2, 5, 6, 12, 22, 31, 43, 49, 89, 111};
    public static final int[] arrayUnsorted = {12, 5, -56, 43, 22, 31, 2, 6, 0, 49, 111, 89};

    public Menu(){
        System.out.println("______________________________________________________________");

        menuPane();
    }

    public void menuPane(){
        methodOptions options = new methodOptions();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to have fun with recursion? yes/no: ");
        String userInput = scanner.nextLine();

        if ((userInput.equalsIgnoreCase("yes"))){
            System.out.println("______________________________________________________________");
            System.out.println("Please select one of the following: ");
            System.out.println("1. Fibonacci Sequence");
            System.out.println("2. Towers of Hanoi");
            System.out.println("3. Binary Search");
            System.out.println("4. Sum of Elements from start index to end index");
            System.out.println("______________________________________________________________");


            userInput = scanner.nextLine();

            if (userInput.equals("1")){
                System.out.println("How many terms would you like in the sequence? ");
                userInput = scanner.nextLine();

                if (checkIfValid(userInput)){
                    System.out.println("The final value is: " + options.Fibonacci(Integer.parseInt(userInput)));
                }

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
                        System.out.printf("It took %d moves for this Towers of Hanoi problem", options.getNumberOfTries());
                    }
                }
            }

            else if(userInput.equals("3")){
                System.out.println("Here is the sorted int array:" + Arrays.toString(arraySorted));
                System.out.println("Give me a number you would like to search for in the list: ");

                userInput = scanner.nextLine();

                if (checkIfValid(userInput)){
                    if  (options.binarySearch(arraySorted, 0, arraySorted.length-1, Integer.parseInt(userInput)) == -1){
                        System.out.println("The number is not present in the list");
                    }
                    else {
                        System.out.println("The index is: " + options.binarySearch(arraySorted, 0, arraySorted.length-1, Integer.parseInt(userInput)));
                    }
                }
            }

            else if(userInput.equals("4")){
                System.out.println("Here is the int array: [12, 5, -56, 43, 22, 31, 2, 6, 0, 49, 111, 89]");
                System.out.println("Give me the start index and the end index for finding the sum:  ");
                String num1 = scanner.nextLine();
                String num2 = scanner.nextLine();


                if (checkIfValid(num1) && checkIfValid(num2)){
                    if(Integer.parseInt(num1) >= arrayUnsorted.length || Integer.parseInt(num2) >= arrayUnsorted.length) {
                        System.out.println("Error, Invalid Input");
                        menuPane();
                    }
                    else{
                        System.out.println(options.rangeSum(arrayUnsorted, Integer.parseInt(num1), Integer.parseInt(num2)+1));
                    }
                }

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

    public boolean checkIfValid(String userInput){

        boolean isValid = false;

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

        return isValid;
    }
    public static void main(String[] args){
        new Menu();
    }
}
