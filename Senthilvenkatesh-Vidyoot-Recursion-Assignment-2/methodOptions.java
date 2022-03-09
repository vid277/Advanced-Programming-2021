public class methodOptions {
    private int sum;
    private int numberOfTries;

    public methodOptions() {

    }

    public int Fibonacci(int n){
        if (n <= 1){
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public int moveDisks(int num, int fromPeg, int toPeg, int TempPeg){
        if (num == 1)
        {
            System.out.println("Move a disk from " +  fromPeg + " to peg " + toPeg);
            return numberOfTries + 1;
        }
        numberOfTries += 2;
        moveDisks(num-1, fromPeg, TempPeg, toPeg);
        System.out.println("Move a disk from " +  fromPeg + " to peg " + toPeg);
        return moveDisks(num-1, TempPeg, toPeg, fromPeg);
    }

    public int getNumberOfTries() {
        return numberOfTries + 1;
    }

    public int binarySearch(int[] array, int first, int last, int value) {
            if (last >= first) {
                int middle = first + (last - first) / 2;

                if (array[middle] == value)
                    return middle;

                if (array[middle] > value) return binarySearch(array, first, middle - 1, value);

                return binarySearch(array, middle + 1, last, value);
            }
            return -1;
    }


    public int rangeSum(int[] array, int start, int end){
        if (end < start){
            System.out.println("The second index has to be lower than the first index");
        }

        if(start == end){
            return sum;
        }

        sum = sum + array[start];
        return rangeSum(array, start + 1, end);
    }
}
