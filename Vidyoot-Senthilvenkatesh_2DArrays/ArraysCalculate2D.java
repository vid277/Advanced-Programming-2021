import java.util.Random;

/**
 * This is an exercise with 2D arrays. This class calculates the total, average, total in a column,
 * total in a row, highest in a row, number of elements, and the lowest in a row.
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 2/13/2022
 */
public class ArraysCalculate2D {
    public Random rand = new Random();

    public double[][] randomArray;

    public ArraysCalculate2D(){
        int randomSize = rand.nextInt(1, 2) + 5;
        randomArray = new double[randomSize][randomSize];

        //Prints out the 2D array
        for (int i = 0; i < randomArray.length; i++){
            for (int x = 0; x < randomArray.length; x++){
                randomArray[i][x] = rand.nextDouble(0, 100);
                System.out.print(randomArray[i][x]+" ");
            }
            System.out.println();
        }
    }

    /**
     * This method calculates the sum of all the elements in the 2D array.
     */
    public void getTotal(){
        double total = 0;
        for (int i = 0; i < randomArray.length; i++){
            for (int x = 0; x < randomArray.length; x++){
                total = total+ randomArray[x][i];
            }
        }
        System.out.printf("The total is: %f \n", total);
    }

    /**
     * This class is used to calculate the average of the elements in the 2D array
     * This class also calls the getElementCount() method, to get the number of elements in the 2D array
     */
    public void getAverage(){
        double total = 0;
        double average = 0.0;
        for (int i = 0; i < randomArray.length; i++){
            for (int x = 0; x < randomArray.length; x++){
                total = total + randomArray[x][i];
            }
        }

        average = total / getElementCount();
        System.out.printf("The average is: %f \n", average);
    }

    /**
     * This class calculates the total of all the elements in a given row in the 2D array.
     *
     * @param rowNumber the row number to find the total of
     */
    public void getRowTotal(int rowNumber) {
        double totalRow = 0;
        for (int i = 0; i < randomArray.length; i++){
            totalRow += randomArray[rowNumber-1][i];
        }

        System.out.printf("The total of %d row is %f \n", rowNumber, totalRow);
    }

    /**
     * This class calculates the sum of all the elements in a given column of the 2D array
     *
     * @param columnNumber the column number to find the sum of
     */
    public void getColumnTotal (int columnNumber) {
        double totalColumn = 0;
        for (int i = 0; i < randomArray.length; i++){
            totalColumn += randomArray[i][columnNumber - 1];
        }

        System.out.printf("The total of %d column is %f \n", columnNumber, totalColumn);
    }


    /**
     * This finds the highest element in a given row of a 2D array
     *
     * @param rowNumber the row to find the highest element in
     * @return the highest element in the given row
     */
    public double getHighestInRow (int rowNumber) {
        double highest = 0;
        for (int i = 0; i < randomArray.length; i++){
            if (randomArray[rowNumber-1][i] > highest){
                highest = randomArray[rowNumber-1][i];
            }
        }

        System.out.printf("The highest value of the %d row is %f \n", rowNumber, highest);
        return highest;
    }

    /**
     * This finds the lowest element in a given row of a 2D array
     *
     * @param rowNumber the row to find the lowest element in
     * @return the lowest element in the given row
     */
    public double getLowestInRow (int rowNumber) {
        double lowest = randomArray[rowNumber-1][randomArray.length-1];
        for (int i = 0; i < randomArray.length; i++){
            if (randomArray[rowNumber-1][i] < lowest){
                lowest = randomArray[rowNumber-1][i];
            }
        }

        System.out.printf("The lowest value of the %d row is %f \n", rowNumber, lowest);
        return lowest;
    }

    /**
     * Calculates the total number of elements in the 2D array
     *
     * @return the total number of elements in the 2D array
     */
    public int getElementCount() {
        int counter = 0;
        for (int i = 0; i < randomArray.length; i++) {
            for (int x = 0; x < randomArray.length; x++) {
                counter++;
            }
        }

        System.out.printf("The number of elements in the array is: %d \n", counter);

        return counter;
    }

    /**
     * This is the main method. Creates an object of the ArraysCalculate2D class and tests each method.
     *
     * @param args
     */
    public static void main(String[] args){
        ArraysCalculate2D testArray = new ArraysCalculate2D();
        testArray.getTotal();
        testArray.getAverage();
        testArray.getRowTotal(1);
        testArray.getColumnTotal(1);
        testArray.getHighestInRow(1);
        testArray.getLowestInRow(1);
    }
}