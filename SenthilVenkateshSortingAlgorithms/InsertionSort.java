import java.util.Arrays;

/**
 * This class contains the insertion sort algorithm.
 * It counts the comparisons and also the time required sort the array
 *
 * @author Vidyoot Senthilvenkatesh
 * @date 4/5/2022
 */
public class InsertionSort {

    //Stores the time required to sort the array
    long timeStart = 0;
    long timeEnd = 0;

    //Stores the number of comparisons required to sort the array
    long comparisonCount = 0 ;

    /**
     * Sorting the algorithm using InsertionSort
     * Insertion sort starts at the first index and goes back. Once going back, if the number below is greater than the index you
     * - are currently at, the numbers get swapped
     * @param randomArray the array containing the randomized arrays
     * @return the sorted array
     */
    public int[] InsertionSortAlgo(int[] randomArray) {

        //Making a duplicate of the randomized array
        int[] arrayRandom = Arrays.copyOf(randomArray, randomArray.length);
        timeStart = System.nanoTime();
        for (int i = 1; i < arrayRandom.length; i++) {
            int StoreVal = arrayRandom[i];
            int j;
            for (j = i; j > 0; j--){
                comparisonCount++;
                if (arrayRandom[j-1] < StoreVal) {
                    break;
                }
                arrayRandom[j] = arrayRandom[j - 1];
            }
            arrayRandom[j] = StoreVal;
        }
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
