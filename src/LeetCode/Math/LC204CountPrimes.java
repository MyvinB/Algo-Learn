package LeetCode.Math;/*
 @author Myvin Barboza
 06/08/20 7:41 PM 
 */

import java.util.Arrays;

public class LC204CountPrimes {
    public static void main(String[] args) {

    }

    public int countPrimes(int n) {
        int count=0;
        boolean dp[]=new boolean[n];
        Arrays.fill(dp, true);

        for(int i=2;i*i<n;i++){

            if(dp[i]){
                count++;
                for(int j=2*i;j<n;j=j+i)
                    dp[j]=false;
            }

            //  System.out.println(Arrays.toString(dp));

        }

        for(int i=2;i<n;i++)
            if(dp[i])count++;

        return count;
    }

}
