package TopicWise2022.DP.MAXANDMIN;

/**
 * @author mmichaelbarboza
 * on 7:15 AM 4/7/2022
 * Time Taken:
 */
public class LC650 {

    public static void main(String[] args) {

    }

    public static int minSteps(int n) {
        int[] dp = new int[n+1];
        for(int i=2;i<=n;i++){
            dp[i] = i;
            for(int j= i-1;j>1;j--){
                // if sequence of length 'j' can be pasted multiple times to get length 'i' sequence
                if(i%j==0){
                    // we just need to paste sequence j (i/j - 1) times, hence additional (i/j) times since we need to copy it first as well.
                    // we don't need checking any smaller length sequences
                    dp[i] = dp[j] +i/j;
                    break;
                }
            }
        }
        return dp[n];
    }
}
