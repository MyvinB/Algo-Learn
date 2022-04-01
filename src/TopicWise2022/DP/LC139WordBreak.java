package TopicWise2022.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 2:44 PM 4/1/2022
 * Time Taken:
 */
public class LC139WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordBreak(s,wordDict);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] == 1 && set.contains(s.substring(j,i))){
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[n]==1;
    }
}
