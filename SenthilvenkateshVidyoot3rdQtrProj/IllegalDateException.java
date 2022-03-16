/**
 * This is the IllegalDateException that is thrown when user does not input a valid date.
 * It is also thrown when the date input is not within the MINDATE and MAXDATE.
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 3/16/2022
 */
public class IllegalDateException extends IllegalArgumentException {
    public IllegalDateException(){}

    /**
     * Takes the message and user input as a parameter
     * Concatenates these strings to form a single message.
     *
     * @param message the unique error message
     * @param input the user input
     */
    public IllegalDateException(String message, String input){
        super(message + input);
    }

}
