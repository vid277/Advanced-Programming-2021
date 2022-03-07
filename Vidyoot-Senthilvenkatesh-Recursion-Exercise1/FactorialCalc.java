public class FactorialCalc {
    public int factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            System.out.println(num);
            return num * this.factorial(num - 1);
        }
    }

    public static void main(String[] args) {
        FactorialCalc obj1 = new FactorialCalc();
        System.out.println(obj1.factorial(8));
    }
}
