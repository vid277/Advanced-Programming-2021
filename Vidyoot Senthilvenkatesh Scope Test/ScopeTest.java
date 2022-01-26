public class ScopeTest {
    private int x;
    private String s;
    private double[] dArray;
    private String[] sArray;

    public ScopeTest(){
        x = 0;
        s = "Hello";
        dArray = new double[5];
        sArray = new String[5];
        toString();
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
        System.out.println("x: " + x + "\n" + "s: " + s);
        return s;
    }

    public String foobar(int x, String s, double[] dArray, String[] sArray){
        return "";
    }

    public static void main(String[] args){

    }
}
