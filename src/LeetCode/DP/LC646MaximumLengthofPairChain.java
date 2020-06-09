package LeetCode.DP;
/*
 @author Myvin Barboza
 09/06/20 7:51 AM 
 */

import java.util.Arrays;

public class LC646MaximumLengthofPairChain {


    static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]+a[1]-b[1]);
        int dp[]=new int[pairs.length];
        int max=0;
        Arrays.fill(dp,1);
        System.out.println(Arrays.deepToString(pairs));
        for (int i = 0; i <pairs.length ; i++) {
            int c[]=pairs[i];
            for (int j = 0; j <i ; j++) {
            int d[]=pairs[j];
            if(d[1]<c[0] && dp[j]+1>dp[i])
                dp[i]=dp[j]+1;
            }
            max=Math.max(dp[i],max);
        }

        return max;

    }


    //static int findLongestChain(int[][] pairs) {}




    public static void main(String[] args) {
        int a[][]={{3,4},{2,3},{1,2}};
        System.out.println(findLongestChain(a));
    }
}