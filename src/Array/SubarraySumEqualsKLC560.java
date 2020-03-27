package Array;

import java.util.HashMap;

/*
 @author Myvin Barboza
 27/03/20 8:52 AM 
 */
public class SubarraySumEqualsKLC560 {
    static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            if(map.containsKey(sum-k))count+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a[]={10,2,-2,-20,10};
        System.out.println(subarraySum(a,-10));
    }




}