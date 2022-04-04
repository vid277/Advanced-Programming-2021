import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {

    long timeStart;
    long timeEnd;
    long comparisonCount = 0 ;

    public int[] BubbleSortAlgo(int[] randomArray){
        timeStart = System.nanoTime();
        int[] arrayRandom = Arrays.copyOf(randomArray, randomArray.length);
        for (int i = 0; i < arrayRandom.length - 1; i++){
            for (int j = 1; j <= i - 1; j++){
                comparisonCount++;
                if (arrayRandom[j] > arrayRandom[i]){
                    int temp = arrayRandom[i];
                    arrayRandom[i] = arrayRandom[j];
                    arrayRandom[j] = temp;
                }
            }
        }

        timeEnd = System.nanoTime();
        return arrayRandom;
    }

    public String getDuration(){
        return ((timeEnd - timeStart)/1000000) + "";
    }

    public String getComparisonCount(){
        return (comparisonCount) + "";
    }
}
