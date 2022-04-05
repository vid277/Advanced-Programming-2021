import java.util.Random;

/**
 * This is the time tester class that test the time required for each sorting algorithm
 * Prints out the time for each algorithm once done.
 *
 * @author Vidyoot Senthilvenkatesh
 * @date 4/5/2022
 */

public class TimeTester {

    public int[] TesterArray;

    public String BubbleSortTime;
    public String SelectionSortTime;
    public String InsertionSortTime;
    public String MergeSortDurationTime;

    /**
     * This method randomizes calls the methods that are required to sort the array.
     *
     * @param numbersRandom the length of the array to randomize
     * @param typeSort the type of sort to perform on an array
     */
    public void TesterMethod(int numbersRandom, String typeSort){

        //Creates a random object
        Random r = new Random();

        //Used to randomize the array
        TesterArray = new int[numbersRandom];
        for (int i = 0; i < numbersRandom; i++){
            TesterArray[i] = r.nextInt(10000);
        }

        //Checks the type of sort to perform and calls the method accordingly
        if (typeSort.equalsIgnoreCase("Bubble")){
            BubbleSort bubble = new BubbleSort();
            bubble.BubbleSortAlgo(TesterArray);
            BubbleSortTime = bubble.getDuration();
        }
        else if (typeSort.equalsIgnoreCase("Selection")){
            SelectionSort selection = new SelectionSort();
            selection.SelectionSortAlgo(TesterArray);
            SelectionSortTime = selection.getDuration();
        }
        else if (typeSort.equalsIgnoreCase("Insertion")){
            InsertionSort insertion = new InsertionSort();
            insertion.InsertionSortAlgo(TesterArray);
            InsertionSortTime = insertion.getDuration();
        }
        else if  (typeSort.equalsIgnoreCase("Merge Sort")){
            MergeSort merge = new MergeSort();
            long timeStart = System.nanoTime();
            merge.Sort(TesterArray, 0, TesterArray.length - 1);
            long timeEnd= System.nanoTime();
            MergeSortDurationTime = ((timeEnd - timeStart)/1000000) + "";
        }
        else {
            System.out.println("Invalid type of sorting algorithm");
        }
    }

    /**
     * Used to print out and test the method
     * Tests each type of sort and uses different types of sort algorithm
     */
    public void TestingTime(){
        System.out.println("Time analysis for the sorting algorithms:  ");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Data Size\t\tBubble Sort (ms)\t\tSelection Sort (ms)\t\tInsertion Sort (ms)\t\tMerge Sort\t\t");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        //These constants are used to test each sort algorithms for different array lengths
        final int sample1 = 500;
        final int sample2 = 10000;
        final int sample3 = 100000;


        TimeTester tester = new TimeTester();

        //Testing the methods here
        tester.TesterMethod(sample1,"Bubble");
        tester.TesterMethod(sample1,"Selection");
        tester.TesterMethod(sample1,"Insertion");
        tester.TesterMethod(sample1,"Merge Sort");

        //Immediately printing the values
        tester.printTime(sample1);

        //Testing the methods here
        //Different sample size
        tester.TesterMethod(sample2,"Bubble");
        tester.TesterMethod(sample2,"Selection");
        tester.TesterMethod(sample2,"Insertion");
        tester.TesterMethod(sample2,"Merge Sort");

        //Immediately printing the values
        tester.printTimeLargerNumbers(sample2);

        //Testing the methods here
        //Different sample size
        tester.TesterMethod(sample3,"Bubble");
        tester.TesterMethod(sample3,"Selection");
        tester.TesterMethod(sample3,"Insertion");
        tester.TesterMethod(sample3,"Merge Sort");

        //Immediately printing the values
        tester.printTimeEvenLargerNumbers(sample3);
    }

    /**
     * Prints the values using a printf statement
     * This is for smaller length numbers
     * This is a little messy, but it works
     * ToDo: Change the tabs (\t) and find a more efficient way to spacing
     *
     * @param number the length of the array
     */
    public void printTime(int number){
        System.out.printf("%d\t\t\t\t%s\t\t\t\t\t\t%s\t\t\t\t\t\t%s\t\t\t\t\t\t%s\n", number, BubbleSortTime, SelectionSortTime, InsertionSortTime, MergeSortDurationTime);
    }

    /**
     * Prints the values using a printf statement
     * This is for larger length numbers
     * This is a little messy, but it works
     * ToDo: Change the tabs (\t) and find a more efficient way to spacing
     *
     * @param number the length of the array
     */
    public void printTimeLargerNumbers(int number){
        System.out.printf("%d\t\t\t%s\t\t\t\t\t\t%s\t\t\t\t\t\t%s\t\t\t\t\t\t%s\n", number, BubbleSortTime, SelectionSortTime, InsertionSortTime, MergeSortDurationTime);
    }

    /**
     * Prints the values using a printf statement
     * This is for large numbers
     * This is a little messy, but it works
     * ToDo: Change the tabs (\t) and find a more efficient way to spacing
     *
     * @param number the length of the array
     */
    public void printTimeEvenLargerNumbers(int number){
        System.out.printf("%d\t\t\t%s\t\t\t\t\t%s\t\t\t\t\t%s\t\t\t\t\t%s\n", number, BubbleSortTime, SelectionSortTime, InsertionSortTime, MergeSortDurationTime);
    }

}
