/**
 * This is the Cat class, and it is a subclass of the pet class. It stores an additional value of hair length.
 * Stores the data values for the pet type of cat.
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 3/16/2022
 */
public class Cat extends Pet{

    //Stores the additional date required for this pet type
    private final String hairLength;

    /**
     * Provides the required data to the constructor of the super class (Pet) to store the required information
     * Also stores the hair length of the cat
     *
     * @param name the name of the pet
     * @param ownerName the name of the cat's owner
     * @param ownerEmail the owner's email address
     * @param color the color of the cat
     * @param hairLength the hair length of the cat
     */
    public Cat(String name, String ownerName, String ownerEmail, String color, String hairLength){
        super(name, ownerName, ownerEmail, color);
        this.hairLength = hairLength;
    }

    /**
     * Returns the hair length of the cat
     *
     * @return hairLength the hair length of the cat
     */
    public String getHairLength(){
        return hairLength;
    }

    /**
     * Formats the data into a way that is readable and understood by the user
     *
     * @return formattedString that contains the formatted information in a readable format that can be displayed to the user
     */
    @Override
    public String toString(){
        return ("CAT:\n" + super.toString() + "\nHair Length: " + getHairLength());
    }
}
