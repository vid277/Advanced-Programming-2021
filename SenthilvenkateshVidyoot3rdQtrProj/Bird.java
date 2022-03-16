/**
 * This is the bird class, and it is a subclass of the pet class.
 * Stores the data values for the pet type of bird.
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 3/16/2022
 */
public class Bird extends Pet{

    //Stores whether the bird's feather has been clipped or not
    private boolean featherClipped;

    /**
     * Provides the required data to the constructor of the super class (Pet) to store the required information.
     *
     * @param name the name of the pet
     * @param ownerName the name of the cat's owner
     * @param ownerEmail the owner's email address
     * @param color the color of the cat
     */
    public Bird(String name, String ownerName, String ownerEmail, String color){
        super(name, ownerName, ownerEmail, color);
    }

    /**
     * This method is used to set the value of the featherClipped variable to true
     * Used when the feather of a bird is clipped
     */
    public void setClipped(){
        featherClipped = true;
    }

    /**
     * Returns whether the bird's feathers are clipped
     *
     * @return whether the birds' feathers are clipped
     */
    public boolean clipped(){
        return featherClipped;
    }

    /**
     * Creates a formatted string that contains all the required information in a much more readable format
     *
     * @return a formatted string that is understandable by the user
     */
    @Override
    public String toString(){
        return "BIRD:\n" + super.toString() + "\nFeathers Clipped: " + clipped() + "\n";
    }

}
