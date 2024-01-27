package Year2023.Feb;

import java.util.Arrays;

public class LC72 {

    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        return recurMemo(word1,word2,word1.length()-1,word2.length()-1,dp);
    }

    public int recurMemo(String word1,String word2,int i,int j,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=recurMemo(word1,word2,i-1,j-1,dp);
        }
        else{
            int insert = recurMemo(word1,word2,i,j-1,dp);
            int delete = recurMemo(word1,word2,i-1,j,dp);
            int replace = recurMemo(word1,word2,i-1,j-1,dp);
            return dp[i][j]=1+Math.min(replace,Math.min(insert,delete));
        }
    }
}
