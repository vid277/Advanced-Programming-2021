//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class GraphV5 {
    int maxWidth;
    int maxHeight;
    int numberOfDataPoints;
    long[] linearSearch;
    long[] binarySearch;
    long[] sortedListSearch;

    public GraphV5(int w, int h, String title, long[] LinearSearch, long[] BinarySearch, long[] SortedListSearch) {
        maxWidth = w;
        maxHeight = h;
        linearSearch = new long[LinearSearch.length];
        binarySearch = new long[BinarySearch.length];
        sortedListSearch = new long[SortedListSearch.length];
        if (LinearSearch.length == BinarySearch.length) {
            numberOfDataPoints = LinearSearch.length;
        }

        Canvas canvas = new Canvas("The graph of comparisons for binary and linear search algorithms", maxWidth, maxHeight);

        for(int i = 0; i < numberOfDataPoints; ++i) {
            linearSearch[i] = LinearSearch[i];
            binarySearch[i] = BinarySearch[i];
            sortedListSearch[i] = SortedListSearch[i];
        }

        draw(canvas);
    }

    public void draw(Canvas canvas) {
        canvas.setVisible(true);
        canvas.setForegroundColor(Color.RED);
        canvas.drawLine(0, 550, 800, 550);
        canvas.drawLine(85, 550, 85, 40);
        canvas.drawLine(0, 40, 800, 40);
        Font labels = new Font("TimesRoman", 1, 14);
        canvas.setFont(labels);
        canvas.drawString("The graph of comparisons for binary and linear search algorithms", 150, 10);
        canvas.setForegroundColor(Color.cyan);
        canvas.fillRectangle(95, 20, 10, 10);
        canvas.setForegroundColor(Color.BLACK);
        canvas.fillRectangle(280, 20, 10, 10);
        canvas.setForegroundColor(Color.BLUE);
        canvas.fillRectangle(415, 20, 10, 10);
        canvas.setForegroundColor(Color.RED);
        canvas.drawString("Sorted Linear Search", 110, 30);
        canvas.drawString("Linear Search", 295, 30);
        canvas.drawString("Binary Search", 430, 30);
        canvas.drawString("Data sizes", 390, 590);
        canvas.drawString("Run time", 2, 35);
        
        canvas.setForegroundColor(Color.RED);

        long max=linearSearch[0];
        for(int i = 0; i < linearSearch.length; i++){
            if (linearSearch[i] > max){
                max = linearSearch[i];
            }
        }
        for(int x = 0; x < binarySearch.length; x++){
            if (binarySearch[x] > max){
                max = binarySearch[x];
            }
        }
        for(int z = 0; z < sortedListSearch.length; z++){
            if (sortedListSearch[z] > max) {
                max = sortedListSearch[z];
            }
        }

        double UpperMax = Math.pow(10.0, (Math.log10(max) + 1));
        long MAXX = 750;
        long MAXY = 60;
        long OriginX = 85;
        long OriginY = 540;

        double ScalingFactorY = (double)(OriginY - MAXY) / Math.log10(UpperMax);
        double HorizontalMax = 100000.0;
        double ScalingFactorX = (double)(MAXX - OriginX) / HorizontalMax;

        canvas.setForegroundColor(Color.RED);

        long currentY = OriginY;
        long currentX;
        String currentLabel = "1";

        for(currentX = 0; currentX < Math.log10(UpperMax); currentX++) {
            currentY = (int)(currentX * ScalingFactorY);
            canvas.drawLine(80, (int) (OriginY - currentY - 7), 100, (int) (OriginY - currentY - 7));
            canvas.drawString(currentLabel, 5, (int) (OriginY - currentY - 2));
            currentLabel = currentLabel + "0";
        }


        currentX = OriginX;
        long currentValue = 1000;

        int updateXPoint;
        for(updateXPoint = 0; updateXPoint < 10; updateXPoint++) {
            canvas.drawString(String.valueOf(currentValue), (int) currentX, 570);
            currentX = (int)((double)currentX + ScalingFactorX * Math.pow(10.00, 4.00));
            currentValue += 10000;
        }

        updateXPoint = 1000;

        ArrayList<Long> LinearDataPointsX = new ArrayList<>();
        ArrayList<Long> LinearDataPointsY = new ArrayList<>();

        ArrayList<Long> SortedLinearDataPointsX = new ArrayList<>();
        ArrayList<Long> SortedLinearDataPointsY = new ArrayList<>();

        ArrayList<Long> BinaryDataPointsX = new ArrayList<>();
        ArrayList<Long> BinaryDataPointsY = new ArrayList<>();

        for(int i = 0; i < linearSearch.length; i++) {
            canvas.setForegroundColor(Color.BLACK);
            int currentYLinearSearch = (int)(OriginY - Math.log10(linearSearch[i]) * ScalingFactorY);
            canvas.fillRectangle((int)(OriginX + ScalingFactorX * updateXPoint), currentYLinearSearch, 7, 7);

            LinearDataPointsX.add((long) (OriginX + ScalingFactorX * updateXPoint));
            LinearDataPointsY.add((long) currentYLinearSearch);

            canvas.setForegroundColor(Color.BLUE);
            int currentYBinarySearch = (int)(OriginY - Math.log10(binarySearch[i]) * ScalingFactorY);
            canvas.fillRectangle((int)(OriginX + ScalingFactorX * updateXPoint), currentYBinarySearch, 7, 7);

            BinaryDataPointsX.add((long) (OriginX + ScalingFactorX * updateXPoint));
            BinaryDataPointsY.add((long) currentYBinarySearch);

            canvas.setForegroundColor(Color.CYAN);

            int sortedLinearSearch = (int)(OriginY - Math.log10(sortedListSearch[i]) * ScalingFactorY);
            canvas.fillRectangle((int)(OriginX + ScalingFactorX * updateXPoint), sortedLinearSearch, 7, 7);

            SortedLinearDataPointsX.add((long) (OriginX + ScalingFactorX * updateXPoint));
            SortedLinearDataPointsY.add((long) sortedLinearSearch);

            updateXPoint += 10000;
        }

        for (int i = 0; i < LinearDataPointsX.size() - 1; i++) {
            canvas.setForegroundColor(Color.BLACK);
            canvas.drawLine(Math.toIntExact(LinearDataPointsX.get(i)), Math.toIntExact(LinearDataPointsY.get(i)), Math.toIntExact(LinearDataPointsX.get(i + 1)), Math.toIntExact(LinearDataPointsY.get(i + 1)));

            canvas.setForegroundColor(Color.CYAN);
            canvas.drawLine(Math.toIntExact(SortedLinearDataPointsX.get(i)), Math.toIntExact(SortedLinearDataPointsY.get(i)), Math.toIntExact(SortedLinearDataPointsX.get(i + 1)), Math.toIntExact(SortedLinearDataPointsY.get(i + 1)));

            canvas.setForegroundColor(Color.BLUE);
            canvas.drawLine(Math.toIntExact(BinaryDataPointsX.get(i)), Math.toIntExact(BinaryDataPointsY.get(i)), Math.toIntExact(BinaryDataPointsX.get(i + 1)), Math.toIntExact(BinaryDataPointsY.get(i + 1)));
        }

    }
}
