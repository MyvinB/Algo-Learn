package Company.Concepts.Practise;

/**
 * @author mmichaelbarboza
 * on 10:22 AM 2/19/2022
 * Time Taken:
 */


class PrintEvenAndOddNumber implements Runnable {
    private int max;
    private int isEvenNumber;
    private static Object lock = new Object();
    public PrintEvenAndOddNumber(int max,int isEvenNumber) {
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }
    static Integer number = 1;
    @Override
    public void run() {
    while(number<10){
        synchronized (lock) {
            try {
                while (number % 2 != isEvenNumber) {
                    lock.wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " " + number);
            number++;
            lock.notifyAll();
    }

        }
    }



}


public class PrintEvenAndOdd{
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintEvenAndOddNumber(10,1),"Odd");
        Thread t2 = new Thread(new PrintEvenAndOddNumber(10,0),"Even");
        t1.start();
        t2.start();

    }
}

