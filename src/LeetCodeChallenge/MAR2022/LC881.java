package LeetCodeChallenge.MAR2022;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author mmichaelbarboza
 * on 10:30 AM 3/24/2022
 * Time Taken:
 */
public class LC881 {

    public static void main(String[] args) {
        int[] p = new int[]{3,5,3,4};
        int limit = 5;
        System.out.println(numRescueBoats(p,limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int total = 0;
        int count = 0;
        for(int i=0;i<people.length;i++){
            total +=people[i];
            if(total>limit){
                count++;
                total = people[i];
            }
        }
        if(total==limit) count++;
        return count;

    }
}
