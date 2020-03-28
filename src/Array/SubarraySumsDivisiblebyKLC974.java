package Array;

import java.util.HashMap;

/*
 @author Myvin Barboza
 28/03/20 7:18 AM 
 */public class SubarraySumsDivisiblebyKLC974 {

    static int subarraysDivByK(int[] nums, int K) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            if(K!=0)sum%=K;
            if(sum<0)sum+=K;
            count+=map.getOrDefault(sum,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a[]={4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(a,5));
    }
}