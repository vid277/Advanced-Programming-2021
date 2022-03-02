public class InvalidPayRate extends Exception{
    public InvalidPayRate(String message, double exceptionValue) {
        super(message + exceptionValue);
    }
}
