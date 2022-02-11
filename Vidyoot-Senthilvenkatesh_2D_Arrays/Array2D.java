import java.util.Arrays;
import java.util.Random;


public class Array2D {
    public double randomNumbers[][];
    public static Random random;

    public Array2D(int randomWidth, int randomHeight) {

        randomNumbers = new double[randomWidth][randomHeight];

        double randomNumberWidth = 0;
        double randomNumberHeight = 0;
        int generateMultiplier = 1000;

        for (int z = 0; z < randomWidth - 1; z++) {
             randomNumberWidth = random.nextDouble(0.00, 100.00);
        }
        for (int i = 0; i < randomWidth - 1; i++) {
            randomNumberHeight = random.nextDouble(0.00, 100.00);
            randomNumbers[0][i] = randomNumberHeight * randomNumberWidth;
        }

        System.out.println(Arrays.deepToString(randomNumbers));
        System.out.println("\n");

        for (int i = 0; i < randomWidth - 1; i++){
            for (int z = 0; z < randomWidth - 1; z++){
                //System.out.println(randomNumbers[i][z]);
            }
        }
    }

    public static void main(String[] args){
        random = new Random();

        int randomWidth = random.nextInt(0, 100) + 10;
        int randomHeight = random.nextInt(0, 100) + 10;

        Array2D testObject = new Array2D(randomWidth, randomHeight);

    }
}
