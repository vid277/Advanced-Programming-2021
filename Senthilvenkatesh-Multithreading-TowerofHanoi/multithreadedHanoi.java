public class multithreadedHanoi extends Thread{

    public void run(){
        moveDisks(1028,1, 2, 3);
    }

    public int moveDisks(int num, int fromPeg, int toPeg, int TempPeg){
        if (num == 1)
        {
            return -1;
        }
        moveDisks(num-1, fromPeg, TempPeg, toPeg);
        return moveDisks(num-1, TempPeg, toPeg, fromPeg);
    }

    public static void main(String[] args){
        Thread t1 = new Thread(new multithreadedHanoi());
        Thread t2 = new Thread(new multithreadedHanoi());
        Thread t3 = new Thread(new multithreadedHanoi());
        Thread t4 = new Thread(new multithreadedHanoi());
        Thread t5 = new Thread(new multithreadedHanoi());
        Thread t6 = new Thread(new multithreadedHanoi());
        Thread t7 = new Thread(new multithreadedHanoi());
        Thread t8 = new Thread(new multithreadedHanoi());
        Thread t9 = new Thread(new multithreadedHanoi());
        Thread t10 = new Thread(new multithreadedHanoi());
        Thread t11 = new Thread(new multithreadedHanoi());
        Thread t12 = new Thread(new multithreadedHanoi());
        Thread t13 = new Thread(new multithreadedHanoi());
        Thread t14 = new Thread(new multithreadedHanoi());
        Thread t15 = new Thread(new multithreadedHanoi());
        Thread t16 = new Thread(new multithreadedHanoi());
        Thread t18 = new Thread(new multithreadedHanoi());
        Thread t19 = new Thread(new multithreadedHanoi());
        Thread t20 = new Thread(new multithreadedHanoi());
        Thread t21 = new Thread(new multithreadedHanoi());
        Thread t22 = new Thread(new multithreadedHanoi());
        Thread t23 = new Thread(new multithreadedHanoi());
        Thread t24 = new Thread(new multithreadedHanoi());
        Thread t25 = new Thread(new multithreadedHanoi());
        Thread t26 = new Thread(new multithreadedHanoi());
        Thread t27 = new Thread(new multithreadedHanoi());
        Thread t28 = new Thread(new multithreadedHanoi());
        Thread t29 = new Thread(new multithreadedHanoi());
        Thread t30 = new Thread(new multithreadedHanoi());
        Thread t31 = new Thread(new multithreadedHanoi());
        Thread t32 = new Thread(new multithreadedHanoi());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();
        t16.start();
        t18.start();
        t19.start();
        t20.start();
        t21.start();
        t22.start();
        t23.start();
        t24.start();
        t25.start();
        t26.start();
        t27.start();
        t28.start();
        t29.start();
        t30.start();
        t31.start();
        t32.start();
    }

}
