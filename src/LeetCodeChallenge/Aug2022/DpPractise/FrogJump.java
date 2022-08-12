package LeetCodeChallenge.Aug2022.DpPractise;

public class FrogJump {

    public static void main(String[] args) {
        int[] h1 = new int[]{10, 20, 30, 10};
        System.out.println(frogJump(h1.length,h1));

    }

    public static int frogJump(int n, int heights[]) {

//        return recur(n-1,heights);
        return state(heights,n);
    }

    public static int recur(int idx,int heights[]){
        if(idx==0) return 0;
        int jump2 = Integer.MAX_VALUE;
        int jump1 = recur(idx-1,heights) + Math.abs(heights[idx]-heights[idx-1]);
        if(idx>1)
            jump2 = recur(idx-2,heights) + Math.abs(heights[idx]-heights[idx-2]);
        return Math.min(jump1,jump2);
    }

    public static int tabulation(int[] heights,int n){
        int[] dp = new int[n+1];
        for(int i=1;i<n;i++){
            int left = dp[i-1]+Math.abs(heights[i]-heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1) right = dp[i-2]+Math.abs(heights[i]-heights[i-2]);

            dp[i] = Math.min(left,right);
        }
        return dp[n-1];
    }

    public static int state(int[] heights,int n){
        int[] dp = new int[n+1];
        int cur = 0;
        int prev1 = 0;
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int jump1 = prev1+Math.abs(heights[i]-heights[i-1]);
            int jump2 = Integer.MAX_VALUE;
            if(i>1) jump2 = prev2+Math.abs(heights[i]-heights[i-2]);
            cur = Math.min(jump2,jump1);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
