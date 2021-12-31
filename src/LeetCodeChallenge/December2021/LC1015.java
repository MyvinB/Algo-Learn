package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 10:26 PM 12/30/2021
 */
public class LC1015 {

    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(4));
    }
    //Important to understand arithmetic modulo
    public static int smallestRepunitDivByK(int k) {
        if(k==2 || k==5) return -1;
        int remainder =0;
        for(int i=1;i<=k;i++){
            remainder = (remainder*10+1)%k;
            if(remainder==0) return i;
        }
        return -1;
    }
}
