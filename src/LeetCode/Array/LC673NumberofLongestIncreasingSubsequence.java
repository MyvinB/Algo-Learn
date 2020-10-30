package LeetCode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC673NumberofLongestIncreasingSubsequence {

    public static void main(String[] args) {
    int test[]={5,8,7,1,9};
    int test2[]={2,2,2,2,2};
    int test3[]={100,90,80,70,60,50,60,70,80,90,100};
        System.out.println(findNumberOfLIS(test3));
}





    static int findNumberOfLIS(int[] nums) {
       int n=nums.length;
       int len[]=new int[n];
       int count[]=new int[n];
       int max=0;
       Arrays.fill(len,1);
       Arrays.fill(count,1);
       for(int i=1;i<n;i++){
           for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(len[i]<=len[j]){
                        len[i]=len[j]+1;
                        count[i]=count[j];
                    }
                    else if(len[j]+1==len[i]){
                        count[i]+=count[j];
                    }
                }
           }
       }

       for(int i=0;i<n;i++){
           max=Math.max(max,len[i]);
       }
        System.out.println(max);
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(len));
        int ans=0;
       for(int i=0;i<n;i++){
           if(len[i]==max)
               ans+=count[i];
       }
       return ans;
    }
}
