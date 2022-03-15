public class IllegalDateException extends IllegalArgumentException {
    public IllegalDateException(){}

    public IllegalDateException(String message, String input){
        super(message + input);
    }

}
