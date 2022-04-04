import java.util.Arrays;

public class InsertionSort {

    long timeStart = 0;
    long timeEnd = 0;
    long comparisonCount = 0 ;

    public int[] InsertionSortAlgo(int[] randomArray) {
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

    public String getDuration(){
        return ((timeEnd - timeStart)/1000000) + "";
    }

    public String getComparisonCount(){
        return comparisonCount + "";
    }
}
