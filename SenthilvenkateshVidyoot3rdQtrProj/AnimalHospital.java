import java.io.File;
import java.io.FileNotFoundException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class AnimalHospital {

    /**
     * constant DASHINGLINE used to separate pet information logs from each other
     */
    private static final String DASHINGLINE = ("****************************************");

    //Using scanner to read in the data file
    public Scanner scanner;

    public File storeFile;

    //An ArrayList storing the list of all pets
    public static ArrayList<Pet> petList = new ArrayList<>();

    //Storing the EndDate and the Duration of the boarding period
    public static LocalDate EndDate;
    public LocalDate durationDate;

    //To minimize magic number use when retrieving numbers through indexes
    public static final int nameIndex = 0;
    public static final int ownerNameIndex = 1;
    public static final int ownerEmailIndex = 2;
    public static final int petColorIndex = 3;
    public static final int genderIndex = 4;
    public static final int otherInformationIndex = 5;

    /**
     * Reads from the text file, and instantiates an object of each pet type corresponding to the type in the text file
     * Supplies the instantiated pet type objects with the required information
     *
     * @param inputFile the file containing the pet logs to read from
     * @throws FileNotFoundException when the file input by the user does not exist
     */
    public AnimalHospital(String inputFile) throws FileNotFoundException {

        //Used to randomize start and end boarding dates
        Random rand = new Random();

        storeFile = new File(inputFile);

        //Making sure that the file exists before trying to read from the file
        boolean isExists = storeFile.exists();

        if (isExists){
            scanner = new Scanner(storeFile);

            //Reading from the text file
            while (scanner.hasNextLine()){

                //Generating random start and end dates that fit within certain boundaries
                LocalDate StartDate = LocalDate.of(rand.nextInt(10) + 2012, rand.nextInt(11)+1, rand.nextInt(28)+1);
                EndDate = StartDate.plus(rand.nextInt(92), ChronoUnit.DAYS);

                //Calculates the duration of the boarding period
                durationDate = EndDate.minus(StartDate.getMonthValue(), ChronoUnit.DAYS);

                String line = scanner.nextLine();

                //Giant block of code to make sure that the right information is passed to the constructors of each pet type
                if (line.equalsIgnoreCase("cat")) {
                    //splits the line by spaces
                    String[] information = scanner.nextLine().split(" ");

                    //supplies information to the corresponding constructor
                    Cat cat = new Cat(information[nameIndex], information[ownerNameIndex], information[ownerEmailIndex], information[petColorIndex], information[otherInformationIndex]);
                    cat.setGender(checkGender(information[genderIndex]));

                    //setting the boarding start and end dates
                    cat.setBoardStart(StartDate.getMonthValue(), StartDate.getDayOfMonth(), StartDate.getYear());
                    cat.setBoardEnd(EndDate.getMonthValue(), EndDate.getDayOfMonth(), EndDate.getYear());

                    //adding this pet to the petList ArrayList
                    petList.add(cat);
                }
                else if (line.equalsIgnoreCase("dog")){
                    //splits the line by spaces
                    String[] information = scanner.nextLine().split(" ");

                    //supplies information to the corresponding constructor
                    Dog dog = new Dog(information[nameIndex], information[ownerNameIndex], information[ownerEmailIndex], information[petColorIndex], information[otherInformationIndex]);
                    dog.setGender(checkGender(information[genderIndex]));

                    //setting the boarding start and end dates
                    dog.setBoardStart(StartDate.getMonthValue(), StartDate.getDayOfMonth(), StartDate.getYear());
                    dog.setBoardEnd(EndDate.getMonthValue(), EndDate.getDayOfMonth(), EndDate.getYear());

                    //adding this pet to the petList ArrayList
                    petList.add(dog);
                }
                else if(line.equalsIgnoreCase("bird")){
                    //splits the line by spaces
                    String[] information = scanner.nextLine().split(" ");

                    //supplies information to the corresponding constructor
                    Bird bird = new Bird(information[nameIndex], information[ownerNameIndex], information[ownerEmailIndex], information[petColorIndex]);
                    bird.setGender(checkGender(information[genderIndex]));

                    //setting the boarding start and end dates
                    bird.setBoardStart(StartDate.getMonthValue(), StartDate.getDayOfMonth(), StartDate.getYear());
                    bird.setBoardEnd(EndDate.getMonthValue(), EndDate.getDayOfMonth(), EndDate.getYear());

                    //adding this pet to the petList ArrayList
                    petList.add(bird);
                }
            }
        }
        else {
            //if the file is not found, an error is output to the terminal
            System.out.println("File not found. Please choose a valid file!");
            throw new FileNotFoundException();
        }
    }

    /**
     * Checks the integer representation of the gender given the string representation
     *
     * @param gender the string representation of the gender
     * @return the integer representation of the gender
     */
    public int checkGender(String gender){
            if (gender.equalsIgnoreCase("Male")) return 0;
            else if (gender.equalsIgnoreCase("Female")) return 1;
            else if (gender.equalsIgnoreCase("Neutered")) return 2;
            else if (gender.equalsIgnoreCase("Spayed")) return 3;
            else {
                return 404;
            }
    }

    /**
     * Prints the pet information given the name of a pet
     *
     * @param name the name of the pet to search for
     * @return the pet that contains the given name or null (if the pet is not found)
     */
    public Pet printPetInfoByName(String name){
        System.out.println(DASHINGLINE);
        for (Pet pets : petList){
            if (pets.getPetName().equalsIgnoreCase(name)){
                System.out.println(pets);
                return pets;
            }
        }
        return null;
    }

    /**
     * Prints the pet information given the name of the pet's owner
     *
     * @param name the owner name to search for
     * @return the pet that contains the given owner's name or null (if the pet is not found)
     */
    public Pet printPetInfoByOwner(String name){
        System.out.println(DASHINGLINE);
        for (Pet pets : petList){
            if (pets.getOwnerName().equalsIgnoreCase(name)){
                System.out.println(pets);
                return pets;
            }
        }
        return null;
    }

    /**
     * Searches for the pets that were boarded during a given time range
     *
     * @param month the month to search for
     * @param day the day to search for
     * @param year the year to search for
     * @return the pets that were boarded during that given period
     * @throws IllegalDateException if the user inputs an invalid date
     */
    public ArrayList<Pet> printPetsBoarding(int month, int day, int year) throws IllegalDateException {
        System.out.println(DASHINGLINE);
        ArrayList<Pet> pets = new ArrayList<>();
        System.out.printf("List of pets boarded on %d / %d / %d \n", month, day, year);
        try {
            for (Pet pet : petList) {
                if (pet.boarding(month, day, year)) {
                    pets.add(pet);
                    System.out.println(pet);
                }
            }
            return pets;
        } catch (DateTimeException e){
            throw new IllegalDateException("Illegal Date Input: ", e.getMessage());
        }
    }

    /**
     * Gets the ArrayList containing all the pets
     *
     * @return the ArrayList of all the pets
     */
    public ArrayList<Pet> getPets() {
        return petList;
    }

}
