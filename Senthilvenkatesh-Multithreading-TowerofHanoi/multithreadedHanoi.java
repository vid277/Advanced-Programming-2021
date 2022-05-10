public class multithreadedHanoi extends Thread{

    public void run(){
        moveDisks(64,1, 2, 3);
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
    }

}
