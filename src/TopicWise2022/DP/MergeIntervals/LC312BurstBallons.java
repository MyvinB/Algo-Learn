package TopicWise2022.DP.MergeIntervals;

public class LC312BurstBallons {

    public static void main(String[] args) {

    }
    //https://www.youtube.com/watch?v=IFNibRVgFBo&t=567s
    //https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/BurstBalloons.java
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] T= new int[n][n];
        for(int len=1;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j = i+len-1;
                for(int k=i;k<=j;k++){
                    int leftValue = 1;
                    int rightValue = 1;
                    if(i!=0){
                        leftValue = nums[i-1];
                    }
                    if(j!=n-1){
                        rightValue = nums[j+1];
                    }
                    //before is initially 0. If k is i then before will
                    //stay 0 otherwise it gets value T[i][k-1]
                    //after is similarly 0 initially. if k is j then after will
                    //stay 0 other will get value T[k+1][j]
                    int before = 0;
                    int after = 0;
                    if(k!=i){
                        before = T[i][k-1];
                    }
                    if(k!=j){
                        after = T[k+1][j];
                    }
                    int val = before + after + (leftValue * nums[k] * rightValue);
                    T[i][j] = Math.max(T[i][j],val);
                }
            }
        }
        return T[0][n-1];

    }
}
