import java.io.IOException;
import java.util.Random;


/**
 * This is the comparison count class that test the number of comparisons required for each sorting algorithm
 * Prints out the comparisons for each algorithm once done.
 *
 * @author Vidyoot Senthilvenkatesh
 * @date 4/5/2022
 */

public class ComparisonsTester {

    //Stores the comparisons required for each of these sorting algorithms
    public String BubbleComparisonCounter;
    public String SelectionComparisonCounter;
    public String InsertionComparisonCounter;
    public String MergeSortComparisonCounter;
    public int[] TesterArray;

    /**
     * This method randomizes calls the methods that are required to sort the array.
     * Stores the number of comparisons required to sort the array completely
     * @param numbersRandom the length of the array to randomize
     * @param typeSort the type of sort to perform on an array
     */
    public void TesterMethod(int numbersRandom, String typeSort) {

        Random r = new Random();

        //Instantiates a new random array
        TesterArray = new int[numbersRandom];

        //Randomizes the new array
        for (int i = 0; i < numbersRandom; i++){
            TesterArray[i] = r.nextInt(10000);
        }

        //Checks the type of sort to perform and calls the method accordingly
        if (typeSort.equalsIgnoreCase("Bubble")){
            BubbleSort bubble = new BubbleSort();
            bubble.BubbleSortAlgo(TesterArray);
            BubbleComparisonCounter = bubble.getComparisonCount();
        }
        else if (typeSort.equalsIgnoreCase("Selection")){
            SelectionSort selection = new SelectionSort();
            selection.SelectionSortAlgo(TesterArray);
            SelectionComparisonCounter = selection.getComparisonCount();
        }
        else if (typeSort.equalsIgnoreCase("Insertion")){
            InsertionSort insertion = new InsertionSort();
            insertion.InsertionSortAlgo(TesterArray);
            InsertionComparisonCounter = insertion.getComparisonCount();
        }
        else if  (typeSort.equalsIgnoreCase("Merge Sort")){
            MergeSort merge = new MergeSort();
            long timeStart = System.nanoTime();
            merge.Sort(TesterArray, 0, TesterArray.length - 1);
            long timeEnd= System.nanoTime();
            MergeSortComparisonCounter = merge.getComparisonCount();
        }
        else {
            System.out.println("Invalid type of sorting algorithm");
        }
    }

    /**
     * Used to print out and test the method
     * Tests each type of sort and uses different types of sort algorithm
     */
    public void TestingComparisons() {
        //These constants are used to test each sort algorithms for different array lengths
        int sample1 = 500;
        int sample2 = 10000;
        int sample3 = 100000;

        ComparisonsTester tester = new ComparisonsTester();

        System.out.println("\n"+ "------------------------------------------------------------------------------------------------------");
        System.out.println("Number of comparisons for each sorting algorithm:  ");
        System.out.println("Data Size\t\tBubble Sort     \t\tSelection Sort     \t\tInsertion Sort     \t\tMerge Sort");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        //Testing the methods here
        tester.TesterMethod(sample1,"Bubble");
        tester.TesterMethod(sample1,"Selection");
        tester.TesterMethod(sample1,"Insertion");
        tester.TesterMethod(sample1,"Merge Sort");

        //Immediately printing the values
        tester.printComparisonCountEvenLargerNumbers(sample1);

        //Testing the methods here
        tester.TesterMethod(sample2,"Bubble");
        tester.TesterMethod(sample2,"Selection");
        tester.TesterMethod(sample2,"Insertion");
        tester.TesterMethod(sample2,"Merge Sort");

        //Immediately printing the values
        tester.printComparisonCountLargerNumbers(sample2);

        //Testing the methods here
        tester.TesterMethod(sample3,"Bubble");
        tester.TesterMethod(sample3,"Selection");
        tester.TesterMethod(sample3,"Insertion");
        tester.TesterMethod(sample3,"Merge Sort");

        //Immediately printing the values
        tester.printComparisonCountLargerNumbers(sample3);
    }

    /**
     * Prints the values using a printf statement
     * This is for numbers that are a bit shorter in length
     * This is a little messy, but it works
     * ToDo: Change the tabs (\t) and find a more efficient way to spacing
     *
     * @param number the length of the array
     */
    public void printComparisonCountLargerNumbers(int number){
        System.out.printf("%d\t\t\t%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t%s\n", number, BubbleComparisonCounter, SelectionComparisonCounter, InsertionComparisonCounter, MergeSortComparisonCounter);
    }

    /**
     * Prints the values using a printf statement
     * This is for larger length numbers
     * This is a little messy, but it works
     * ToDo: Change the tabs (\t) and find a more efficient way to spacing
     *
     * @param number the length of the array
     */
    public void printComparisonCountEvenLargerNumbers(int number){
        System.out.printf("%d\t\t\t\t%s\t\t\t\t\t%s\t\t\t\t\t%s\t\t\t\t\t%s\n", number, BubbleComparisonCounter, SelectionComparisonCounter, InsertionComparisonCounter, MergeSortComparisonCounter);
    }

    /**
     * This is the main method, and calls the tester method of each comparison count and timer class
     * @param args
     */
    public static void main(String[] args) throws IOException {
        new TimeTester().TestingTime();
        new ComparisonsTester().TestingComparisons();
    }
}