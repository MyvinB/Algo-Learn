package LeetCodeChallenge.Sep2022.DpPractise;

public class DP30 {

    public static void main(String[] args) {

    }

    public static int canYouMake(String str, String ptr) {
        int a = tabulation(str,ptr);
        return str.length()+ptr.length()-2 *a;
    }

    //Copuied code
    public static int tabulation(String text1,String text2){
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 +dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
