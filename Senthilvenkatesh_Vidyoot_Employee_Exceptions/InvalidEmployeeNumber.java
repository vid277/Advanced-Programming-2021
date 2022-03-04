public class InvalidEmployeeNumber extends IllegalArgumentException{
    public InvalidEmployeeNumber(){};
    public InvalidEmployeeNumber(String message, String userInput){
        super(message + userInput);
    }
}
