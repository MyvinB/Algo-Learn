package Company.ZopSmart;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 11:58 AM 2/3/2022
 * Time Taken:
 */
public class LC560 {
    public static void main(String[] args) {
        int t[] = new int[]{3,4,7,2,-3,1,4,2};
        System.out.println(subarraySum(t,7));
    }

    public static int subarraySum(int[] A, int k) {
        int preSum=0;int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<A.length;i++){
            preSum += A[i];
            if(map.containsKey(preSum-k)){
                count+=map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;

    }
}
