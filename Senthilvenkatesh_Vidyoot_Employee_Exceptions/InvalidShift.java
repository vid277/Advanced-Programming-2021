public class InvalidShift extends Exception{
    public InvalidShift(){};

    public InvalidShift(String message, int shift){
        super(message + shift);
    }
}
