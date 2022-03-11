import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PetTester {

    public Scanner scanner;
    public File storeFile;
    public static ArrayList<Pet> petList = new ArrayList<Pet>();

    public PetTester(String nameOfFile) throws FileNotFoundException {

        storeFile = new File(nameOfFile);

        boolean isExists = storeFile.exists();

        if (isExists){
            scanner = new Scanner(storeFile);
            while (scanner.hasNextLine() || scanner.nextLine().equalsIgnoreCase("End")){
                String line = scanner.nextLine();

                if (line.equalsIgnoreCase("cat")) {
                    String[] information = scanner.nextLine().split(" ");
                    Cat cat = new Cat(information[0], information[1], information[2], information[3], information[4]);
                    petList.add(cat);
                }
                else if (line.equalsIgnoreCase("dog")){
                    String[] information = scanner.nextLine().split(" ");
                    Dog dog = new Dog(information[0], information[1], information[2], information[3], information[4]);
                    petList.add(dog);
                }
                else if(line.equalsIgnoreCase("bird")){
                    String[] information = scanner.nextLine().split(" ");
                    Bird bird = new Bird(information[0], information[1], information[2], information[3]);
                    petList.add(bird);
                }
            }
        }
        else {
            System.out.println("File not found. Please choose a valid file!");
        }
    }

    public static void main (String[] args) throws IOException {
        new PetTester("petData.txt");
        //new Screen_GUI();
    }
}
