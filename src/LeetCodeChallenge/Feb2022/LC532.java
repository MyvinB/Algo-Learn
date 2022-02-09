package LeetCodeChallenge.Feb2022;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 9:40 AM 2/9/2022
 * Time Taken:
 */
public class LC532 {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,4,4,3,3,0,9,2,3};
        System.out.println(findPairs(t,3));
    }

    public static int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count=0;
        for(Integer t:map.keySet()){
            if(k!=0 &&  map.containsKey(t+k)){

                count++;
            }else if( k==0 && map.get(t)>=2){
                count++;
            }
        }
        return count;
    }
}
