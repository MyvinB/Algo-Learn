package LeetCodeChallenge.MAR2022;

import java.util.Arrays;
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
        Arrays.sort(people);
        int low = 0;
        int high = people.length-1;
        int count = 0;
        while(low<=high){
            int sum = people[low]+people[high];
            if(sum<=limit) {
                count++;
                low++;
                high--;
            }
            else {
                high--;
                count++;
            }
        }
        return count;


    }
}
