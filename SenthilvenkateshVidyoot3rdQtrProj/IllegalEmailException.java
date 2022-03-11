public class IllegalEmailException extends IllegalArgumentException {
    public IllegalEmailException(){}

    public IllegalEmailException(String message, String input){
        super(message + input);
    }
}
