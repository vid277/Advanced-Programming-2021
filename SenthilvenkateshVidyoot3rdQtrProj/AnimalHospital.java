import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Random;


public class AnimalHospital {

    private static final String DASHINGLINE = ("****************************************");

    public Scanner scanner;
    public File storeFile;

    public static ArrayList<Pet> petList = new ArrayList<Pet>();

    public LocalDate StartDatesBoarding;
    public LocalDate EndDate;
    public LocalDate durationDate;

    public static final int nameIndex = 0;
    public static final int ownerNameIndex = 1;
    public static final int ownerEmailIndex = 2;
    public static final int petColorIndex = 3;
    public static final int genderIndex = 4;
    public static final int otherInformationIndex = 5;

    public AnimalHospital(String inputFile) throws FileNotFoundException {
        Random rand = new Random();

        StartDatesBoarding = LocalDate.of(rand.nextInt(10) + 2012, rand.nextInt(11)+1, rand.nextInt(30)+1);

        storeFile = new File(inputFile);

        boolean isExists = storeFile.exists();

        if (isExists){
            scanner = new Scanner(storeFile);

            LocalDate StartDate = StartDatesBoarding.plus(rand.nextInt(100), ChronoUnit.DAYS);
            EndDate = StartDate.plus(rand.nextInt(121), ChronoUnit.DAYS);

            durationDate = EndDate.minus(StartDate.getMonthValue(), ChronoUnit.DAYS);

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();

                if (line.equalsIgnoreCase("cat")) {
                    String[] information = scanner.nextLine().split(" ");
                    Cat cat = new Cat(information[nameIndex], information[ownerNameIndex], information[ownerEmailIndex], information[petColorIndex], information[otherInformationIndex]);
                    cat.setGender(checkGender(information[genderIndex]));
                    cat.setBoardStart(StartDate.getMonthValue(), StartDate.getDayOfMonth(), StartDate.getYear());
                    cat.setBoardEnd(EndDate.getMonthValue(), EndDate.getDayOfMonth(), EndDate.getYear());
                    petList.add(cat);
                }
                else if (line.equalsIgnoreCase("dog")){
                    String[] information = scanner.nextLine().split(" ");
                    Dog dog = new Dog(information[nameIndex], information[ownerNameIndex], information[ownerNameIndex], information[petColorIndex], information[otherInformationIndex]);
                    dog.setGender(checkGender(information[genderIndex]));
                    dog.setBoardStart(StartDate.getMonthValue(), StartDate.getDayOfMonth(), StartDate.getYear());
                    dog.setBoardEnd(EndDate.getMonthValue(), EndDate.getDayOfMonth(), EndDate.getYear());
                    petList.add(dog);
                }
                else if(line.equalsIgnoreCase("bird")){
                    String[] information = scanner.nextLine().split(" ");
                    Bird bird = new Bird(information[nameIndex], information[ownerNameIndex], information[ownerNameIndex], information[petColorIndex]);
                    bird.setGender(checkGender(information[genderIndex]));
                    bird.setBoardStart(StartDate.getMonthValue(), StartDate.getDayOfMonth(), StartDate.getYear());
                    bird.setBoardEnd(EndDate.getMonthValue(), EndDate.getDayOfMonth(), EndDate.getYear());
                    petList.add(bird);
                }
            }
        }
        else {
            System.out.println("File not found. Please choose a valid file!");
        }
    }

    public int checkGender(String gender){
            if (gender.equalsIgnoreCase("Male")) return 0;
            else if (gender.equalsIgnoreCase("Female")) return 1;
            else if (gender.equalsIgnoreCase("Neutered")) return 2;
            else if (gender.equalsIgnoreCase("Spayed")) return 3;
            else {
                return 404;
            }
    }


    public void printPetInfoByName(String name){
        System.out.println(DASHINGLINE);
        for (Pet pets : petList){
            if (pets.getPetName().equalsIgnoreCase(name)){
                System.out.println(pets);
            }
        }
        System.out.println(DASHINGLINE);
    }

    public void printPetInfoByOwner(String name){
        System.out.println(DASHINGLINE);
        for (Pet pets : petList){
            if (pets.getOwnerName().equalsIgnoreCase(name)){
                System.out.println(pets);
            }
        }
    }

    public void printPetsBoarding(int month, int day, int year) throws IllegalDateException{
        System.out.println(DASHINGLINE);
        System.out.printf("List of pets boarded on %d / %d / %d", month, day, year);
        for (Pet pets : petList){
            if (pets.boarding(month, day, year)){
                System.out.println(pets);
            }
        }

    }

    public ArrayList<Pet> getPets() {
        return petList;
    }

}
