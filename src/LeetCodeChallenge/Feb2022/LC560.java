package LeetCodeChallenge.Feb2022;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 12:27 PM 2/10/2022
 * Time Taken:
 */
public class LC560 {

    public static void main(String[] args) {

    }

    public int subarraySum(int[] A, int k) {
        int preSum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0;
        for(int i=0;i<A.length;i++){
            preSum+=A[i];
            if(map.containsKey(preSum-k)){
                count+=map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}
