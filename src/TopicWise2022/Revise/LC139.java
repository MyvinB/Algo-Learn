package TopicWise2022.Revise;

import java.util.HashSet;
import java.util.List;

public class LC139 {

    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length() ,dp[]= new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j]==1 && wordDict.contains(s.substring(j,i))){
                    dp[i] =1;
                }
            }
        }
        return dp[n]==1;
    }
}
