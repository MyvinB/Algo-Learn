package Company.Concepts.Practise;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 5:51 AM 2/8/2022
 * Time Taken:
 */
public class Java8 {



    interface Condition{
        boolean isApp(int n);
    }

    private static int sum (int[] A,Condition condition){
        int result =0;
        for(int i=0;i<A.length;i++){
            result+=condition.isApp(A[i])?A[i]:0;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(sum(new int[]{1,2,3,4,5,6},(n)->n%2==0));
        List<String> temp = Arrays.asList(new String[]{"Shakira","Myvin","Mylis","Ankita","Rahul","Brajesh","Neha"});
        temp.stream().filter((s)->s.startsWith("M")).forEach(System.out::print);
        System.out.println();
        temp.stream().sorted((a,b)->b.compareTo(a)).forEach(System.out::print);
        System.out.println();
        temp.stream().map(String::toUpperCase).forEach(System.out::print);
        System.out.println();
        System.out.println(temp.stream().filter((s)->s.startsWith("M")).count());

    }
}
