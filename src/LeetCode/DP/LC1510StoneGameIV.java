package LeetCode.DP;

public class LC1510StoneGameIV {
    public static void main(String[] args) {
        System.out.println(winnerSquareGame(7));
    }
    /*
    if there is any k that dp[i - k * k] == false,
    it means we can make the other lose the game,
    so we can win the game an dp[i] = true.
     */
    static boolean winnerSquareGame(int n) {
        boolean dp[] =new boolean[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1; j*j<=i;j++){
                if(!dp[i-j*j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
