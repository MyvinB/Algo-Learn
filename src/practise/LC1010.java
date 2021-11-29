package practise;

import java.util.Arrays;
import java.util.HashMap;

/**
 *@author mmichaelbarboza
 * on 5:19 PM 11/27/2021
 */public class LC1010 {

    public static void main(String[] args) {
        int[] nums = new int[] {439,407,197,191,291,486,30,307,11};
        System.out.println(numPairsDivisibleBy60(nums));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int res =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<time.length;i++){
            if(time[i]%60 == 0){
                res += map.getOrDefault(time[i]%60,0);
            }
            else res+= map.getOrDefault(60-time[i]%60,0);

            map.put(time[i]%60,map.getOrDefault(time[i]%60,0)+1);
        }
        return res;
    }




}
