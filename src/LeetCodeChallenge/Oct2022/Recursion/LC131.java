package LeetCodeChallenge.Oct2022.Recursion;

import java.util.ArrayList;
import java.util.List;

public class LC131 {

    public static void main(String[] args) {

    }

    public List<List<String>> partition(String s) {
        //Creating a palindrome dp array
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<=2|| dp[j+1][i-1])){
                    dp[j][i] = true;
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        recurDfs(s,0,res,new ArrayList<>(),dp);
        return res;
    }

    public void recurDfs(String s,int i,List<List<String>> res,List<String> path,boolean[][] dp){
        if(i==s.length()){
            res.add(new ArrayList<>(path)); return;
        }
        for(int k=i ;k<s.length();k++){
            if(dp[i][k]){
                path.add(s.substring(i,k+1));
                recurDfs(s,k+1,res,path,dp);
                path.remove(path.size()-1);
            }
        }
    }



}
