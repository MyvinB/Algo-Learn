package LeetCode.DP;
/*
 @author Myvin Barboza
 31/05/20 7:41 AM 
 */

public class LC1035UncrossedLines {

    static int maxUncrossedLines(int[] A, int[] B) {
        int dp[][]=new int[A.length+1][B.length+1];
        for (int i = 1; i <=A.length ; i++) {
            for (int j = 1; j <=B.length ; j++) {
                if(A[i-1]==B[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[A.length][B.length];
    }


    public static void main(String[] args) {
        int a[]={1,4,2};
        int b[]={1,2,4};
        System.out.println(maxUncrossedLines(a,b));
    }
}