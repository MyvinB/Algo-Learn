package LeetCodeChallenge.JUNE2022;

public class LC5II {

    public static void main(String[] args) {
        String s = "bb";
        System.out.println(longestPalindrome("bb"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = 1;
        }
        int max = 1;
        int start=0;
        for(int k=2;k<=n;k++){
            for(int i=0;i<=n-k;i++){
                int j = i+k-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(k==2){
                        max = 2;
                        dp[i][j] = 1;
                        start = i;
                    }
                    else{
                        if(dp[i+1][j-1]==1){
                            dp[i][j]=1;
                            if(k>max){
                                max = k;
                                start = i;
                            }
                        }
                    }
                }
            }
        }
        return s.substring(start,start+max);
    }
}
