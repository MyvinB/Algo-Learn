package LeetCodeChallenge.Oct2022.PrefixSum;

import java.util.HashMap;

public class LC974 {

    public static void main(String[] args) {
        int[] t = new int[]{4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(t,5));
    }

    public static int subarraysDivByK(int[] nums, int K) {
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
}
