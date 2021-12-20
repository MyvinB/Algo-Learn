package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 3:42 PM 12/20/2021
 */
public class LC2110 {

    public static void main(String[] args) {
        int[] a = {4,3,2,1,6,7};
        System.out.println(getDescentPeriods(a));
    }

    public static long getDescentPeriods(int[] prices) {
        int start=0;
        int end = 0;
        long ans = 1;
        for(end=1;end<prices.length;end++){
           if(prices[end] == prices[end - 1] - 1){
               ans += end-start +1;
           }
           else{
               start = end;
               ans += end-start+1;
           }
        }
        return ans;
    }
}
