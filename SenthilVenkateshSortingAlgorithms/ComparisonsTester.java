import java.util.Random;

public class ComparisonsTester {

    public String BubbleComparisonCounter;
    public String SelectionComparisonCounter;
    public String InsertionComparisonCounter;
    public String MergeSortComparisonCounter;
    public int[] TesterArray;

    public void TesterMethod(int numbersRandom, String typeSort) {

        Random r = new Random();

        TesterArray = new int[numbersRandom];

        for (int i = 0; i < numbersRandom; i++){
            TesterArray[i] = r.nextInt(10000);
        }

        if (typeSort.equalsIgnoreCase("Bubble")){
            BubbleSort bubble = new BubbleSort();
            bubble.BubbleSortAlgo(TesterArray);
            BubbleComparisonCounter = bubble.getComparisonCount();
        }
        else if (typeSort.equalsIgnoreCase("Selection")){
            SelectionSort selection = new SelectionSort();
            selection.SelectionSortAlgo(TesterArray);
            SelectionComparisonCounter = selection.getComparisonCount();
        }
        else if (typeSort.equalsIgnoreCase("Insertion")){
            InsertionSort insertion = new InsertionSort();
            insertion.InsertionSortAlgo(TesterArray);
            InsertionComparisonCounter = insertion.getComparisonCount();
        }
        else if  (typeSort.equalsIgnoreCase("Merge Sort")){
            MergeSort merge = new MergeSort();
            long timeStart = System.nanoTime();
            merge.Sort(TesterArray, 0, TesterArray.length - 1);
            long timeEnd= System.nanoTime();
            MergeSortComparisonCounter = merge.getComparisonCount();
        }
        else {
            System.out.println("Invalid type of sorting algorithm");
        }
    }

    public void TestingTime() {
        int sample1 = 500;
        int sample2 = 10000;
        int sample3 = 100000;

        ComparisonsTester tester = new ComparisonsTester();

        System.out.println("\n"+ "------------------------------------------------------------------------------------------------------");
        System.out.println("Number of comparisons for each sorting algorithm:  ");
        System.out.println("Data Size\t\tBubble Sort     \t\tSelection Sort     \t\tInsertion Sort     \t\tMerge Sort");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        tester.TesterMethod(sample1,"Bubble");
        tester.TesterMethod(sample1,"Selection");
        tester.TesterMethod(sample1,"Insertion");
        tester.TesterMethod(sample1,"Merge Sort");

        tester.printComparisonCountEvenLargerNumbers(sample1);

        tester.TesterMethod(sample2,"Bubble");
        tester.TesterMethod(sample2,"Selection");
        tester.TesterMethod(sample2,"Insertion");
        tester.TesterMethod(sample2,"Merge Sort");

        tester.printComparisonCountLargerNumbers(sample2);

        tester.TesterMethod(sample3,"Bubble");
        tester.TesterMethod(sample3,"Selection");
        tester.TesterMethod(sample3,"Insertion");
        tester.TesterMethod(sample3,"Merge Sort");

        tester.printComparisonCountLargerNumbers(sample3);

    }

    public static void main(String[] args) {
        new TimeTester().TestingTime();
        new ComparisonsTester().TestingTime();
    }

    public void printComparisonCountLargerNumbers(int number){
        System.out.printf("%d\t\t\t%s\t\t\t\t\t%s\t\t\t%s\t\t\t\t%s\n", number, BubbleComparisonCounter, SelectionComparisonCounter, InsertionComparisonCounter, MergeSortComparisonCounter);
    }

    public void printComparisonCountEvenLargerNumbers(int number){
        System.out.printf("%d\t\t\t\t%s\t\t\t\t\t\t%s\t\t\t\t%s\t\t\t\t\t%s\n", number, BubbleComparisonCounter, SelectionComparisonCounter, InsertionComparisonCounter, MergeSortComparisonCounter);
    }
}