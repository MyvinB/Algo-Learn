package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 9:49 PM 3/1/2022
 * Time Taken:
 */
public class LC338 {
    public static void main(String[] args) {

    }

    public int[] countBits(int n) {
        int[] ar = new int[n+1];
        for(int i=1;i<=n;i++){
            if(i%2==0){
                ar[i] = ar[i/2];
            }
            else ar[i] = ar[i-1]+1;
        }
        return ar;
    }
}
