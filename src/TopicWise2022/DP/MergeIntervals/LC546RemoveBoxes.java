package TopicWise2022.DP.MergeIntervals;

public class LC546RemoveBoxes {


    public int removeBoxes(int[] boxes) {
        if(boxes == null || boxes.length == 0){
            return 0;
        }
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return get(dp,boxes,0,n-1,0);
    }

    private int get(int[][][] dp,int[] boxes,int left,int right,int streak){
        if(left>right){
            return 0;
        } else if (left == right) {
            return (streak+1) * (streak+1);
        } else if( dp[left][right][streak]!=0){
            return dp[left][right][streak];
        } else {
            int max = get(dp,boxes,left+1,right,streak)+ (streak+1)*(streak+1);

            for(int i=left+1;i<=right;i++){
                if(boxes[left] ==boxes[i+1]){
                    max = Math.max(max,get(dp,boxes,left+1,i-1,0)+get(dp,boxes,i,right,streak+1));
                }
            }
            dp[left][right][streak] = max;
            return max;
        }
    }
}
