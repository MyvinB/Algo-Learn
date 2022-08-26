package Company.Concepts.Practise;

public class ThreadsQuestions {

    public static void main(String[] args) {
        //Print even and odd numbers
        ThreadsQuestions t = new ThreadsQuestions();
//        t.printEvenAndOdd();
        //Show dead lock using code
        t.simulateDeadlock();
        //Reduce threads where in you do sum of 10 numbers using threads

    }


    public void simulateDeadlock(){
        String resource1 = "Just1";
        String resource2 = "Just2";
        Thread t = new Thread(()->{
            synchronized (resource1){
                System.out.println("I am waiting for lock to release on resource 2 and have acquired the lock on resource 1");
                synchronized (resource2){

                }
            }
        });

        Thread p = new Thread(()->{
            synchronized (resource2){
                System.out.println("I am waiting for lock to release on resource 1 and have acquired the lock on resource 2");
                synchronized (resource1){

                }
            }
        });
        t.start();
        p.start();
    }

    public void printEvenAndOdd(){
        Printer p = new Printer();
        Thread t = new Thread(new EvenAndOdd(10,p,false),"Odd");
        Thread t1 = new Thread(new EvenAndOdd(10,p,true),"Even");
        t.start();
        t1.start();
    }



    class EvenAndOdd implements Runnable{
        int max;
        private Printer printer;
        private boolean isEvenNumber;

        public EvenAndOdd(int max, Printer printer, boolean isEvenNumber) {
            this.max = max;
            this.printer = printer;
            this.isEvenNumber = isEvenNumber;
        }

        @Override
        public void run() {
            int number = isEvenNumber?2:1;
            while(number<=max){
                if(isEvenNumber){
                    printer.printEven(number);
                }else printer.printOdd(number);
                number +=2;
            }
        }
    }

    class Printer{
        private volatile boolean isEven;
       synchronized void printEven(int number){
           while(!isEven){
               try {
                   wait();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
           isEven = false;
           System.out.println(number+" Thread name "+Thread.currentThread().getName());
           notify();
       }

        synchronized void printOdd(int number){
            while(isEven){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(number+" Thread name "+Thread.currentThread().getName());
            isEven = true;
            notify();
        }
    }
}
