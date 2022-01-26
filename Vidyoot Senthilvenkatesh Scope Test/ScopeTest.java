package Vidyoot_Senthilvenkatesh_ScopeTest;

public class ScopeTest {
    private int x = 3;
    private String s = "Hello";
    private double[] dArray = new double[5];
    private String[] sArray = new String[5];

    public ScopeTest(){

        for (int i = 0; i < 5; i++){
            dArray[i] = i;
        }

        sArray[0] = "Hi";
        sArray[1] = "Hello";
        sArray[2] = "How are you?";
        sArray[3] = "I am good";
        sArray[4] = "Ok";

        System.out.println(toString());
        System.out.println(foobar(x, s, dArray, sArray));
        System.out.println(toString());
    }

    public String getS(){
        return s;
    }

    public int getX() {
        return x;
    }

    public double[] getDA() {
        return dArray;
    }

    public String[] getSA() {
        return sArray;
    }

    public String toString(){
        String finalOutput = String.format("X: %d  and  S: %s \n", x, s);

        for (int i = 0; i < dArray.length; i++){
            String output = String.format("Element %d = %f  \n", i, dArray[i]);
            finalOutput =  finalOutput + output;
        }

        for (int i = 0; i < sArray.length; i++){
            String output = String.format("Element %d = %s  \n", i, sArray[i]);
            finalOutput =  finalOutput + output;
        }

        return finalOutput;
    }

    public String foobar(int x, String s, double[] dArray, String[] sArray){
        x = x+3;
        s = s.substring(0, 3);

        for (int i = 0; i < dArray.length; i++){
            dArray[i] = i*2;
            sArray[i] = sArray[i].substring(0, 1);
        }

        String finalOutput = String.format("X: %d  and  S: %s \n", x, s);

        for (int i = 0; i < dArray.length; i++){
            String output = String.format("Element %d = %f  \n", i, dArray[i]);
            finalOutput =  finalOutput + output;
        }

        for (int i = 0; i < sArray.length; i++){
            String output = String.format("Element %d = %s  \n", i, sArray[i]);
            finalOutput =  finalOutput + output;
        }

        return finalOutput;
    }

    public static void main(String[] args){
        new ScopeTest();
    }
}
