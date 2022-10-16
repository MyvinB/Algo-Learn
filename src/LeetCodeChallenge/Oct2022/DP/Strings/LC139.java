package LeetCodeChallenge.Oct2022.DP.Strings;

import java.util.Arrays;
import java.util.List;

public class LC139 {

    public static void main(String[] args) {
//        "leetcode"
//                ["leet","code"]
        String s = "leetcode";
        String s1 = "aaaaaaa";
        List<String> wordDict1 = Arrays.asList("leet","code");
        List<String> wordDict = Arrays.asList("aaaa","aaa");
        System.out.println(wordBreak(s1,wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n= s.length();
        int[][] dp = new int[n][n+1];
        for(int[] e:dp) Arrays.fill(e,-1);
        return recurMemo(s,wordDict,0,1,dp)==1;
    }

    public static int recurMemo(String s, List<String> wordDict, int prevIdx,int curIdx,int[][] dp) {
        if(curIdx==s.length() && wordDict.contains(s.substring(prevIdx,curIdx))) return 1;
        if(curIdx==s.length()) return 0;
        if(dp[prevIdx][curIdx]!=-1) return dp[prevIdx][curIdx];
        int flag = 0;
        //Take the word not take the word
        int take = 0;
        if(wordDict.contains(s.substring(prevIdx,curIdx))){
            take = recurMemo(s,wordDict,curIdx,curIdx+1,dp);
        }
        int notTake = recurMemo(s,wordDict,prevIdx,curIdx+1,dp);
        if(take==1 || notTake==1){
            return dp[prevIdx][curIdx]=1;
        }else return dp[prevIdx][curIdx]=0;

    }



    //Lets save stack space and memory space known soln requires a bit of remembering the above if you just forget this one the above one is very intutive
    public boolean tabulation(String s,List<String> wordDict){
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=0;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j]==1 && wordDict.contains(s.substring(j,i))){
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[n]==1;
    }
}
