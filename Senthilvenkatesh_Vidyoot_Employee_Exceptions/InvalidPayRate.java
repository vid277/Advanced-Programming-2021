public class InvalidPayRate extends IllegalArgumentException {
    public InvalidPayRate(){};
    public InvalidPayRate(String message, double exceptionValue) {
        super(message + exceptionValue);
    }
}
