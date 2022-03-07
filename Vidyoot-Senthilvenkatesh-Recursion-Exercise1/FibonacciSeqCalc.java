class fibonacciSeq {
    fibonacciSeq() {
    }

    static int fibo(int numb) {
        return numb <= 1 ? numb : fibo(numb - 1) + fibo(numb - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibo(9));
    }
}
