package TopicWise2022.DP.MAXANDMIN;

import java.util.List;

/**
 * @author mmichaelbarboza
 * on 8:57 PM 4/4/2022
 * Time Taken:
 */
public class LC120 {

    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        // its a rule if you developed the recurrance realtion top down then the tablation should be bottom up
        int m = triangle.size();
        int[][] dp = new int[m][m];

        for(int i=0;i<m;i++){
            dp[m-1][i] =  triangle.get(m-1).get(i);
        }
        for(int i=m-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int cur = triangle.get(i).get(j);
                int down = dp[i+1][j];
                int diagonal = dp[i+1][j+1];
                dp[i][j] = cur + Math.min(down,diagonal);
            }
        }
        return dp[0][0];
    }
}
