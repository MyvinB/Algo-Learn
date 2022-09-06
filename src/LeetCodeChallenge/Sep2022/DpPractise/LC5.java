package LeetCodeChallenge.Sep2022.DpPractise;

public class LC5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) dp[i][i]= 1;
        int max = 1;
        int stI = 0;
        for(int k=2;k<=n;k++){
            for(int i=0;i<=n-k;i++){
                int j = i+k-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(k==2){
                        dp[i][j] = 1;
                        max = 2;
                        stI = i;
                    }else{
                        if(dp[i+1][j-1]==1){
                            stI = i;
                            dp[i][j] = 1;
                            max = Math.max(max,k);
                        }
                    }

                }
            }
        }
        return s.substring(stI,stI+max);
    }
}
