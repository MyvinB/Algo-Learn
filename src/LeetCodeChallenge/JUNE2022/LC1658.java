package LeetCodeChallenge.JUNE2022;

import java.util.HashMap;

public class LC1658 {

    public static void main(String[] args) {
        int[] t = new int[]{3,2,20,1,1,3};
        System.out.println(minOperations(t,10));
    }

        public static int minOperations(int[] nums, int x) {
           int n = nums.length;
           HashMap<Integer,Integer> map = new HashMap<>();
           map.put(0,0);
           int sum =0,preFixSum = 0;
           int longestRestSum = -1;
           for(int i=0;i<n;i++) sum+= nums[i];
           int k = sum-x;
           for(int i=0;i<n;i++){
               preFixSum +=nums[i];
               map.put(preFixSum,i);
               if(map.containsKey(preFixSum-k)){
                   if(preFixSum-k==0){
                       longestRestSum = Math.max(longestRestSum,i-map.get(preFixSum-k)+1);
                   }else {
                       longestRestSum = Math.max(longestRestSum,i-map.get(preFixSum-k));
                   }

               }
           }
           if(longestRestSum==-1) return -1;
           return  n-longestRestSum;
        }
}
