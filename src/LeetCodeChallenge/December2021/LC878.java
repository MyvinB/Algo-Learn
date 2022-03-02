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
        long a = A, b = B,l = 2, r = (long)1e14, mod = (long)1e9 + 7;
        long tmp;
        while(b>0){
            tmp=a;
            a = b;
            b = tmp%b;
        }
        System.out.println("practise.GCD IS "+a);
        while(l<r){
            long m = (l+r)/2;
            if(m/A+m/B-m/(A*B/a)<n)l=m+1;
            else r=m;
        }
        return (int)(l%mod);

    }
}
