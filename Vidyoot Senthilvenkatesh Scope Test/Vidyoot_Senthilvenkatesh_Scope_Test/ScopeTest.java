/**
 * This class is supposed to demonstrate the difference of passing by value versus passing by reference
 * 
 * @Author: Vidyoot Senthilvenkatesh
 * @Date: 1/25/2022
 **/ 

public class ScopeTest {
    
    //Initializing required variables
    private int x = 3;
    private String s = "Hello";
    private double[] dArray = new double[5];
    private String[] sArray = new String[5];

    //Constructor for this class
    //Sets initial values for all the required variables
    public ScopeTest(){

        for (int i = 0; i < 5; i++){
            dArray[i] = i;
        }

        sArray[0] = "Hi";
        sArray[1] = "Hello";
        sArray[2] = "How are you?";
        sArray[3] = "I am good";
        sArray[4] = "Ok";
    
        //Calling the methods
        System.out.println(toString());
        System.out.println(foobar(x, s, dArray, sArray));
        System.out.println(toString());
    }

    //The getter method for the first string
    public String getS(){
        return s;
    }

    //The getter method for the first integer
    public int getX() {
        return x;
    }

    //The getter method for the first Double array
    public double[] getDA() {
        return dArray;
    }

    //The getter method for the first String array
    public String[] getSA() {
        return sArray;
    }

    /*  Formats and prints the strings
    *   Appends the elements from the Double and String array to a larger string
    *
    *   @return the final string that contains the concatenated output
    */
    public String toString(){
        String finalOutput = String.format("X: %d  and  S: %s \n", x, s);

        for (int i = 0; i < dArray.length; i++){
            String output = String.format("Element %d = %f  ", i, dArray[i]);
            finalOutput =  finalOutput + output;
        }

        finalOutput += "\n";
        
        for (int i = 0; i < sArray.length; i++){
            String output = String.format("Element %d = %s  ", i, sArray[i]);
            finalOutput =  finalOutput + output;
        }

        return finalOutput;
    }

    /*  Formats and edits all the variables
    *   Changes the values in the String and Double arrays;
    *
    *   @param the variables that have to be changed
    *   @return the final string that contains the concatenated output
    */
    public String foobar(int x1, String s1, double[] dArray1, String[] sArray1){
        x1 = x1 +3;
        s1 = s1.substring(0, 3);

        for (int i = 0; i < dArray.length; i++){
            dArray1[i] = i*2;
            sArray1[i] = sArray1[i].substring(0, 1);
        }

        String finalOutput = String.format("X: %d  and  S: %s   \n", x, s);

        for (int i = 0; i < dArray.length; i++){
            String output = String.format("Element %d = %f  ", i, dArray1[i]);
            finalOutput =  finalOutput + output;
        }
        
        finalOutput += "\n";
        
        for (int i = 0; i < sArray.length; i++){
            String output = String.format("Element %d = %s  ", i, sArray1[i]);
            finalOutput =  finalOutput + output;
        }

        return finalOutput;
    }

    
    //This is the main method
    //Initializes the ScopeTest object
    public static void main(String[] args){
        new ScopeTest();
    }
}
