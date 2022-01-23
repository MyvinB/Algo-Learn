package LeetCodeChallenge.JAN2022.practise;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author mmichaelbarboza
 * on 8:00 PM 1/22/2022
 */
public class LCContest70 {

    public static void main(String[] args) {
        int test[] = new int[]{5,5};
        System.out.println(minimumCost(test));

    }

    public static int minimumCost(int[] cost) {
       Arrays.sort(cost);

        int total =0;
        int count=0;
        for(int i=cost.length-1;i>=0;i--){
            count++;
            if(count==3){
                count=0;
            }else total+=cost[i];
        }
//        System.out.println(total);
        return total;
    }



}
