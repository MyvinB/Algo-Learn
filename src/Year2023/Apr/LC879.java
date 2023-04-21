package Year2023.Apr;

import java.util.Arrays;

public class LC879 {

    public static void main(String[] args) {
        int[] group = new int[]{66,24,53,49,86,37,4,70,99,68,14,91,70,71,70,98,48,26,13,86,4,82,1,7,51,37,27,87,2,65,93,66,99,28,17,93,83,91,45,3,59,87,92,62,77,21,9,37,11,4,69,46,70,47,28,40,74,47,12,3,85,16,91,100,39,24,52,50,40,23,64,22,2,15,18,62,26,76,3,60,64,34,45,40,49,11,5,8,40,71,12,60,3,51,31,5,42,52,15,36};
        int[] profit = new int[]{8,4,8,8,9,3,1,6,7,10,1,10,4,9,7,11,5,1,7,4,11,1,5,9,9,5,1,10,0,10,4,1,1,1,6,9,3,6,2,5,4,7,8,5,2,3,0,6,4,5,9,9,10,7,1,8,9,6,0,2,9,2,2,8,6,10,3,4,6,1,10,7,5,4,8,1,8,5,5,4,1,1,10,0,8,0,1,11,5,4,7,9,1,11,1,0,1,6,8,3};
        int minProfit =  10;
        int n = 100;
        System.out.println(profitableSchemes(n,minProfit,group,profit));
    }

    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[profit.length][n+1][minProfit+1];
        for(int[][] d:dp){
            for(int[] e:d )
            Arrays.fill(e,-1);
        }
        return recurMemo(n,minProfit,group,profit,0,0, dp);
    }

    public static int recurMemo(int n,int minProfit ,int[] group,int[] profit,int i, int totalProfit, int[][][] dp){
        if(i==profit.length ){
            if(totalProfit>=minProfit) return 1;
            else return 0;
        }
        int mod= (int) (1e9+7);
        int p = Math.min(minProfit,totalProfit);
        if(dp[i][n][p]!=-1) return dp[i][n][p];
        int take  = 0;
        if(n-group[i]>=0)
            take =recurMemo(n-group[i],minProfit,group,profit,i+1,totalProfit+profit[i],dp)%mod;;
        // do not take the solution
        int noTake = recurMemo(n,minProfit,group,profit,i+1,totalProfit,dp)%mod;
        return dp[i][n][p]=(take+noTake)%mod;
    }

}
