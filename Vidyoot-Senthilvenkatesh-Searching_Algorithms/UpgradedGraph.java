import java.awt.*;

public class UpgradedGraph {

    int maxWidth;
    int maxHeight;
    int numberOfDataPoints;
    int[] linearSearch;
    int[] binarySearch;
    int[] sortedListSearch;

    public UpgradedGraph(int w, int h, long[] LinearSearch, long[] BinarySearch, long[] SortedListSearch){
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

        canvas.drawLine(0, 450, 800, 450);
        canvas.drawLine(50, 450, 50, 40);
        canvas.drawLine(0, 40, 800, 40);

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
        int x_coordinate_spacing = 15;
        int y_coordinate_spacing = 15;
        int individualSpacingHorizontal = ((maxWidth - 50)/x_coordinate_spacing) + 1;
        int individualSpacingVertical = ((maxHeight - 105)/y_coordinate_spacing) + 1;

        int intervals = 1000;
        int saveIntervalPosition = 50;
        int saveLabelPosition = 42;

        int y_intervals = 100;
        int yaxis = 420;

        for (int i = 0; i < x_coordinate_spacing; i++){
            canvas.drawLine(saveIntervalPosition + 45, 450, saveIntervalPosition + 45, 40);
            canvas.drawString("" + intervals, saveLabelPosition, 470);

            intervals = intervals + 10000;
            saveIntervalPosition = saveIntervalPosition + individualSpacingHorizontal;
            saveLabelPosition = saveLabelPosition + individualSpacingHorizontal;
        }

        for (int x = 0; x < y_coordinate_spacing; x++){
            canvas.drawString("" + y_intervals, 5, yaxis + 12); //y-labels
            canvas.drawLine(50, yaxis  + 5, 800, yaxis + 5); //vertical lines

            y_intervals += 500;
            yaxis = yaxis - individualSpacingVertical;
        }

        int currentPositionX = 55;
        for (int i = 0; i < linearSearch.length; i++) {

            canvas.setForegroundColor(Color.BLACK);
            canvas.fillRectangle(currentPositionX - 12, 600 - (int)Math.floor(linearSearch[i] * 0.058 + 155), 10, 10);

            canvas.setForegroundColor(Color.BLUE);
            canvas.fillRectangle(currentPositionX - 12, 600 - (int)Math.floor(binarySearch[i] * 0.5 + 158), 10, 10);

            canvas.setForegroundColor(Color.cyan);
            canvas.fillRectangle(currentPositionX - 12, 600 - (int)Math.floor(sortedListSearch[i] * 0.058 + 158), 10, 10);

            currentPositionX = (currentPositionX + individualSpacingHorizontal);
        }

    }
}
