package Contest.LeetCode;

/**
 * @author mmichaelbarboza
 * on 4:43 AM 3/28/2022
 * Time Taken:
 */
//Upsolve
public class FindPalindromeWithFixedLength {

    public static void main(String[] args) {
        System.out.println(3%2);
        System.out.println("99".substring(1));
    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long ans[] = new long[n];
        int i =0;
        //+1 to handle odd cases
        int half = intLength+1/2;
        long l = (long) Math.pow(10,half-1);
        long r = (long) Math.pow(10,half)-1;
        long totalCount = r-l+1;
        for(int q:queries){
            if(q<=totalCount){
                String left = Long.toString(l+q-1);
                String right = new StringBuilder(left).reverse().toString();
                ans[i] = Long.parseLong(left+right);
            }else {
                ans[i] = -1;
            }
            i++;
        }
        return ans;


    }
}
