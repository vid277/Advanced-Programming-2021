/**
 * This is the IllegalEmailException that is thrown when user does not input a valid email.
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 3/16/2022
 */
public class IllegalEmailException extends IllegalArgumentException {
    public IllegalEmailException(){}

    /**
     * The concatenated string containing the unique error message and user input as a message
     *
     * @param message the unique error message
     */
    public IllegalEmailException(String message){
        super(message);
    }
}
