import java.util.Random;

public class TimeTester {

    public int[] TesterArray;

    public String BubbleSortTime;
    public String SelectionSortTime;
    public String InsertionSortTime;
    public String MergeSortDurationTime;

    public void TesterMethod(int numbersRandom, String typeSort){

        Random r = new Random();

        TesterArray = new int[numbersRandom];
        for (int i = 0; i < numbersRandom; i++){
            TesterArray[i] = r.nextInt(10000);
        }

        if (typeSort.equalsIgnoreCase("Bubble")){
            BubbleSort bubble = new BubbleSort();
            bubble.BubbleSortAlgo(TesterArray);
            BubbleSortTime = bubble.getDuration();
        }
        else if (typeSort.equalsIgnoreCase("Selection")){
            SelectionSort selection = new SelectionSort();
            selection.SelectionSortAlgo(TesterArray);
            SelectionSortTime = selection.getDuration();
        }
        else if (typeSort.equalsIgnoreCase("Insertion")){
            InsertionSort insertion = new InsertionSort();
            insertion.InsertionSortAlgo(TesterArray);
            InsertionSortTime = insertion.getDuration();
        }
        else if  (typeSort.equalsIgnoreCase("Merge Sort")){
            MergeSort merge = new MergeSort();
            long timeStart = System.nanoTime();
            merge.Sort(TesterArray, 0, TesterArray.length - 1);
            long timeEnd= System.nanoTime();
            MergeSortDurationTime = ((timeEnd - timeStart)/1000000) + "";
        }
        else {
            System.out.println("Invalid type of sorting algorithm");
        }
    }

    public void TestingTime(){
        System.out.println("Time analysis for the sorting algorithms:  ");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Data Size\t\tBubble Sort (ms)\t\tSelection Sort (ms)\t\tInsertion Sort (ms)\t\tMerge Sort\t\t");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        int sample1 = 500;
        int sample2 = 10000;
        int sample3 = 100000;

        TimeTester tester = new TimeTester();

        tester.TesterMethod(sample1,"Bubble");
        tester.TesterMethod(sample1,"Selection");
        tester.TesterMethod(sample1,"Insertion");
        tester.TesterMethod(sample1,"Merge Sort");

        tester.printTime(sample1);

        tester.TesterMethod(sample2,"Bubble");
        tester.TesterMethod(sample2,"Selection");
        tester.TesterMethod(sample2,"Insertion");
        tester.TesterMethod(sample2,"Merge Sort");

        tester.printTimeLargerNumbers(sample2);

        tester.TesterMethod(sample3,"Bubble");
        tester.TesterMethod(sample3,"Selection");
        tester.TesterMethod(sample3,"Insertion");
        tester.TesterMethod(sample3,"Merge Sort");

        tester.printTimeEvenLargerNumbers(sample3);
    }

    public void printTime(int number){
        System.out.printf("%d\t\t\t\t\t%s\t\t\t\t\t\t\t%s\t\t\t\t\t%s\t\t\t\t\t%s\n", number, BubbleSortTime, SelectionSortTime, InsertionSortTime, MergeSortDurationTime);
    }

    public void printTimeLargerNumbers(int number){
        System.out.printf("%d\t\t\t\t%s\t\t\t\t\t\t\t%s\t\t\t\t\t%s\t\t\t\t\t%s\n", number, BubbleSortTime, SelectionSortTime, InsertionSortTime, MergeSortDurationTime);
    }

    public void printTimeEvenLargerNumbers(int number){
        System.out.printf("%d\t\t\t\t%s\t\t\t\t\t\t%s\t\t\t\t%s\t\t\t\t%s\n", number, BubbleSortTime, SelectionSortTime, InsertionSortTime, MergeSortDurationTime);
    }

}
