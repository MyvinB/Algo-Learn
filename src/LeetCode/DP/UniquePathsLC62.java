package LeetCode.DP;

import java.util.Arrays;

/*
 @author Myvin Barboza
 10/04/20 8:28 AM 
 */
public class UniquePathsLC62 {
    //recurrsive soln
    static int RecurUniquePaths(int m, int n) {

    if(m==1||n==1){
        return 1;
    }
    else{
        return  RecurUniquePaths(m-1,n)+RecurUniquePaths(m,n-1);
        }


    }
    //dynamic programming
    static int DynamicUniquePaths(int m, int n) {
        int dp[][]=new int[n][m];
        for (int i = 0; i <dp.length ; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i <dp[0].length ; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 1; j <dp[i].length ; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
       // System.out.println(Arrays.deepToString(dp));

    }

    static int uniquePathsWithObstacles(int[][] dp) {
    int count[][]=new int[dp.length][dp[0].length];
    if(dp[0][0]==0)count[0][0]=1;
        for (int i = 1; i <dp.length ; i++) {
            if(dp[i][0]==0)count[i][0]=count[i-1][0];
        }
        for (int i = 1; i <dp[0].length ; i++) {
            if(dp[0][i]==0)count[0][i]=count[0][i-1];
        }
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 1; j <dp[0].length ; j++) {
                if(dp[i][j]==0){
                    count[i][j]=count[i-1][j]+count[i][j-1];
                }
            }
        }
        return count[dp.length-1][dp[0].length-1];
    }


    public static void main(String[] args) {
    int m=3 ,n=2;;
//        System.out.println(RecurUniquePaths(m,n));
//        System.out.println(DynamicUniquePaths(m,n));
        int a[][]={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(a));
    }
}