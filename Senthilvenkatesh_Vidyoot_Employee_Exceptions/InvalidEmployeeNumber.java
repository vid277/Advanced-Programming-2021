public class InvalidEmployeeNumber extends Exception{
    public InvalidEmployeeNumber(String message, String userInput){
        super(message + userInput);
    }
}
