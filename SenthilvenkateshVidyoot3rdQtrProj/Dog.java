/**
 * This is the dog class, and it is a subclass of the pet class. It stores an additional value of size.
 * Stores the data values for the pet type of dog.
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 3/16/2022
 */
public class Dog extends Pet{

    //Stores the additional value of size that is required for each dog
    private final String size;

    /**
     * Provides the required data to the constructor of the super class (Pet) to store the required information
     * Also stores the size of the dog
     *
     * @param name the name of the pet
     * @param ownerName the name of the dog's owner
     * @param ownerEmail the owner's email address
     * @param color the color of the dog
     * @param size the size of the dog
     */
    public Dog(String name, String ownerName, String ownerEmail, String color, String size) {
        super(name, ownerName, ownerEmail, color);
        this.size = size;
    }

    /**
     * Returns the size of the dog
     *
     * @return the size of the dog
     */
    public String getSize() {
        return size;
    }

    /**
     * Makes a formatted string that contains the data parsed into a readable manner, for user readability.
     *
     * @return a formatted string representation of the data about the dog
     */
    public String toString(){
        return "Dog:\n" + super.toString() + "\n Size: " + getSize();
    }

}
