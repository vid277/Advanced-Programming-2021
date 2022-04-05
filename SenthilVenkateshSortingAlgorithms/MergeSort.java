/**
 * This class contains the merge sort algorithm.
 * It counts the comparisons and also the time required sort the array
 *
 * @author Vidyoot Senthilvenkatesh
 * @date 4/5/2022
 */
class MergeSort {

    //Number of comparisons
    private long mergeCounter = 0;

    /**
     * This merges the arrays together to return a sorted array
     *
     * @param arr the array to merge
     * @param low the lowest index to merge from the array
     * @param middle the middle index to merge from the array
     * @param high the highest index to merge from the array
     */
    void MergeSortAlgo(int[] arr, int low, int middle, int high) {

        //If the array length is 1, the array is sorted with itself
        if (arr.length == 1){
            return;
        }

        //This is the length lower half of the array
        int n1 = middle - low + 1;

        //This is the length of greater half of the array
        int n2 = high - middle;

        //This is the lower half part of the array
        int[] LowArray = new int[n1];

        //This is the greater half part of the array
        int[] HighArray = new int[n2];

        //Creates a copy of the array
        System.arraycopy(arr, low + 0, LowArray, 0, n1);

        //Copies the values of each element into the lower half of the array
        for (int i = 0; i < n1; i++)
            LowArray[i] = arr[low + i];

        //Copies the values of each element into the higher half of the array
        for (int j = 0; j < n2; j++)
            HighArray[j] = arr[middle + 1 + j];

        int i = 0;
        int j = 0;
        int k = low;

        //Compares the values from each array (index i and j)
        while (i < n1 && j < n2) {
            mergeCounter+=1;
            if (LowArray[i] <= HighArray[j]) {
                arr[k] = LowArray[i];
                i++;
            } else {
                arr[k] = HighArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = LowArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = HighArray[j];
            j++;
            k++;
        }
    }

    /**
     * This splits the array in half
     * Once the array is split in half, the array is merged again.
     *
     * @param arr the array to sort
     * @param low the lowest index of the array
     * @param high the highest index of the array
     */
    public void Sort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;

            //Sorts the two halves of the array
            Sort(arr, low, middle);
            Sort(arr,middle + 1, high);

            //Merges the split arrays
            MergeSortAlgo(arr, low, middle, high);
        }
    }

    /**
     * This returns the number of comparisons that the algorithm takes to run in milliseconds
     *
     * @return the number of comparisons required for the algorithm to run
     */
    public String getComparisonCount(){
        return mergeCounter + "";
    }

}