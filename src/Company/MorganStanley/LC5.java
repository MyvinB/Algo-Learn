package Company.MorganStanley;

/**
 * @author mmichaelbarboza
 * on 12:19 PM 2/24/2022
 * Time Taken:
 */
public class LC5 {

    public static void main(String[] args) {

    }
    //O(N)2 complexity we can do better 
    public String longestPalindrome(String s) {
        int n = s.length()+1;
        int[][] dp = new int[n][n];
        // Teh diagonal is a palindrome
        for(int i =0;i<n;i++) dp[i][i] = 1;
        int max = 1;
        int start = 0;
        for(int k=2;k<=n;k++){
            for(int i=0;i<n-k;i++){
                int j = i+k-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(k==2){
                        dp[i][j]=1;
                        max=k;
                        start = i;
                    }
                    else if(dp[i+1][j-1]==1){
                        dp[i][j]=1;
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
