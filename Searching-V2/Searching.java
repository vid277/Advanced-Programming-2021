//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Searching {

    int numberOfComparisons;

    public int linearSearch(int[] arrayRandom, int numberToSearch) {
        numberOfComparisons = 0;
        int index = -1;

        for(int i = 0; i < arrayRandom.length; ++i) {
            if (arrayRandom[i] == numberToSearch) {
                index = i;
            }
            numberOfComparisons++;
        }

        return index;
    }

    public int binarySearch(int[] arrayRandom, int numberToSearch) {
        numberOfComparisons = 0;

        int low = 0;
        int high = arrayRandom.length - 1;

        while(low <= high) {
            int middle = (high + low) / 2;
            if (arrayRandom[middle] == numberToSearch) {
                return middle;
            }

            if (arrayRandom[middle] < numberToSearch) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
            numberOfComparisons++;
        }

        return -1;
    }

    public int SortedListSearch(int[] sortedArray, int numberToSearch) {
        numberOfComparisons = 0;

        int index = -1;

        for(int i = 0; i < sortedArray.length; ++i) {
            if (sortedArray[i] == numberToSearch) {
                index = i;
            }
            numberOfComparisons++;
        }
        return index;
    }

    public int getComparisonCount(){
        return numberOfComparisons;
    }
}
