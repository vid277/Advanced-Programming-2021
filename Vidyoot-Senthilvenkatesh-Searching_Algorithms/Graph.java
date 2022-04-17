import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
public class Graph {
    public Graph(){
        double[][] times = new double[175][4];

        // Make a canvas
        Canvas canvas = new Canvas("Comparing Speeds of Sorting", 800, 800);
        canvas.setFont(new Font("Times New Roman", Font.BOLD, 36));
        canvas.drawString("Loading Data...", 300, 400);
        canvas.setVisible(true);

        double max = 0;

        canvas.eraseString("Loading Data...", 300, 400);

        canvas.setFont(new Font("Arial", Font.BOLD, 18));

        // Axes
        canvas.fillRectangle(40, 754, 720, 4);
        canvas.fillRectangle(46, 40, 4, 724);
        canvas.drawString("Runtime (ms) vs. Array Size by Algorithm", 250, 100);

        // Labels
        canvas.setForegroundColor(new Color(0, 70, 200));
        canvas.fillRectangle(60, 50, 10, 10);
        canvas.drawString("Quicksort",75, 60);

        canvas.setForegroundColor(new Color(70, 240, 240));
        canvas.fillRectangle(60, 80, 10, 10);
        canvas.drawString("Insertion Sort",75, 90);

        canvas.setForegroundColor(new Color(60,180,75));
        canvas.fillRectangle(60, 110, 10, 10);
        canvas.drawString("Selection Sort",75, 120);

        canvas.setForegroundColor(new Color(230,25,75));
        canvas.fillRectangle(60, 140, 10, 10);
        canvas.drawString("Bubble Sort",75, 150);

        double scale = 720.0/max;
        for(int i = 0; i < 175; i++) {
            canvas.setForegroundColor(new Color(0, 70, 200));
            canvas.fillRectangle(i*4 + 50, 750 - (int)Math.floor(scale*times[i][0]), 4, 4);
            canvas.setForegroundColor(new Color(70, 240, 240));
            canvas.fillRectangle(i*4 + 50, 750 - (int)Math.floor(scale*times[i][1]), 4, 4);
            canvas.setForegroundColor(new Color(60,180,75));
            canvas.fillRectangle(i*4 + 50, 750 - (int)Math.floor(scale*times[i][2]), 4, 4);
            canvas.setForegroundColor(new Color(230,25,75));
            canvas.fillRectangle(i*4 + 50, 750 - (int)Math.floor(scale*times[i][3]), 4, 4);

            // Add tick mark
            if(i%25 == 24) {
                canvas.setForegroundColor(Color.BLACK);
                canvas.fillRectangle(i*4 + 50, 758, 4, 4);
                canvas.fillRectangle(42, 750 - i*4, 4, 4);
                canvas.drawString("" + i*30,i*4 + 35, 780);
                canvas.drawString("" + (int)Math.floor(max*i/175.0),15, 758 - i*4);
            }
        }
    }
}
