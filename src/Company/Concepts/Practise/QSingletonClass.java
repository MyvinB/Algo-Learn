package Company.Concepts.Practise;

/**
 * @author mmichaelbarboza
 * on 9:52 AM 3/2/2022
 * Time Taken:
 */
public class QSingletonClass {


    static class Singleton {
        private static Singleton singletonInstance;
        public String s;
        private Singleton(){
            System.out.println("Constructor is called once during object creation");
            s = "I am the string of singleton class";
        }

        public static Singleton getSingletonInstance(){
            if(singletonInstance==null){
                singletonInstance = new Singleton();
            }
            return singletonInstance;
        }
    }

    public static void main(String[] args) {
        Singleton.getSingletonInstance();
        System.out.println(Singleton.getSingletonInstance().s);
    }


}
