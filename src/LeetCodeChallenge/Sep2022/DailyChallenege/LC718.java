package LeetCodeChallenge.Sep2022.DailyChallenege;

public class LC718 {

    public static void main(String[] args) {
        //[1,0,0,0,1]
        //[1,0,0,1,1]
        int[] t = new int[]{1,0,0,0,1};
        int[] p = new int[]{1,0,0,1,1};
        System.out.println(findLength(t,p));
    }

    public static int findLength(int[] nums1, int[] nums2) {
        int[] aux = new int[1];
        return tabulation(nums1,nums2);
//        return aux[0];
    }

    public static int recurMemo(int[] nums1,int i, int[] nums2,int j,int[] aux){
        if(i==nums1.length || j==nums2.length) return 0;
        int length = 0;
        if(nums1[i]==nums2[j]){
             length = 1 + recurMemo(nums1,i+1,nums2,j+1,aux);
             aux[0] = Math.max(length,aux[0]);
        }
        //Even if we find something there is possibility of something bigger hence check for all indexs
        recurMemo(nums1,i+1,nums2,j,aux);
        recurMemo(nums1,i,nums2,j+1,aux);
        return length;
    }

    public static int tabulation(int[] nums1,int[] nums2){
        int n = nums1.length,n1= nums2.length;
        int[][] dp = new int[n+1][n1+1];
        int max = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=n1-1;j>=0;j--){
                if(nums1[i]==nums2[j]){
                    dp[i][j] = 1 + dp[i+1][j+1];
                    max = Math.max(dp[i][j],max);
                }
            }
        }
        return max;
    }
}
