package LeetCode.DP;
/*
 @author Myvin Barboza
 08/06/20 6:31 PM 
 */

import java.util.Arrays;

public class LC354RussianDollEnvelopes {


    static int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes,(a, b)->((a[0]-b[0])+a[1]-b[1]));
        System.out.println(Arrays.deepToString(envelopes));
    int dp[]=new int[envelopes.length];
    Arrays.fill(dp,1);
    int max=0;
    for(int i=1;i<envelopes.length;i++){
        int c[]=envelopes[i];
        for(int j=0;j<i;j++){
           int d[]=envelopes[j];
            if(d[0]<c[0] && d[1]<c[1] && dp[j]+1>dp[i]){
                dp[i]=dp[j]+1;
            }
        }

        if(dp[i]>max)max=dp[i];
    }

    return max;


    }


    public static void main(String[] args) {
        int p[][]={{6,10},{11,14},{6,1},{16,14},{13,2}};
        System.out.println(maxEnvelopes(p));
    }
}