package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 6:57 AM 1/31/2022
 */
public class LC1672 {

    public static void main(String[] args) {

    }

    public int maximumWealth(int[][] accounts) {
        //one liner only thing to learn from this problem
       // return Arrays.stream(accounts).mapToInt(i -> Arrays.stream(i).sum()).max().getAsInt();
        if(accounts == null || accounts.length==0) return 0 ;
        int m = accounts.length;
        int n = accounts[0].length;
        int max = Integer.MIN_VALUE;
        for(int[] account:accounts ){
            int sum=0;
            for (int i = 0; i <n ; i++) {
                sum += account[i];
                max=Math.max(max,sum);
            }
        }
        return max;
    }

}
