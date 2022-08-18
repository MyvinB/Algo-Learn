package LeetCodeChallenge.Aug2022.DpPractise;

import java.util.Arrays;
import java.util.List;

public class TriangleMinimumPathSum {

    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
//        int[][] dp = new int[n][n];
//        for(int row[]: dp)
//            Arrays.fill(row,-1);
//        return recurMemo(triangle,0,0,n,dp);
        return spaceOpti(triangle);
    }

    /*
    * Remeber the reason here we are starting from zero is that already calculated values do not overlap
    * */
    public int spaceOpti(List<List<Integer>> triangle){
        int n = triangle.size();
        int[] dp = new int[n];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                if(i==n-1) dp[j] = triangle.get(i).get(j);
                else{
                    int down = dp[j];
                    int dig = dp[j+1];
                    dp[j] = triangle.get(i).get(j) + Math.min(down,dig);
                }
            }
        }
        return dp[0];


    }

    public int tabulation(List<List<Integer>> triangle,int n){
        int[][] dp = new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==n-1) dp[i][j] = triangle.get(i).get(j);
                else {
                    int down = dp[i+1][j];
                    int dig = dp[i+1][j+1];
                    dp[i][j] = triangle.get(i).get(j) + Math.min(down,dig);
                }
            }
        }
        return dp[0][0];
    }


    public int recurMemo(List<List<Integer>> triangle,int i,int j,int n,int[][] dp){
        //base case
        if(i==n-1) return triangle.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int down = recurMemo(triangle,i+1,j,n,dp);
        int dig = recurMemo(triangle,i+1,j+1,n,dp);
        int res = triangle.get(i).get(j) + Math.min(down,dig);
        return dp[i][j]=res;
    }

    public int recur(List<List<Integer>> triangle,int i,int j,int n){
        //base case
        if(i==n-1) return triangle.get(i).get(j);
        int down = recur(triangle,i+1,j,n);
        int dig = recur(triangle,i+1,j+1,n);
        int res = triangle.get(i).get(j) + Math.min(down,dig);
        return res;
    }
}
