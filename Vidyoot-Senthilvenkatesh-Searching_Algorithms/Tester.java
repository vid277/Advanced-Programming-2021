import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Tester {
    public int[] randomizedArray;
    public int[] sortedArray;

    public long TestMethods(String searchType, int randomizeLength){
        int duration;

        randomizedArray = new int[randomizeLength];
        Random rand = new Random();

        for (int i = 0; i < randomizeLength; i++){
            randomizedArray[i] = rand.nextInt(100);
        }

        sortedArray = Arrays.copyOf(randomizedArray, randomizeLength);
        Arrays.sort(sortedArray);

        Searching search = new Searching();

        if (searchType.equals("Linear Search")){

            long startTime = System.nanoTime();

            for (int i = 0; i < randomizeLength/2; i++){
                int searchList = search.linearSearch(randomizedArray, sortedArray[i]);
                if (searchList == -1){
                    System.out.println("Number not found in list");
                }
            }

            long endTime = System.nanoTime();

            return ((endTime-startTime)/100000);
        }
        else if (searchType.equals("Binary Search")){

            long startTime = System.nanoTime();

            for (int i = 0; i < sortedArray.length/2; i++){
                int searchList = search.binarySearch(sortedArray, randomizedArray[i]);

                if (searchList == -1){
                    System.out.println("Number not found in list");
                }
            }

            long endTime = System.nanoTime();

            return ((endTime-startTime)/100000);
        }
        else if (searchType.equals("Sorted List Search")){

            long startTime = System.nanoTime();

            for (int i = 0; i < randomizeLength/2; i++){
                int searchList = search.SortedListSearch(sortedArray, randomizedArray[i]);
                if (searchList == -1){
                    System.out.println("Number not found in list");
                }
            }

            long endTime = System.nanoTime();

            return ((endTime-startTime)/100000);
        }

        return -1;
    }

    public static void main(String[] args){
        long[] LinearDataPoints = new long[12];
        long[] BinaryDataPoints = new long[12];
        long[] SortedListSearchDataPoints = new long[12];

        int currentDataSize = 1000;
        for (int i = 0; i < 12; i++){
            LinearDataPoints[i] = new Tester().TestMethods("Linear Search", currentDataSize);
            BinaryDataPoints[i] = new Tester().TestMethods("Binary Search", currentDataSize);
            SortedListSearchDataPoints[i] = new Tester().TestMethods("Sorted List Search", currentDataSize);
            currentDataSize += 10000;
        }

        System.out.println(Arrays.toString(LinearDataPoints));
        System.out.println(Arrays.toString(BinaryDataPoints));
        System.out.println(Arrays.toString(SortedListSearchDataPoints));

        //new Graph();
        new UpgradedGraph(800, 500, LinearDataPoints, BinaryDataPoints, SortedListSearchDataPoints);
    }
}
