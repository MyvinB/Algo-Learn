package LeetCodeChallenge.Aug2022.DpPractise;

public class UniquePath {

    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        return spaceOptimisation(m,n);
    }

    /*
    * If there is a prev row and prev column use space optimisation
    * */
    public int spaceOptimisation(int m,int n){
        int[] dp = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[j]=1;
                else {
                    int left = 0;
                    int up = 0;
                    if(j>0)left = dp[j-1];
                    if(i>0)up = dp[j];
                    dp[j] = left+up;
                }
            }
        }
        return dp[n-1];
    }

    public int tabulation(int m,int n){
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j]=1;
                else {
                    int left = 0;
                    int up = 0;
                    if(j>0)left = dp[i][j-1];
                    if(i>0)up = dp[i-1][j];
                    dp[i][j] = left+up;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int recurMemo(int i, int j,int[][] dp){
        //base case
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int left = recurMemo(i,j-1,dp);
        int up = recurMemo(i-1,j,dp);
        return dp[i][j] =left+up;
    }



    public int recur(int i, int j){
        //base case
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        int left = recur(i,j-1);
        int up = recur(i-1,j);
        return left+up;
    }
}
