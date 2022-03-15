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
        try{
            AnimalHospital trial1 = new AnimalHospital(nameOfFile);
            trial1.printPetInfoByName("smiley");
            trial1.printPetInfoByOwner("Sanders");
            trial1.printPetsBoarding(11, 10, 2021);
        } catch (IllegalEmailException | IllegalDateException e){
            System.out.println(e);
        }

        //trial1.printPetsBoarding();
    }

    public static void main (String[] args) throws IOException {
        new PetTester("petData.txt");
        //new Screen_GUI();
    }
}
