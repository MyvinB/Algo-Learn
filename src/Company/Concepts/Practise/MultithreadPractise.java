package Company.Concepts.Practise;

public class MultithreadPractise {

    public static void main(String[] args) {
//        printEvenAndOdd();
        printNumbers();
    }

//Q1-----------------------------------------------------------------------------------------------------------------------------------------------Printing Even and Odd using threads

    public static void printEvenAndOdd(){
        Printer p = new Printer(10);
        Runnable r1 = ()->{
            p.printOddNumber();
        };
        Runnable r2 = ()->{
            p.printEvenNumber();
        };
        Thread t1 = new Thread(r1,"Odd");
        Thread t2 = new Thread(r2,"Even");
        t1.start();
        t2.start();
    }

    static class Printer{
        int count = 0;
        static int N;

        Printer(int n){
            this.N = n-1; //Taking into consideration that the last odd thread will be in the wait state and waiting for it to increment
        }

        public void printEvenNumber(){
            synchronized (this){
                while(count<N){
                    while(count%2==0) { //while to avoid sporadic behaviour of await and also blocking if it is even wait for it to become odd
                        try{            //Aso to see if the count is even so increment operation can be done.
                           wait();
                        } catch (InterruptedException e){

                        }
                    }
                    ++count;
                    System.out.println(Thread.currentThread().getName()  + " Even  has incremented to  " + count);
                    notify();
                    }
                }
        }

        public void printOddNumber(){
            synchronized (this){
                while(count<N){
                    while(count%2!=0) { //while to avoid sporadic behaviour of wait // if its odd wait for it to become even then only we can increment
                        try{            //Aso to see if the count is even so increment operation can be done.
                            wait();
                        } catch (InterruptedException e){

                        }
                    }
                    ++count;
                    System.out.println(Thread.currentThread().getName() + " Odd has incremented to   " + count);
                    notify();

                }
            }
        }
    }

//Q1  EOL-----------------------------------------------------------------------------------------------------------------------------------------------Printing Even and Odd using threads
//Q2  SOL-----------------------------------------------------------------------------------------------------------------------------------------------Printing Even and Odd using threads
//    T1 1
//    T2 2
//    T3 3
//    T1 4
//    T2 5
//    T3 6
//    T1 7
//    T2 8
//    T3 9
//    T1 10


    public static void printNumbers(){
        NumberGenrator a  = new NumberGenrator(3,100);
        Runnable r1 = ()->{
            a.printNumber(0);
        };
        Runnable r2 = ()->{
            a.printNumber(1);
        };
        Runnable r3 = ()->{
            a.printNumber(2);
        };
        Thread t1 = new Thread(r1); t1.start();
        Thread t2 = new Thread(r2); t2.start();
        Thread t3 = new Thread(r3); t3.start();
    }

    static public class NumberGenrator{
        int numOfThread;
        int N;
        int count = 0;
        int threadId ;

        NumberGenrator(int numOfThread,int N){
            this.numOfThread = numOfThread;
            this.N = N-(numOfThread-1); //Reason same as odd even there will be thread in waiting and its last while will only test  while(count%numOfThread!=id){ even when the increment is already done by other threads

        }

        public void printNumber(int id){
            synchronized (this){
                while(count<N){
                    while(count%numOfThread!=id){
                        try{            //Aso to see if the count is even so increment operation can be done.
                            wait();
                        } catch (InterruptedException e){

                        }
                    }
                    ++count;
                    System.out.println(Thread.currentThread().getName() + " increment  " + count);
                    notifyAll();
                }
            }

        }

    }
//Q2  EOL-----------------------------------------------------------------------------------------------------------------------------------------------Printing Even and Odd using threads

    }

