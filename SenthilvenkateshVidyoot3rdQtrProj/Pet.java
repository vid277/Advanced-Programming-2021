import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * This is the pet class that contains the similarities of all pets
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 3/16/2022
 */
public class Pet implements Boardable {

    private final String name;
    private final String ownerName;
    private final String color;
    private String ownerEmail;

    /**
     * The gender of the animal
     */
    protected int Gender;

    //Using the LocalDate class to store the dates that the pet boards and leaves the animal hospital
    private LocalDate boardingStartDate;
    private LocalDate boardingEndDate;

    /**
     * the constant MINDATE and MAXDATE is used to regulate the range that the boarding dates can be within
     */
    private static final LocalDate MINDATE = LocalDate.of(2012, 1, 1);
    private static final LocalDate MAXDATE = LocalDate.of(2022, 12, 31);

    /**
     * The constant EMAIL_VALIDATION_PATTERN is used to later check and validate email addresses
     */
    public static final String EMAIL_VALIDATION_PATTERN = "^(.+)@(\\S+)$";

    /**
     * Instantiates a new Pet. Stores all the values and sets the gender to unspecified.
     *
     * @param name the name of the pet
     * @param ownerName the name of the pet's owner
     * @param ownerEmail the email address of the pet's owner
     * @param color the color of the pet.
     */
    public Pet(String name, String ownerName, String ownerEmail, String color){
        //Setting all the variables
        this.name = name;
        this.ownerName = ownerName;
        setOwnerEmail(ownerEmail);
        this.color = color;

        //Gender is set to 404, which means unspecified (no particular reason behind this, just a number)
        Gender = 404;
    }

    /**
     * Returns the pet name string.
     *
     * @return the string containing the name of the pet
     */
    public String getPetName(){
        return name;
    }

    /**
     * Returns the owner name string.
     *
     * @return the string containing the owner's name
     */
    public String getOwnerName(){
        return ownerName;
    }

    /**
     * Gets the color of the pet
     *
     * @return the color of the pet
     */
    public String getColor() {
        return color;
    }


    /**
     * Sets the gender of the pet as an integer value
     *
     * @param genderId the gender id as an integer value
     */
    public void setGender(int genderId) {
        Gender = genderId;
    }

    /**
     * Returns the gender as a string, in its converted form.
     *
     * @return the gender of the pet in a String format
     */
    public String getGender() {

        //Depending on the integer representation of the gender of the pet, the string representation is returned
        return switch (Gender) {
            case 404 -> "Unspecified";
            case 0 -> "Male";
            case 1 -> "Female";
            case 2 -> "Neutered";
            case 3 -> "Spayed";
            default -> "unspecified";
        };
    }

    /**
     * Gets the email address of the owner
     *
     * @return the email address of the owner
     */
    public String getEmail() {
        return ownerEmail;
    }

    /**
     * This formats the data input into a readable format for clarity and readability
     *
     * @return the formatted string representation of the pet data
     */
    @Override
    public String toString(){
        String finalString;
        finalString = String.format("%s owned by %s\nOwner's email: %s\nPet Color: %s\nGender: %s", getPetName(), getOwnerName(), getEmail(), getColor(), getGender());
        return finalString;
    }

    /**
     * This sets the boarding start date of all the pets in the animal hospital
     * This is the date that the animal is boarding the hospital
     * Error checking performed to ensure that the month, day, and year input are within limits
     * Throws an error when an invalid date is entered
     *
     * @param month the month the animal was initially boarded into the hospital
     * @param day the day the animal was initially boarded into the hospital
     * @param year the year the animal was initially boarded into the hospital
     * @throws IllegalDateException if the date entered by the user is invalid
     */
    public void setBoardStart(int month, int day, int year) throws IllegalDateException{
        //Makes sure that the date does not exceed these values
        //Throws an exception if this happens
        if(month < 0 ||  month > 12 || day < 0 || day > 31) {
            throw new IllegalDateException("Illegal Date:", month + "/" + day + "/"+ year);
        }

        //Creates a new instance of local date once error checking and date validation is performed
        LocalDate StartBoardingDate = LocalDate.of(year, month, day);

        //Makes sure that these conditions are met before the start boarding date cna be set.
        //One important check is to ensure that the end date is not before the start boarding date
        if((boardingEndDate == null || !StartBoardingDate.isAfter(boardingEndDate))){
            if(!StartBoardingDate.isBefore(MINDATE) && StartBoardingDate.isBefore(MAXDATE)) {
                boardingStartDate = StartBoardingDate;
            }
        }

    }

