import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class AnimalHospital {

    private static final String DASHING_LINE = ("****************************************");

    public Scanner scanner;
    public File storeFile;

    public static ArrayList<Pet> petList = new ArrayList<>();

    public static LocalDate EndDate;
    public LocalDate durationDate;

    public static final int nameIndex = 0;
    public static final int ownerNameIndex = 1;
    public static final int ownerEmailIndex = 2;
    public static final int petColorIndex = 3;
    public static final int genderIndex = 4;
    public static final int otherInformationIndex = 5;

    public AnimalHospital(String inputFile) throws FileNotFoundException {
        Random rand = new Random();

        storeFile = new File(inputFile);

        boolean isExists = storeFile.exists();

        if (isExists){
            scanner = new Scanner(storeFile);

            LocalDate StartDate = LocalDate.of(rand.nextInt(10) + 2012, rand.nextInt(11)+1, rand.nextInt(28)+1);
            EndDate = StartDate.plus(rand.nextInt(92), ChronoUnit.DAYS);

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
                    Dog dog = new Dog(information[nameIndex], information[ownerNameIndex], information[ownerEmailIndex], information[petColorIndex], information[otherInformationIndex]);
                    dog.setGender(checkGender(information[genderIndex]));
                    dog.setBoardStart(StartDate.getMonthValue(), StartDate.getDayOfMonth(), StartDate.getYear());
                    dog.setBoardEnd(EndDate.getMonthValue(), EndDate.getDayOfMonth(), EndDate.getYear());
                    petList.add(dog);
                }
                else if(line.equalsIgnoreCase("bird")){
                    String[] information = scanner.nextLine().split(" ");
                    Bird bird = new Bird(information[nameIndex], information[ownerNameIndex], information[ownerEmailIndex], information[petColorIndex]);
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


    public Pet printPetInfoByName(String name){
        System.out.println(DASHING_LINE);
        for (Pet pets : petList){
            if (pets.getPetName().equalsIgnoreCase(name)){
                System.out.println(pets);
                return pets;
            }
        }
        System.out.println(DASHING_LINE);
        return null;
    }

    public Pet printPetInfoByOwner(String name){
        System.out.println(DASHING_LINE);
        for (Pet pets : petList){
            if (pets.getOwnerName().equalsIgnoreCase(name)){
                System.out.println(pets);
                return pets;
            }
        }
        return null;
    }

    public Pet printPetsBoarding(int month, int day, int year) throws IllegalDateException{
        System.out.println(DASHING_LINE);
        System.out.printf("List of pets boarded on %d / %d / %d \n", month, day, year);
        System.out.println("reached");
        for (Pet pets : petList){
            if (pets.getBoardingStartDate().compareTo(LocalDate.of(year, month, day))==0){
                  System.out.println(pets);
                  return pets;
            }
        }
        return null;
    }

    public ArrayList<Pet> getPets() {
        return petList;
    }

}
