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

        return -1;
    }

    public static void main(String[] args){
        long[] LinearDataPoints = new long[8];
        long[] BinaryDataPoints = new long[8];

        LinearDataPoints[0] = new Tester().TestMethods("Linear Search", 500);
        LinearDataPoints[1] = new Tester().TestMethods("Linear Search", 1000);
        LinearDataPoints[2] = new Tester().TestMethods("Linear Search", 5000);
        LinearDataPoints[3] = new Tester().TestMethods("Linear Search", 10000);
        LinearDataPoints[4] = new Tester().TestMethods("Linear Search", 50000);
        LinearDataPoints[5] = new Tester().TestMethods("Linear Search", 100000);
        LinearDataPoints[6] = new Tester().TestMethods("Linear Search", 200000);
        LinearDataPoints[7] = new Tester().TestMethods("Linear Search", 300000);

        BinaryDataPoints[0] = new Tester().TestMethods("Binary Search", 500);
        BinaryDataPoints[1] = new Tester().TestMethods("Binary Search", 1000);
        BinaryDataPoints[2] = new Tester().TestMethods("Binary Search", 5000);
        BinaryDataPoints[3] = new Tester().TestMethods("Binary Search", 10000);
        BinaryDataPoints[4] = new Tester().TestMethods("Binary Search", 50000);
        BinaryDataPoints[5] = new Tester().TestMethods("Binary Search", 100000);
        BinaryDataPoints[6] = new Tester().TestMethods("Binary Search", 200000);
        BinaryDataPoints[7] = new Tester().TestMethods("Binary Search", 300000);

        System.out.println(Arrays.toString(LinearDataPoints));
        System.out.println(Arrays.toString(BinaryDataPoints));
    }
}
