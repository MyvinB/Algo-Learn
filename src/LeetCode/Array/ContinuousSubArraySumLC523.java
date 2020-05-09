package LeetCode.Array;

import java.util.HashMap;

/*
 @author Myvin Barboza
 27/03/20 7:35 PM
 link:https://www.youtube.com/watch?v=wsTcByj8QbI
 */
public class ContinuousSubArraySumLC523 {

    static boolean checkSubarraySum(int[] nums, int k) {
        int preSum=0;
        HashMap<Integer ,Integer> map=new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i <nums.length ; i++) {

                preSum+=nums[i];
                if(k!=0)preSum%=k;
                if(map.containsKey(preSum)){
                    if(i-map.get(preSum)>=2) return true;
                }
                else map.put(preSum,i);


        }
        return false;
    }




    public static void main(String[] args) {
    int a[]={0,1,0};
        System.out.println(checkSubarraySum(a,0));

    }
}