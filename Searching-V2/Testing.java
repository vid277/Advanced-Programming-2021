//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;
import java.util.Random;

public class Testing {
    public int[] randomizedArray;
    public static int[] sortedArray;

    public Testing() {
    }

    public long[] TestMethods(String searchType, int randomizeLength) {
        this.randomizedArray = new int[randomizeLength];
        Random rand = new Random();

        for(int i = 0; i < randomizeLength; ++i) {
            this.randomizedArray[i] = rand.nextInt(100);
        }

        sortedArray = Arrays.copyOf(this.randomizedArray, randomizeLength);
        Arrays.sort(sortedArray);
        Searching search = new Searching();

        long startTime;
        int i;
        int searchList;
        long endTime;
        long comparisons = 0;

        if (searchType.equals("Linear Search")) {
            startTime = System.nanoTime();

            for(i = 0; i < randomizeLength / 2; ++i) {
                searchList = search.linearSearch(this.randomizedArray, sortedArray[i]);
                if (searchList == -1) {
                    System.out.println("Number not found in list");
                }

                comparisons = comparisons + search.getComparisonCount();
            }

            endTime = System.nanoTime();
            long[] dataStuff = {endTime - startTime, comparisons};
            return dataStuff;

        } else if (searchType.equals("Binary Search")) {
            startTime = System.nanoTime();

            for(i = 0; i < sortedArray.length / 2; ++i) {
                searchList = search.binarySearch(sortedArray, this.randomizedArray[i]);
                if (searchList == -1) {
                    System.out.println("Number not found in list");
                }
                comparisons = comparisons + search.getComparisonCount();
            }

            endTime = System.nanoTime();
            long[] dataStuff = {endTime - startTime, comparisons};
            return dataStuff;
        } else if (searchType.equals("Sorted List Search")) {
            startTime = System.nanoTime();

            for(i = 0; i < randomizeLength / 2; ++i) {
                searchList = search.SortedListSearch(sortedArray, this.randomizedArray[i]);
                if (searchList == -1) {
                    System.out.println("Number not found in list");
                }
                comparisons = comparisons + search.getComparisonCount();
            }

            endTime = System.nanoTime();
            long[] dataStuff = {endTime - startTime, comparisons};
            return dataStuff;
        } else {
            return new long[2];
        }
    }

    public static void main(String[] args) {
        long[] LinearDataPoints = new long[10];
        long[] BinaryDataPoints = new long[10];
        long[] SortedListSearchDataPoints = new long[10];

        long[] LinearDataPointsComparisons = new long[10];
        long[] BinaryDataPointsComparisons = new long[10];
        long[] SortedListSearchDataPointsComparisons = new long[10];


        long[] dataSize = new long[10];
        int currentDataSize = 1000;

        int x;
        for(x = 0; x < 10; ++x) {

            long[] LinearData = (new Testing()).TestMethods("Linear Search", currentDataSize);
            LinearDataPoints[x] = LinearData[0];
            LinearDataPointsComparisons[x] = LinearData[1];

            long[] BinaryData = (new Testing()).TestMethods("Binary Search", currentDataSize);
            BinaryDataPoints[x] = BinaryData[0];
            BinaryDataPointsComparisons[x] = BinaryData[1];

            long[] SortedListSearch = (new Testing()).TestMethods("Sorted List Search", currentDataSize);
            SortedListSearchDataPoints[x] = SortedListSearch[0];
            SortedListSearchDataPointsComparisons[x] = SortedListSearch[1];

            dataSize[x] = currentDataSize;

            currentDataSize += 10000;
        }

        System.out.println("Run Time for Each Search Method:");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.format("%10s %20s %20s %20s \n",
                "Data Size", "Sorted Linear Search", "Linear Search", "Binary Search");
        System.out.println("----------------------------------------------------------------------------------");

        for(x = 0; x < dataSize.length; ++x) {
            System.out.printf("%10d %20d %20d %20d\n", dataSize[x], LinearDataPoints[x], SortedListSearchDataPoints[x], BinaryDataPoints[x]);
        }

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Number of Comparisons for Each Search Method:");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.format("%10s %20s %20s %20s \n",
                "Data Size", "Sorted Linear Search", "Linear Search", "Binary Search");
        System.out.println("----------------------------------------------------------------------------------");

        for(x = 0; x < LinearDataPointsComparisons.length; ++x) {
            System.out.printf("%10d %20d %20d %20d\n", dataSize[x], LinearDataPointsComparisons[x], SortedListSearchDataPointsComparisons[x], BinaryDataPointsComparisons[x]);
        }

        new GraphV3(750, 600, "runtime", LinearDataPoints, BinaryDataPoints, SortedListSearchDataPoints);
        new GraphV3(750, 600, "comparisons", LinearDataPointsComparisons, BinaryDataPointsComparisons, SortedListSearchDataPointsComparisons);
    }
}
