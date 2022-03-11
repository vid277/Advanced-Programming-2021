/**
 * This is the methodOptions class that contains the methods for all possible options for the user to choose from
 * These are all recursion based algorithms
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 3/8/2022
 */
public class methodOptions {

    //Required variables to store important information for certain methods
    private int sum;
    private int numberOfTries;

    /**
     * Used to calculate the fibonacci sequence until a certain number
     * @param n - the nth term of the fibonacci sequence
     * @return - the value of a certain term of th fibonacci sequence
     */
    public int Fibonacci(int n){
        if (n <= 1){
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    /**
     * Used to calculate the number of moves required to complete the tower of hanoi problems
     * Utilizes recursion
     *
     * @param num - the number of disks
     * @param fromPeg - The peg to move a disk from (Peg A)
     * @param toPeg - The peg to move a disk to (Peg B)
     * @param TempPeg - The temporary peg to move a disk for short term storage (Peg C)
     * @return - the peg to move the disks to and from
     */
    public int moveDisks(int num, int fromPeg, int toPeg, int TempPeg){
        if (num == 1)
        {
            //System.out.println("Move a disk from peg " +  fromPeg + " to peg " + toPeg);
            return numberOfTries + 1;
        }
        numberOfTries += 2;
        moveDisks(num-1, fromPeg, TempPeg, toPeg);
        //System.out.println("Move a disk from " +  fromPeg + " to peg " + toPeg);
        return moveDisks(num-1, TempPeg, toPeg, fromPeg);
    }

    /**
     * Gets the number of tries required for the tower of hanoi problems
     *
     * @return - the number of tries required for the tower of hanoi problem
     */
    public int getNumberOfTries() {
        return numberOfTries + 1;
    }

    /**
     * This is a binary search algorithm that finds the index of a certain element in a sorted array
     *
     * @param array - a sorted array containing integers
     * @param first - the first index of the array
     * @param last - the last index of the array
     * @param value - the value to search for
     * @return - the index of the element in the array, -1 if the element is not found in the array, or a call to the binarySearch method.
     */
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

    /**
     * This finds the  sum of elements from the start index to the end index in the array
     *
     * @param array - the array of elements
     * @param start - the index to start summing from
     * @param end - the index to end summing from
     * @return - the sum of the elements between the start index to the end index of the array
     */
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
