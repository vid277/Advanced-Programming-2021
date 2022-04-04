import java.util.Arrays;

public class SelectionSort {
    long timeStart;
    long timeEnd;
    long comparisonCount = 0 ;

    public int[] SelectionSortAlgo(int[] arrayRandom){
        int[] sortingArray = Arrays.copyOf(arrayRandom, arrayRandom.length);
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
        timeEnd = System.nanoTime();
        return arrayRandom;
    }

    public String getDuration(){
        return ((timeEnd - timeStart)/1000000) + "";
    }

    public String getComparisonCount(){
        return comparisonCount + "";
    }
}