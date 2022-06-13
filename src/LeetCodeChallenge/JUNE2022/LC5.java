package LeetCodeChallenge.JUNE2022;

public class LC5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int max = 1;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) dp[i][i] = 1;
        for(int k=2;k<=n;k++){
            for(int i=0;i<=n-k;i++){
                int j = i+k-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(k==2){
                        dp[i][j]= 1;
                        max = 2;
                        start = i;
                    }
                    else if(dp[i+1][j-1]==1){
                        dp[i][j]= 1;
                        if(k>max){
                            max = k;
                            start = i;
                        }
                    }
                }
            }
        }
        return s.substring(start,start+max);
    }
}
