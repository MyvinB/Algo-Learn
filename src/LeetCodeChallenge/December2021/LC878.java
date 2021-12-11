package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 12:30 PM 12/11/2021
 */
public class LC878 {

    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(4,2,3));
    }

    public static int nthMagicalNumber(int n, int A, int B) {
        long a = A, b = B, mod = (long)1e9 + 7;
        long tmp;
        while(b>0){
            tmp=a;
            a = b;
            b = tmp%b;
        }
        System.out.println("GCD IS "+a);
        long res = (n*A*B) /(A+B-a);
        return (int)res;
    }
}
