import java.awt.*;

public class GraphV2 {

        int maxWidth;
        int maxHeight;
        int numberOfDataPoints;
        int[] linearSearch;
        int[] binarySearch;
        int[] sortedListSearch;

        public GraphV2(int w, int h, long[] LinearSearch, long[] BinarySearch, long[] SortedListSearch){
            maxWidth = w;
            maxHeight = h;

            linearSearch = new int[LinearSearch.length];
            binarySearch = new int[BinarySearch.length];
            sortedListSearch = new int[SortedListSearch.length];

            if (LinearSearch.length == BinarySearch.length){
                numberOfDataPoints = LinearSearch.length;
            }

            Canvas canvas = new Canvas("The graph of runtimes for binary and linear search algorithms", maxWidth, maxHeight);

            for (int i = 0; i < numberOfDataPoints; i++){
                linearSearch[i] = (int) LinearSearch[i];
                binarySearch[i] = (int) BinarySearch[i];
                sortedListSearch[i] = (int) SortedListSearch[i];
            }

            draw(canvas);
        }

        public void draw(Canvas canvas){

            canvas.setVisible(true);
            canvas.setForegroundColor(Color.RED);

            canvas.drawLine(0, 450, 600, 450);
            canvas.drawLine(50, 450, 50, 40);
            canvas.drawLine(0, 40, 600, 40);

            Font labels = new Font("TimesRoman", Font.BOLD, 14);
            canvas.setFont(labels);

            canvas.drawString("The graph of runtimes for binary and linear search algorithms", 150, 10);

            canvas.setForegroundColor(Color.cyan);
            canvas.fillRectangle(95, 20, 10, 10);

            canvas.setForegroundColor(Color.BLACK);
            canvas.fillRectangle(280, 20, 10, 10);

            canvas.setForegroundColor(Color.BLUE);
            canvas.fillRectangle(415,20, 10, 10);

            canvas.setForegroundColor(Color.RED);
            canvas.drawString("Sorted Linear Search", 110, 30);
            canvas.drawString("Linear Search", 295, 30);
            canvas.drawString("Binary Search", 430, 30);

            canvas.drawString("Data sizes", 390,490);
            canvas.drawString("Run time", 2, 35);

            canvas.setForegroundColor(Color.RED);


        }
}

