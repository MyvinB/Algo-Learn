package LeetCodeChallenge.Sep2022.DpPractise;

public class LC1092 {


    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("brute","groot"));
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        return  tabulation(str1,str2);
    }


    public static String tabulation(String text1,String text2){
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
        int i = n1;
        int j = n2;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                sb.append(text1.charAt(i-1));
                i = i-1;
                j= j-1;
            }
            else if (dp[i-1][j] == dp[i][j]){
                sb.append(text1.charAt(i-1));
                i = i-1;
            }else  {
                sb.append(text2.charAt(j-1));
                j= j-1;
            }
        }

        while(i>0){
            sb.append(text1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(text2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}
