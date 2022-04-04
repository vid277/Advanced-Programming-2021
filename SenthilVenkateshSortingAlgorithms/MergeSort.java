class MergeSort {

    private long mergeCounter = 0;

    void MergeSortAlgo(int arr[], int low, int middle, int high) {

        if (arr.length == 1){
            return;
        }

        int n1 = middle - low + 1;
        int n2 = high - middle;

        int LowArray[] = new int[n1];
        int HighArray[] = new int[n2];

        for (int i = 0; i < n1; i++)
            LowArray[i] = arr[low + i];
        for (int j = 0; j < n2; j++)
            HighArray[j] = arr[middle + 1 + j];

        int i = 0;
        int j = 0;

        int k = low;
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

    public void Sort(int arr[], int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;

            Sort(arr, low, middle);
            Sort(arr,middle + 1, high);

            MergeSortAlgo(arr, low, middle, high);
        }
    }

    public String getComparisonCount(){
        return mergeCounter + "";
    }

}