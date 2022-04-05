import java.util.Arrays;

/**
 * This class contains the bubble sort algorithm.
 * It counts the comparisons and also the time required sort the array
 *
 * @author Vidyoot Senthilvenkatesh
 * @date 4/5/2022
 */
public class BubbleSort {

    //Stores the time required to sort the array
    long timeStart;
    long timeEnd;

    //Stores the number of comparisons required to sort the array
    long comparisonCount = 0 ;

    /**
     * This is the bubble sort algorithm
     * This compares two values and swaps the values if one is greater
     *
     * @param randomArray the array containing the randomized arrays
     * @return the sorted array
     */
    public int[] BubbleSortAlgo(int[] randomArray){
        //Starts the timer
        timeStart = System.nanoTime();
        int[] arrayRandom = Arrays.copyOf(randomArray, randomArray.length);
        for (int i = 0; i < arrayRandom.length - 1; i++){
            for (int j = 1; j <= i - 1; j++){
                //Increasing the comparison count
                comparisonCount++;
                if (arrayRandom[j] > arrayRandom[i]){
                    int temp = arrayRandom[i];
                    arrayRandom[i] = arrayRandom[j];
                    arrayRandom[j] = temp;
                }
            }
        }

        //Stops the timer
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
        return (comparisonCount) + "";
    }
}
