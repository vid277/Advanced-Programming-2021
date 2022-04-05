import java.util.Arrays;

/**
 * This class contains the selection sort algorithm.
 * It counts the comparisons and also the time required sort the array
 *
 * @author Vidyoot Senthilvenkatesh
 * @date 4/5/2022
 */
public class SelectionSort {

    //Stores the time required to sort the array
    long timeStart;
    long timeEnd;

    //Stores the number of comparisons required to sort the array
    long comparisonCount = 0 ;

    /**
     * This is the selection sort algorithm
     * This finds the lowest element of an array from a certain index and swaps the number as needed
     *
     * @param arrayRandom the array containing the randomized arrays
     * @return the sorted array
     */
    public int[] SelectionSortAlgo(int[] arrayRandom){
        int[] sortingArray = Arrays.copyOf(arrayRandom, arrayRandom.length);

        //Starts the timer
        timeStart = System.nanoTime();
        double comparisons = 0.0;

        for(int i = 0; i < sortingArray.length - 1; i++) {
            int minimum = i;
            for(int j = i + 1; j < sortingArray.length; j++) {
                comparisons++;
                if(sortingArray[j] < sortingArray[minimum]) {
                    minimum = j;
                }
            }

            int temp = sortingArray[i];
            sortingArray[i] = sortingArray[minimum];
            sortingArray[minimum] = temp;
        }
        comparisonCount = (int)comparisons;

        //Ends the timer
        timeEnd = System.nanoTime();
        return arrayRandom;
    }


    /**
     * This returns the duration that the algorithm takes to run in milliseconds
     *
     * @return the duration (ms) required for the algorithm to run
     */
    public String getDuration(){
        return ((timeEnd - timeStart)/1000000) + "";
    }

    /**
     * This returns the number of comparisons that the algorithm takes to run in milliseconds
     *
     * @return the number of comparisons required for the algorithm to run
     */
    public String getComparisonCount(){
        return comparisonCount + "";
    }
}