package LeetCodeChallenge.JULY2021;

public class LC718 {

    public static int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int ans = 0;
        int dp [][]= new int[m+1][n+1];
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    System.out.println(nums1[i-1]);
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(dp[i][j],ans);     
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        findLength(new int[]{3,2,1,4,7},new int[]{1,2,3,2,1});
    }
}
