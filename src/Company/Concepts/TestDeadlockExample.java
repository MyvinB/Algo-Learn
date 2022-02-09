package Company.Concepts;

/**
 * @author mmichaelbarboza
 * on 10:25 PM 2/7/2022
 * Time Taken:
 */
public class TestDeadlockExample {
    public static void main(String[] args) {
        final String resource1 = "panda myvin";
        final String resource2 = "myvin panda";
        Thread t1 = new Thread(){
            public void run(){
                synchronized (resource1){
                    System.out.println("Thread one locked resource 1");

                    synchronized (resource2){
                        System.out.println("Thread 1 now locked resource 2 ");
                    }
                }
            }

        };
        Thread t2 = new Thread(){
            public void run(){
                synchronized (resource2){
                    System.out.println("Thread two locked resource 2");

                    synchronized (resource1){
                        System.out.println("Thread one locked resource one");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
