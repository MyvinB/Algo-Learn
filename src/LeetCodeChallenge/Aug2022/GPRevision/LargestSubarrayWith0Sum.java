package LeetCodeChallenge.Aug2022.GPRevision;

import java.util.HashMap;

public class LargestSubarrayWith0Sum {

    public static void main(String[] args) {
        int[] t = new int[]{15,-2,2,-8,1,7,10,23};
        System.out.println(maxLen(t,t.length));

    }

    static int maxLen(int arr[], int n)
    {
        int max = Integer.MIN_VALUE;
        int preSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            preSum += arr[i];
            if(preSum==0){
                max = i+1;
            }else{
                if(map.containsKey(preSum)){
                    max = Math.max(max,i-map.get(preSum));
                }else{
                    map.put(preSum, i);
                }
            }
        }
        return max;
    }
}