    /**
     * This sets the boarding end date of all the pets in the animal hospital
     * This is the date that the animal leaves the hospital
     * Error checking performed to ensure that the month, day, and year input are within limits
     * Throws an error when an invalid date is entered
     *
     * @param month the month the animal ended boarded
     * @param day the day the animal ended boarded
     * @param year the year the animal ended boarded
     * @throws IllegalDateException if the date entered by the user is invalid
     */
    public void setBoardEnd(int month, int day, int year) throws IllegalDateException{
        LocalDate EndBoardingDate;

        //Makes sure that the date does not exceed these values
        //Throws an exception if this happens
        if(month < 0 ||  month > 12 || day < 0 || day > 31) {
            throw new IllegalDateException("Illegal Date:", month + "/" + day + "/"+ year);
        }
        else {
            //Creates a new instance of local date once error checking and date validation is performed
            EndBoardingDate = LocalDate.of(year, month, day);
        }

        //Makes sure that these conditions are met before the start boarding date cna be set.
        //One important check is to ensure that the end date is not before the start boarding date
        if(boardingStartDate == null || !EndBoardingDate.isBefore(boardingStartDate)){
            if(!EndBoardingDate.isBefore(MINDATE) && !EndBoardingDate.isAfter(MAXDATE)) {
                boardingEndDate = EndBoardingDate;
                return;
            }
        }
    }

    /**
     * Checks whether the pet is boarding at a certain time or not
     *
     * @param month the month the pet is boarding
     * @param day the day the pet is boarding
     * @param year the year the pet is boarding
     * @return whether the pet was boarding the hospital during the given time period
     * @throws IllegalDateException if the date entered by the user is invalid
     */
    public boolean boarding(int month, int day, int year) throws IllegalDateException{

        //Makes sure that the date does not exceed these values
        //Throws an exception if this happens
        if(month < 0 || day < 0 || month > 12 || day > 31) {
            throw new IllegalDateException("Illegal Date:", month + "/" + day + "/"+ year);
        }

        //The values cannot be null.
        if(boardingStartDate == null || boardingEndDate == null)
            return false;

        //Creates a new instance of local date once error checking and date validation is performed
        LocalDate current = LocalDate.of(year, month, day);

        //Ensures that the end date is not before the start boarding date
        if(current.isBefore(MINDATE) || current.isAfter(MAXDATE)) {
            throw new IllegalDateException("Illegal Date:", month + "/" + day + "/"+ year);
        }

        //Compares the boardingStartDate and the boardingEndDate to the date input by the user
        //Used to check whether the date is between these two ranges
        return current.compareTo(boardingStartDate) >= 0 && current.compareTo(boardingEndDate) <= 0;
    }

    /**
     * Gets boarding start date in the LocalDate format
     *
     * @return the boarding start date
     */
    public LocalDate getBoardingStartDate() {
        return boardingStartDate;
    }

    /**
     * Gets boarding end date in a string format
     *
     * @return the boarding end date
     */
    public String getBoardingEndDate() {
        return boardingEndDate.toString();
    }

    /**
     * Set owner email.
     * Error checking is performed prior to the owner email being set to the user input
     *
     * @param ownerEmail the owner email
     * @throws IllegalEmailException if the email input by the user is invalid
     */
    public void setOwnerEmail(String ownerEmail) throws IllegalEmailException {

       //Compares the EMAIL_VALIDATION_PATTERN Regular Expression constant to the owner email
        if (Pattern.compile(EMAIL_VALIDATION_PATTERN).matcher(ownerEmail).matches()){
            this.ownerEmail = ownerEmail;
        }
        else {
            //Throws an IllegalEmailException
            throw new IllegalEmailException("Illegal Email: " + ownerEmail);
        }
    }

    /**
     * Similar to the toString() method, but optimized for the GUI window
     *
     * @return the string that contains the data required to be displayed to the user in a readable format
     */
    public String guiPrint(){
        return String.format("\u2192 %s is owned by %s. Started boarding on %s and ended boarding on %s. \n\n", getPetName().toUpperCase(), getOwnerName(), boardingStartDate, getBoardingEndDate());
    }

}
