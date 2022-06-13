package LeetCodeChallenge.JUNE2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC120 {

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(-10));
        System.out.println(minimumTotal(res));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        //its a rule if you developed the recurrance realtion top down then the tablation should be bottom up
        int m = triangle.size();
        int[] dp = new int[m];
        for(int i=0;i<m;i++){
            dp[i] = triangle.get(m-1).get(i);
        }
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int cur = triangle.get(i).get(j);
                int down = dp[j];
                int diagonal = dp[j+1];
                dp[j] = cur + Math.min(down,diagonal);
            }
        }
        return dp[0];
    }
}
