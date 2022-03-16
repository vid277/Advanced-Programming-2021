import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This is the tester class, which is used to test the class for any exceptions and any errors that may occur
 * This also tests all the important methods of the animal hospital
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 3/15/2022
 */
public class PetTester {

    /**
     * This is the constructor that takes in the file name as the input.
     *
     * @param nameOfFile the name of the file that is processed and acts as a log file
     * @throws FileNotFoundException when the file does not exist or is not found, an error is thrown.
    */
    public PetTester(String nameOfFile) throws FileNotFoundException {

        //Creates an object of the Animal Hospital class
        //Passes in the name of the file as the input
        AnimalHospital trial1 = new AnimalHospital(nameOfFile);

        //Used for testing and validation purposes
        //Since boarding dates are randomized, this allows us to set an animal to board on a certain date, only for testing purposes.
        trial1.getPets().get(0).setBoardStart(10, 10, 2017);
        trial1.getPets().get(0).setBoardEnd(10, 12, 2017);

        //Just labels
        System.out.println();
        System.out.println("Printing information given pet name");
        System.out.println();

        // This is used to print the pet information given the name of the pet
        trial1.printPetInfoByName("smiley");
        trial1.printPetInfoByName("Oakley");
        trial1.printPetInfoByName("Patankar");

        System.out.println();
        System.out.println("Printing information given owner name");
        System.out.println();

        // This is used to print the pet information given the name of the owner
        trial1.printPetInfoByOwner("Sanders");
        trial1.printPetInfoByOwner("Oakley");
        trial1.printPetInfoByOwner("Smith");

        trial1.printPetsBoarding(11, 10, 2022);
        trial1.printPetsBoarding(12, 14, 2012);

        // This is the test print to ensure that an animal that has a certain boarding date is between these ranges
        // Mainly for testing purposes
        trial1.printPetsBoarding(10, 11, 2017);

        //This is mostly for testing purposes to ensure that the IllegalDateException are caught
        //The input is incorrect because month '13' does not exist, which outputs an error
        try{
            trial1.printPetsBoarding(13, 11, 2011);
        } catch (IllegalDateException e) {
            System.out.println(e);
        }

        //This is again for mostly testing purposes to ensure that IllegalEmailException are caught
        //The input is incorrect because an email should not contain '$', which throws an error
        try{
            trial1.getPets().get(1).setOwnerEmail("vidyoots$email.com");
        } catch (IllegalEmailException e) {
            System.out.println(e);
        }

    }

    /**
     * This is the main method that is supposed to start the tester class as well as the gui
     *
     * @param args - the args passed into this function when run
     * @throws IOException - when the file provided by the user does not exist
     */
    public static void main (String[] args) throws IOException {
        //Used to display terminal output
        new PetTester("petData.txt");

        //Full GUI with many additional and cool features
        new Screen_GUI();
    }
}
