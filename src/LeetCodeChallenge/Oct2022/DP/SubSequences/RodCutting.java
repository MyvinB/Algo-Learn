package LeetCodeChallenge.Oct2022.DP.SubSequences;
/*
* *
5 -
2 5 7 8 10 Ans-> 12
8
3 5 8 9 10 17 17 20 ANS -> 24
 * */
public class RodCutting {

    public static void main(String[] args) {

    }

    //Not doing the memo part just need it to tabulate
    public int recurMemo(int[] price,int lenLeft, int idx){
        if(idx==0){
            return price[0] * lenLeft;
        }
        int rodLen = idx+1;
        int notake = recurMemo(price,lenLeft,idx-1);
        int take = Integer.MIN_VALUE;
        if(rodLen<=lenLeft){
            //Note that we can take the same rod len again thats why not moving the index;
            take =  price[idx] +recurMemo(price,lenLeft-rodLen,idx);
        }
        return Math.max(take,notake);
    }

    public int tabulation(int[] price,int n){
        int[][] dp = new int[n][n+1];
        for(int i=0;i<=n;i++) dp[0][i] = i * price[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=n;j++){
                int rodLen = i+1;
                int notake = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(rodLen<=j){
                    take = price[i] + dp[i][j-rodLen];
                }
                dp[i][j] = Math.max(take,notake);
            }
        }

        return dp[n-1][n];
    }

    public int spaceOpti(int[] price,int n){
        int[] dp = new int[n+1];
        for(int i =0;i<=n;i++) dp[i] = price[0] * i;
        for(int i=1;i<n;i++){
            for(int j=0;j<=n;j++){
                int rodLen = i+1;
                int notake = dp[j];
                int take = Integer.MIN_VALUE;
                if(rodLen<=j){
                    take = price[i] +dp[j-rodLen];
                }
                dp[j] = Math.max(take,notake);
            }
        }
        return dp[n];
    }
}
