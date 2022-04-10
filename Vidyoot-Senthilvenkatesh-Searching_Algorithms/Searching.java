import java.util.ArrayList;
import java.util.Arrays;

public class Searching {
    public int linearSearch(int[] arrayRandom, int numberToSearch) {
        int index = -1;

        for (int i = 0; i < arrayRandom.length; i++) {
            if (arrayRandom[i] == numberToSearch) {
                index = i;
            }
        }
        return index;
    }

    public int binarySearch (int[] arrayRandom, int numberToSearch) {
        int low = 0;
        int high = arrayRandom.length - 1;

        while (low <= high) {
            int middle = (high + low)/ 2;

            if (arrayRandom[middle] == numberToSearch)
                return middle;

            if (arrayRandom[middle] < numberToSearch)
                low = middle + 1;

            else
                high = middle - 1;
        }
        return -1;
    }
}

