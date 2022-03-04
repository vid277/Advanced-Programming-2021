import java.io.IOException;

public class PetTester {

    public PetTester(String nameOfFile){

    }

    public static void main (String[] args) throws IOException {
        new PetTester("petData.txt");
        new Screen_GUI();
    }
}
